package edu.up.cs301.Blokus.BlokusActions;

import edu.up.cs301.Blokus.BlokusInfo.BlokusBlock;
import edu.up.cs301.game.GameFramework.actionMessage.GameAction;
import edu.up.cs301.game.GameFramework.players.GamePlayer;

/**
 * Help menu action for user who clicks Help Menu button
 *
 * @author Max Clark, Skyelar Cann, Gavin Raguindin
 * @version March 31st 2022
 *
 */
public class BlokusMoveAction extends GameAction {
    private BlokusBlock piece;
    private int row;
    private int col;

    /**
     * constructor for BlokusMoveAction
     *
     * @param player the player who created the action
     */
    public BlokusMoveAction(GamePlayer player) {
        super(player);
    }
}
