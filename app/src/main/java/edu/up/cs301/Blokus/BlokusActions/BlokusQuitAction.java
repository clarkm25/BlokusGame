package edu.up.cs301.Blokus.BlokusActions;

import edu.up.cs301.game.GameFramework.actionMessage.GameAction;
import edu.up.cs301.game.GameFramework.players.GamePlayer;

/**
 * Quit action for user
 *
 * @author Max Clark, Skyelar Cann, Gavin Raguindin
 * @version March 31st 2022
 */
public class BlokusQuitAction extends GameAction {
    /**
     * constructor for BlokusQuitAction
     *
     * @param player the player who created the action
     */
    public BlokusQuitAction(GamePlayer player) {
        super(player);
    }
}
