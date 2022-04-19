package edu.up.cs301.Blokus;

import android.util.Log;

import edu.up.cs301.Blokus.BlokusActions.BlokusPassAction;
import edu.up.cs301.Blokus.BlokusActions.BlokusPlaceAction;
import edu.up.cs301.Blokus.BlokusActions.BlokusQuitAction;
import edu.up.cs301.Blokus.BlokusActions.BlokusRotateAction;
import edu.up.cs301.Blokus.BlokusActions.BlokusSelectAction;
import edu.up.cs301.Blokus.BlokusInfo.BlokusGameState;
import edu.up.cs301.game.GameFramework.LocalGame;
import edu.up.cs301.game.GameFramework.actionMessage.GameAction;
import edu.up.cs301.game.GameFramework.players.GamePlayer;

/**
 * LocalGame for Blokus which handles interactions between players.
 *
 * @author Max Clark, Skyelar Cann, Gavin Raguindin
 * @version March 31st 2022
 */
public class BlokusLocalGame extends LocalGame {


    /**
     * BlokusLocalGame
     *
     * default ctor for the Blokus local game.
     */
    public BlokusLocalGame() {
        super();
        Log.i("BlokusLocalGame", "create game");
        super.state = new BlokusGameState();
    } //BlokusLocalGame

    /**
     * BlokusLocalGame
     *
     * ctor that uses a BlokusGameState instead of making a new one.
     *
     * @param initState
     */
    public BlokusLocalGame(BlokusGameState initState) {
        super();
        super.state = new BlokusGameState(initState);
    } //BlokusLocalGame

    /**
     * start
     *
     * Uses super method given the array of players.
     *
     * @param players all players in the game that are not null
     */
    @Override
    public void start(GamePlayer[] players) {
        super.start(players);
    } //start

    /**
     * sendUpdatedStateTo
     *
     * sends updated Blokus game state to a given player.
     *
     * @param p current player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        p.sendInfo(new BlokusGameState((BlokusGameState) state));
    } //sendUpdatedStateTo

    /**
     * canMove
     *
     * Checks if given player can make a move
     *
     * @param playerIdx
     * 		the player's player-number (ID)
     * @return boolean
     */
    @Override
    protected boolean canMove(int playerIdx) {
        if (playerIdx == ((BlokusGameState)state).getPlayerTurn()) {
            return true;
        }
        else {
            return false;
        }
    } //canMove

    /**
     * checkIfGameOver
     *
     * Checks if the game is over and returns the winner if it is
     *
     * @return a string stating who the winner is based on their score
     */
    @Override
    protected String checkIfGameOver() {
        BlokusGameState blokusState = (BlokusGameState) super.state;
        int outOfMoves = 0;
        if (blokusState.getPlayerScore(blokusState.getPlayerTurn()) > 50) {
            return "Player " + blokusState.getPlayerTurn() + " has won!";
        }
        else {
            return null;
        }
    } //checkIfGameOver

    /**
     * makeMove
     *
     * makes a move for a player
     *
     * @param action
     * 			The move that the player has sent to the game
     * @return boolean
     */
    @Override
    protected boolean makeMove(GameAction action) {
        BlokusGameState state = (BlokusGameState) super.state; //Retrieves the game state for use below
        int playerId; //Current player's ID

        /* Checks to see what the action was and takes the appropriate actions */
        if(action instanceof BlokusSelectAction) {
           BlokusSelectAction bs = (BlokusSelectAction) action;
           playerId = getPlayerIdx(bs.getPlayer()); //Sets player ID as seen here and below
           state.setSelectedType(bs.getBlockType()); //Sets the selected type after the selection action happens
           if(!state.calcLegalMoves(state.getBoard(), playerId))//Calculate legal moves after selecting the piece
           {

           }
           return true;
        }
        else if(action instanceof BlokusRotateAction) {
          BlokusRotateAction br = (BlokusRotateAction) action;
          playerId = getPlayerIdx(br.getPlayer());
          state.rotatePiece(state.getBlockArray()[playerId][state.getSelectedType()]);//Gets the appropriate piece based off the selected type and ID
          return true;
        }
        else if(action instanceof BlokusPlaceAction) {
            BlokusPlaceAction bp = (BlokusPlaceAction) action;
            playerId = getPlayerIdx(bp.getPlayer());
            state.placePiece(playerId, bp.getCol(), bp.getRow(), state.getBlockArray()[playerId][state.getSelectedType()],0);
            /* Sets the appropriate player's turn based on whose turn it currently is */
            switch (playerId)
            {
                case 0:
                    state.setPlayerTurn(1);
                    break;

                case 1:
                    state.setPlayerTurn(2);
                    break;

                case 2:
                    state.setPlayerTurn(3);
                    break;

                case 3:
                    state.setPlayerTurn(0);
                    break;
            }
            //Clears legal spots from board as it is no longer given player's turn
            state.clearBoard(state.getBoard());
            return true;
        }
        else if(action instanceof BlokusQuitAction) {
            System.exit(1); //Sends a non-zero value to system which is what triggers exit.
            return true;
        }
        else if (action instanceof BlokusPassAction) {
            BlokusPassAction bpa = (BlokusPassAction) action;
            playerId = getPlayerIdx(bpa.getPlayer());

            switch(playerId) {
                case 0:
                    state.setPlayerTurn(1);
                    break;

                case 1:
                    state.setPlayerTurn(2);
                    break;

                case 2:
                    state.setPlayerTurn(3);
                    break;

                case 3:
                    state.setPlayerTurn(0);
                    break;
            }
            return true;
        }

        //Other action, return false
        return false;
    } //makeMove
}
