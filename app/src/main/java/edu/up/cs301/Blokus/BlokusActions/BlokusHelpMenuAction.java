package edu.up.cs301.Blokus.BlokusActions;

import android.widget.TextView;

import edu.up.cs301.game.GameFramework.actionMessage.GameAction;
import edu.up.cs301.game.GameFramework.players.GamePlayer;

/**
 * Help menu action for user who clicks Help Menu button
 *
 * @author Max Clark, Skyelar Cann, Gavin Raguindin
 * @version March 31st 2022
 *
 */
public class BlokusHelpMenuAction extends GameAction {

    //For Serializable interface
    public static final long serialVersionUID = 92894327819L;

    TextView helpMenu;

    /**
     * constructor for BlokusHelpMenuAction
     *
     * @param player the player who created the action
     */
    public BlokusHelpMenuAction(GamePlayer player, TextView initHelpMenu) {
        super(player);

        this.helpMenu = initHelpMenu;
    }

    public TextView getHelpMenu() {
        return helpMenu;
    }
}
