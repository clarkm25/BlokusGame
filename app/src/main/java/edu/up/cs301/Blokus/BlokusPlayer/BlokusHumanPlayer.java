package edu.up.cs301.Blokus.BlokusPlayer;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;

import edu.up.cs301.Blokus.BlokusActions.BlokusHelpMenuAction;
import edu.up.cs301.Blokus.BlokusActions.BlokusQuitAction;
import edu.up.cs301.Blokus.BlokusActions.BlokusRotateAction;
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
    private int layoutId; //ID
    protected BlokusGameState blokusState;

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

        GameAction action = null;
        if (view.getId() == R.id.rotateButton) {
            action = new BlokusRotateAction(this);
        }
        else if (view.getId() == R.id.quitButton) {
            action = new BlokusQuitAction(this);
        }
        else if (view.getId() == R.id.helpButton) {
            action = new BlokusHelpMenuAction(this);
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
        int spaceX = 0;
        int spaceY = 0;

        //Player 1's box
        if ((x > DrawBoard.LEFT_BOXES) && (x < DrawBoard.LEFT_BOXES + DrawBoard.PBOX_WIDTH)
                && (y > DrawBoard.TOP_BOXES) && (y < DrawBoard.TOP_BOXES + DrawBoard.PBOX_HEIGHT)) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 6; j++) {
                    if((x > (spaceX + 10 + (DrawBoard.LEFT_BOXES * j))) && (x < (spaceX + 10 + (DrawBoard.LEFT_BOXES * (j + 1)))) &&
                            (y > (spaceY + 10 + (DrawBoard.TOP_BOXES * j))) && (y < (spaceY + 10 + (DrawBoard.TOP_BOXES * (j + 1))))) {


                    }
                    spaceX += 90; //Horizontal space between pieces
                    spaceY += 90; //Vertical space between pieces
                }
            }
        } //Player 2's box
        else if ((x > DrawBoard.RIGHT_BOXES) && (x < DrawBoard.RIGHT_BOXES + DrawBoard.PBOX_WIDTH)
                && (y > DrawBoard.TOP_BOXES) && (y < DrawBoard.TOP_BOXES + DrawBoard.PBOX_HEIGHT)) {
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    if((x > (spaceX + 10 + (DrawBoard.RIGHT_BOXES * j))) && (x < (spaceX + 10 + (DrawBoard.RIGHT_BOXES * (j + 1)))) &&
                            (y > (spaceY + 10 + (DrawBoard.TOP_BOXES * j))) && (y < (spaceY + 10 + (DrawBoard.TOP_BOXES * (j + 1))))) {
                        spaceX += 90; //Horizontal space between pieces
                        spaceY += 90; //Vertical space between pieces
                        /** Does not need to do anything as of now as this is an AI box */
                    }

                }
            }
        } //Player 3's box
        else if ((x > DrawBoard.LEFT_BOXES) && (x < DrawBoard.LEFT_BOXES + DrawBoard.PBOX_WIDTH)
                && (y > DrawBoard.BOTTOM_BOXES) && (y < DrawBoard.BOTTOM_BOXES + DrawBoard.PBOX_HEIGHT)) {
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    if((x > (spaceX + 10 + (DrawBoard.LEFT_BOXES * j))) && (x < (spaceX + 10 + (DrawBoard.LEFT_BOXES * (j + 1)))) &&
                            (y > (spaceY + 10 + (DrawBoard.BOTTOM_BOXES * j))) && (y < (spaceY + 10 + (DrawBoard.BOTTOM_BOXES * (j + 1))))) {
                        spaceX += 90; //Horizontal space between pieces
                        spaceY += 90; //Vertical space between pieces
                        /** Does not need to do anything as of now as this is an AI box */
                    }
                }
            }
        } //Player 4's box
        else if ((x > DrawBoard.RIGHT_BOXES) && (x < DrawBoard.RIGHT_BOXES + DrawBoard.PBOX_WIDTH)
                && (y > DrawBoard.BOTTOM_BOXES) && (y < DrawBoard.BOTTOM_BOXES + DrawBoard.PBOX_HEIGHT)) {
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    if((x > (spaceX + 10 + (DrawBoard.RIGHT_BOXES * j))) && (x < (spaceX + 10 + (DrawBoard.RIGHT_BOXES * (j + 1)))) &&
                            (y > (spaceY + 10 + (DrawBoard.BOTTOM_BOXES * j))) && (y < (spaceY + 10 + (DrawBoard.BOTTOM_BOXES * (j + 1))))) {
                        spaceX += 90; //Horizontal space between pieces
                        spaceY += 90; //Vertical space between pieces
                        /** Does not need to do anything as of now as this is an AI box */
                    }
                }
            }
        }

        //Size of grid
        if ((x > 700) && (x < 1300) && (y > 50) && (y < 650)) {
            for (int i = 0; i < 19; i++) {
                for (int j = 0; j < 19; j++) {
                    if ((x > ((j * DrawBoard.GRIDBOX_SIZE) + 700)) && (x < (((j+1) * DrawBoard.GRIDBOX_SIZE) + 700))
                            && (y > ((i * DrawBoard.GRIDBOX_SIZE) + 50)) && (y < (((i+1) * DrawBoard.GRIDBOX_SIZE) + 50))) {
                        blokusState.setCol(j);
                        blokusState.setRow(i);
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
    } //setAsGui
}
