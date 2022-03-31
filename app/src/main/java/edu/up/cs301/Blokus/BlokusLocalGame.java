package edu.up.cs301.Blokus;

import android.util.Log;

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

    private int[] color;

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
     * @param players
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
     * @param p
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
     * @return
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
     * Checks if the game is over and returns the winner if it is.
     *
     * @return a string stating who the winner is based on their score
     */
    @Override
    protected String checkIfGameOver() {
        BlokusGameState blokusState = (BlokusGameState) super.state;

        /**
        if (blokusState.getLegalMoves() == false) {
            return "Game is over!"
        }
        else {
            return null;
        }
        if (blokusState.getScore(0) > 100) {
            return "Player 1 has won!";
        }
         */

        return null;
    } //checkIfGameOver

    /**
     * makeMove
     *
     * makes a move for a player
     *
     * @param action
     * 			The move that the player has sent to the game
     * @return
     */
    @Override
    protected boolean makeMove(GameAction action) {

        return false;
    } //makeMove
}
