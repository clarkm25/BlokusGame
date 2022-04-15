package edu.up.cs301.Blokus.BlokusActions;

import edu.up.cs301.game.GameFramework.actionMessage.GameAction;
import edu.up.cs301.game.GameFramework.players.GamePlayer;

/**
 * Passes a user's turn (given it is their turn)
 *
 * @author Max Clark, Skyelar Cann, Gavin Raguindin
 * @version April 14 2022
 */
public class BlokusPassAction extends GameAction {
    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public BlokusPassAction(GamePlayer player) {
        super(player);
    }
}
