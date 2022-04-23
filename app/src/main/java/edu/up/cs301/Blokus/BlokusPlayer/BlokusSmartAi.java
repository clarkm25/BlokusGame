package edu.up.cs301.Blokus.BlokusPlayer;

import java.util.Random;

import edu.up.cs301.Blokus.BlokusActions.BlokusPassAction;
import edu.up.cs301.Blokus.BlokusActions.BlokusPlaceAction;
import edu.up.cs301.Blokus.BlokusActions.BlokusSelectAction;
import edu.up.cs301.Blokus.BlokusInfo.BlokusGameState;
import edu.up.cs301.game.GameFramework.infoMessage.GameInfo;
import edu.up.cs301.game.GameFramework.infoMessage.IllegalMoveInfo;
import edu.up.cs301.game.GameFramework.infoMessage.NotYourTurnInfo;
import edu.up.cs301.game.GameFramework.players.GameComputerPlayer;
import edu.up.cs301.game.GameFramework.utilities.Logger;

/**
 * Smart computer player for Blokus Game. Computer player places a piece at random in the first legal place it finds.
 *
 * @author Max Clark, Skyelar Cann, Gavin Raguindin
 * @version April 22nd 2022
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
        if (info instanceof IllegalMoveInfo) return; //nothing happens if the info is an illegal

        myState = (BlokusGameState) info;
        if(myState.getPlayerTurn() != playerNum) return;
        Logger.log("BlokusSmartAi", "My turn!");
        //Allow for AI to take time between plays
        sleep(.25);

        /* Picks a random piece number and sets both selected row and columns to zero */
        Random r = new Random();

        int pickedPiece = 0;
        int selectedRow = 0;
        int selectedColumn = 0;
        int piecesLeft = 0;
        int rotateInt = 0;

        //Checks whether or not all the pieces are in player boxes or on the board
        for (int i = 0; i < 21; i++) {
            if (!myState.getBlockArray()[playerNum][i].getOnBoard()) {
                piecesLeft++;
            }
        }


        //As long as there are pieces left in the AI's box, will continue getting random pieces
        //until it finds one not on the board
        if (piecesLeft != 0) {
            do {
                pickedPiece = r.nextInt(21);
            } while (myState.getBlockArray()[playerNum][pickedPiece].getOnBoard());
            game.sendAction(new BlokusSelectAction(this, pickedPiece));

            //TODO: Get rid of these lines once we are 100% sure they are not required.
            //myState.calcLegalMoves(myState.getBoard(), playerNum);
            //myState.checkLegals(myState.getBoard(), playerNum, myState.getBlockArray()[playerNum][pickedPiece]);

            /* Iterates through the board to find the first legal position */
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    if (myState.getBoard()[i][j] == BlokusGameState.tileState.LEGAL) {
                        selectedRow = i;
                        selectedColumn = j;
                        break;
                    }
                }
            }

            //TODO: Get rid of these lines as well, same reason as top ones.
            //myState.rotatePiece(myState.getBlockArray()[playerNum][pickedPiece]);
            //game.sendAction(new BlokusRotateAction(this));

            /* Then, sends an action to place the currently selected piece */
            game.sendAction(new BlokusPlaceAction(this, selectedRow, selectedColumn));
            myState.clearBoard(myState.getBoard());
        }
        else {
            Logger.log("BlokusSmartAi", "Sending move");
            game.sendAction(new BlokusPassAction(this));
        }

    } //receiveInfo
}
