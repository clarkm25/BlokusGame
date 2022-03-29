package edu.up.cs301.Blokus.BlokusPlayer;

import android.graphics.Color;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

import edu.up.cs301.Blokus.BlokusInfo.BlokusGameState;
import edu.up.cs301.Blokus.BlokusViews.DrawBoard;
import edu.up.cs301.game.GameFramework.GameMainActivity;
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

    } //onClick

    /**
     * onTouch
     *
     *
     *
     * @param view
     * @param motionEvent
     * @return true -given that the onTouch method is performed correctly
     */
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int x = (int)motionEvent.getX();
        int y = (int)motionEvent.getY();
        Path selectedPiece;

        if ((x > 700) && (x < 1300) && (y > 50) && (y < 650)) {
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    if ((x > (i * drawBoard.GRIDBOX_SIZE)) && (x < ((i+1) * drawBoard.GRIDBOX_SIZE))
                            && (y > (i * drawBoard.GRIDBOX_SIZE)) && (y < ((i+1) * drawBoard.GRIDBOX_SIZE))) {

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
