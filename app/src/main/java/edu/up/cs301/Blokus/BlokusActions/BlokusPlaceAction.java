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
    /**
     * constructor for BlokusPlaceAction
     *
     * @param player the player who created the action
     */
    public BlokusPlaceAction(GamePlayer player) {
        super(player);
    }
}
