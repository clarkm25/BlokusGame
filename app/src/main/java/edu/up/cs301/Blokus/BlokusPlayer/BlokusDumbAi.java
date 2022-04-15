package edu.up.cs301.Blokus.BlokusPlayer;

import edu.up.cs301.Blokus.BlokusActions.BlokusPassAction;
import edu.up.cs301.Blokus.BlokusActions.BlokusPlaceAction;
import edu.up.cs301.Blokus.BlokusActions.BlokusSelectAction;
import edu.up.cs301.Blokus.BlokusInfo.BlokusBlock;
import edu.up.cs301.Blokus.BlokusInfo.BlokusGameState;
import edu.up.cs301.game.GameFramework.infoMessage.GameInfo;
import edu.up.cs301.game.GameFramework.infoMessage.NotYourTurnInfo;
import edu.up.cs301.game.GameFramework.players.GameComputerPlayer;
import edu.up.cs301.game.GameFramework.utilities.Logger;

import java.util.ArrayList;

/**
 * Dumb computer player for Blokus that places first piece in first legal spot.
 *
 * @author Max Clark, Skyelar Cann, Gavin Raguindin
 * @version March 31st 2022
 */
public class BlokusDumbAi extends GameComputerPlayer {

    //21 pieces
    BlokusGameState myState;

    /**
     * BlokusDumbAi
     *
     * Default ctor for the dumb computer player
     *
     * @param name
     */
    public BlokusDumbAi(String name) {
        super(name);
    }

    /**
     * recieveInfo
     *
     * Method that makes action for the dumb computer player.
     *
     * @param info
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        if (info instanceof NotYourTurnInfo) return; //nothing happens if it isn't players turn

        Logger.log("BlokusDumbAi", "My turn!");

        myState = (BlokusGameState)info;

        //Allow for AI to take time between plays
        sleep(3);

        /* Picks a random piece number and sets both selected row and columns to zero */
        int pickedPiece = (int) Math.random()*20;
        int selectedRow = 0;
        int selectedColumn = 0;

        /* Iterates through the board to find the first legal position */
        for(int i = 0; i<20; i++)
        {
            for(int j = 0; j<20; j++)
            {
                if(myState.getBoard()[i][j]== BlokusGameState.tileState.LEGAL)
                {
                    selectedRow = i;
                    selectedColumn = j;
                }
            }
        }

        /* With everything calculated, selects the randomly selected piece */
        game.sendAction(new BlokusSelectAction(this, pickedPiece));

        /* Then, sends an action to place the currently selected piece */
        game.sendAction(new BlokusPlaceAction(this,selectedRow, selectedColumn));
        Logger.log("BlokusDumbAi", "Sending move");
        game.sendAction(new BlokusPassAction(this));
    } //receiveInfo
}
