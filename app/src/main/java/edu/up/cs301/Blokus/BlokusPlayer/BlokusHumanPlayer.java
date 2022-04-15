package edu.up.cs301.Blokus.BlokusPlayer;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;

import edu.up.cs301.Blokus.BlokusActions.BlokusHelpMenuAction;
import edu.up.cs301.Blokus.BlokusActions.BlokusPassAction;
import edu.up.cs301.Blokus.BlokusActions.BlokusPlaceAction;
import edu.up.cs301.Blokus.BlokusActions.BlokusQuitAction;
import edu.up.cs301.Blokus.BlokusActions.BlokusRotateAction;
import edu.up.cs301.Blokus.BlokusActions.BlokusSelectAction;
import edu.up.cs301.Blokus.BlokusInfo.BlokusGameState;
import edu.up.cs301.Blokus.BlokusViews.DrawBoard;
import edu.up.cs301.game.GameFramework.GameMainActivity;
import edu.up.cs301.game.GameFramework.actionMessage.GameAction;
import edu.up.cs301.game.GameFramework.infoMessage.GameInfo;
import edu.up.cs301.game.GameFramework.infoMessage.IllegalMoveInfo;
import edu.up.cs301.game.GameFramework.infoMessage.NotYourTurnInfo;
import edu.up.cs301.game.GameFramework.players.GameHumanPlayer;
import edu.up.cs301.game.GameFramework.utilities.Logger;
import edu.up.cs301.game.R;

/**
 * BlokusHumanPlayer
 *
 * GUI for Blokus game. Moves are made through a series of screen touches and button presses which
 * are set up within this class. GUI is only set to landscape mode.
 *
 * @author Max Clark, Skyelar Cann, Gavin Raguindin
 * @version March 31st 2022
 */
public class BlokusHumanPlayer extends GameHumanPlayer implements View.OnTouchListener, View.OnClickListener {

    private static final String TAG = "BlokusHumanPlayer"; //Tag for logging

    //Surface View being drawn on
    private DrawBoard drawBoard;
    protected BlokusGameState blokusState;
    private int layoutId; //ID
    private int selectedPiece;
    private Button quitButton;
    private Button helpButton;
    private Button rotateButton;
    private Button passButton;
    private TextView helpView;

    /**
     * BlokusHumanPlayer
     *
     * ctor for BlokusHumanPlayer
     *
     * @param name
     * @param initLayoutId
     */
    public BlokusHumanPlayer(String name, int initLayoutId) {
        super(name);
        this.layoutId = initLayoutId;
    } //BlokusHumanPlayer

    /**
     * onClick
     *
     * Method for the different buttons that can be used by user. Allows user to quit game, rotate
     * pieces, place pieces, and accessing the help menu.
     *
     * @param view
     */
    @Override
    public void onClick(View view) {
        if (game == null) return;

        //Switches through each button ID and makes an action based on the button
        if (view.getId() == R.id.rotateButton) {
            BlokusRotateAction blokusRA = new BlokusRotateAction(this);
            game.sendAction(blokusRA);
        }
        else if (view.getId() == R.id.quitButton) {
            System.exit(1);
            BlokusQuitAction blokusQA = new BlokusQuitAction(this);
            game.sendAction(blokusQA);
        }
        else if (view.getId() == R.id.helpButton) {
            BlokusHelpMenuAction blokusHMA = new BlokusHelpMenuAction(this, helpView);
            game.sendAction(blokusHMA);
        }
        else if (view.getId() == R.id.passButton) {
            BlokusPassAction blokusPA = new BlokusPassAction(this);
            game.sendAction(blokusPA);
        }
    } //onClick

    /**
     * onTouch
     *
     * Method used to select a piece that will be place on board as well as used to actually place
     * pieces on board based on where the user clicks.
     *
     * @param view
     * @param motionEvent
     * @return true -given that the onTouch method is performed correctly
     */
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int x = (int)motionEvent.getX();
        int y = (int)motionEvent.getY();

        //Player 1's box
        if ((x > DrawBoard.LEFT_BOXES) && (x < DrawBoard.LEFT_BOXES + DrawBoard.PBOX_WIDTH)
                && (y > DrawBoard.TOP_BOXES) && (y < DrawBoard.TOP_BOXES + DrawBoard.PBOX_HEIGHT)) {

            //Sets piece back to beginning
            selectedPiece = 0;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 6; j++) {
                    //Sets space between each piece
                    int spaceX = 10 + DrawBoard.LEFT_BOXES;
                    int spaceY = 10 + DrawBoard.TOP_BOXES;

                    //Iterates through every piece to find selected piece
                    if((x > (spaceX + ((DrawBoard.GRIDBOX_SIZE * 3) * j))) && (x < (spaceX + ((DrawBoard.GRIDBOX_SIZE * 3) * (j+1)))) &&
                            (y > (spaceY + (DrawBoard.GRIDBOX_SIZE * 3) * i)) && (y < (spaceY + (DrawBoard.GRIDBOX_SIZE * 3) * (i + 1)))) {
                        BlokusSelectAction blokusSA = new BlokusSelectAction(this, selectedPiece);
                        game.sendAction(blokusSA);
                    }
                    selectedPiece++; //Increases piece until selected area.
                }
            }
        }

        //Size of grid
        if ((x > 700) && (x < 1300) && (y > 50) && (y < 650)) {
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    //Iterates through ever spot on the grid in order to find where user presses.
                    if ((x > ((j * DrawBoard.GRIDBOX_SIZE) + 700)) && (x < (((j+1) * DrawBoard.GRIDBOX_SIZE) + 700))
                            && (y > ((i * DrawBoard.GRIDBOX_SIZE) + 50)) && (y < (((i+1) * DrawBoard.GRIDBOX_SIZE) + 50))) {
                        BlokusPlaceAction blokusPA = new BlokusPlaceAction(this, selectedPiece, i, j);
                        game.sendAction(blokusPA);
                        drawBoard.invalidate();
                    }
                }
            }
        }

        return false;
    } //onTouch

    @Override
    public View getTopView() {
        return myActivity.findViewById(R.id.top_gui_layout);
    } //getTopView

    @Override
    public void receiveInfo(GameInfo info) {
        if (drawBoard == null) return;

        if (info instanceof IllegalMoveInfo || info instanceof NotYourTurnInfo) {
            drawBoard.flash(Color.RED, 50);
        }
        else if (!(info instanceof BlokusGameState)) {
            return; //If there is no BlokusGameState
        }
        else {
            blokusState = ((BlokusGameState)info);
            drawBoard.setState((BlokusGameState)info);
            drawBoard.invalidate();
            Logger.log(TAG, "receiving");
        }
    } //recieveInfo

    @Override
    public void setAsGui(GameMainActivity activity) {
        activity.setContentView(layoutId);

        drawBoard = (DrawBoard)myActivity.findViewById(R.id.drawBoard);
        Logger.log("set logger", "OnTouch");
        drawBoard.setOnTouchListener(this);

        //Initializes the button variables
        this.quitButton = (Button)activity.findViewById(R.id.quitButton);
        this.helpButton = (Button)activity.findViewById(R.id.helpButton);
        this.rotateButton = (Button)activity.findViewById(R.id.rotateButton);
        this.passButton = (Button)activity.findViewById(R.id.passButton);
        this.helpView = (TextView)activity.findViewById(R.id.helpMenu);

        //Listens for button presses on this GUI
        quitButton.setOnClickListener(this);
        helpButton.setOnClickListener(this);
        rotateButton.setOnClickListener(this);
        passButton.setOnClickListener(this);
    } //setAsGui
}
