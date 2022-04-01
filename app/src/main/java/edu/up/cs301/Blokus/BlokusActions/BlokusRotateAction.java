package edu.up.cs301.Blokus.BlokusActions;

import edu.up.cs301.Blokus.BlokusInfo.BlokusBlock;
import edu.up.cs301.game.GameFramework.actionMessage.GameAction;
import edu.up.cs301.game.GameFramework.players.GamePlayer;

/**
 * Rotate action for user
 *
 * @author Max Clark, Skyelar Cann, Gavin Raguindin
 * @version March 31st 2022
 */
public class BlokusRotateAction extends GameAction {

    /**
     * constructor for BlokusRotateAction
     *
     * @param player the player who created the action
     */
    public BlokusRotateAction(GamePlayer player) {
        super(player);
    }
}
