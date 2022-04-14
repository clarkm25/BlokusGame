package edu.up.cs301.Blokus.BlokusActions;

import edu.up.cs301.game.GameFramework.actionMessage.GameAction;
import edu.up.cs301.game.GameFramework.players.GamePlayer;

/**
 * Place action for user.
 *
 * @author Max Clark, Skyelar Cann, Gavin Raguindin
 * @version March 31st 2022
 */
public class BlokusPlaceAction extends GameAction {

    /* Instance variables */
    private int row;
    private int col;

    /**
     * constructor for BlokusPlaceAction
     *
     * @param player the player who created the action
     * @param row the given row
     * @param col the given column
     */
    public BlokusPlaceAction(GamePlayer player, int selectedPiece, int row, int col)
    {
        super(player);

        /* Sets the row and col to the ones passed in above */
        this.row = Math.max(0, Math.min(19,row));
        this.col = Math.max(0, Math.min(19,col));
    }

    /**
     * Getter method for the current row
     *
     * @return the current row
     */
    public int getRow(){ return this.row; }

    /**
     * Getter method for the current column
     *
     * @return the current column
     */
    public int getCol(){ return this.col; }
}
