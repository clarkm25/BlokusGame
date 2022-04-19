package edu.up.cs301.Blokus.BlokusPlayer;

import java.util.Random;

import edu.up.cs301.Blokus.BlokusActions.BlokusPassAction;
import edu.up.cs301.Blokus.BlokusActions.BlokusPlaceAction;
import edu.up.cs301.Blokus.BlokusActions.BlokusSelectAction;
import edu.up.cs301.Blokus.BlokusInfo.BlokusGameState;
import edu.up.cs301.game.GameFramework.infoMessage.GameInfo;
import edu.up.cs301.game.GameFramework.infoMessage.NotYourTurnInfo;
import edu.up.cs301.game.GameFramework.players.GameComputerPlayer;
import edu.up.cs301.game.GameFramework.utilities.Logger;

/**
 * Smart computer player for Blokus Game. Computer Player rotates pieces if there is no legal moves
 * without rotation.
 *
 * @author Max Clark, Skyelar Cann, Gavin Raguindin
 * @version March 31st 2022
 */
public class BlokusSmartAi extends GameComputerPlayer {

    //21 pieces
    BlokusGameState myState;

    /**
     * BlokusSmartAi
     *
     * default ctor for smart computer player
     *
     * @param name
     */
    public BlokusSmartAi(String name) {
        super(name);
    } //BlokusSmartAi

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

        Logger.log("BlokusSmartAi", "My turn!");

        myState = (BlokusGameState) info;

        //Allow for AI to take time between plays
        sleep(1);

        /* Picks a random piece number and sets both selected row and columns to zero */
        Random r = new Random();

        int pickedPiece = 0;
        int selectedRow = 0;
        int selectedColumn = 0;
        int piecesLeft = 0;

        //Checks whether or not all the pieces are in player boxes or on the board
        for (int i = 0; i < 21; i++) {
            if (myState.getBlockArray()[playerNum][i].getOnBoard() == false) {
                piecesLeft++;
            }
        }


        //As long as there are pieces left in the AI's box, will continue getting random pieces
        //until it finds one not on the board
        if (piecesLeft != 0) {
            do {
                pickedPiece = r.nextInt(21);
            } while (myState.getBlockArray()[playerNum][pickedPiece].getOnBoard() == true);

            /* Iterates through the board to find the first legal position */
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    if (myState.getBoard()[i][j] == BlokusGameState.tileState.LEGAL) {
                        selectedRow = i;
                        selectedColumn = j;
                    }
                }
            }

            /* With everything calculated, selects the randomly selected piece */
            game.sendAction(new BlokusSelectAction(this, pickedPiece));

            Logger.log("BlokusSmartAi", "Sending move");
            /* Then, sends an action to place the currently selected piece */
            game.sendAction(new BlokusPlaceAction(this, selectedRow, selectedColumn));
            myState.clearBoard(myState.getBoard());
        } else {
            Logger.log("BlokusSmartAi", "Sending move");
            game.sendAction(new BlokusPassAction(this));
            myState.clearBoard(myState.getBoard());
        }

    } //receiveInfo
}
