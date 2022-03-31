package edu.up.cs301.Blokus.BlokusActions;

import edu.up.cs301.game.GameFramework.actionMessage.GameAction;
import edu.up.cs301.game.GameFramework.players.GamePlayer;

public class BlokusSelectAction extends GameAction {

    int selectedPiece;

    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public BlokusSelectAction(GamePlayer player, int piece) {
        super(player);

        selectedPiece = piece;
    }

    public int getSelectedPiece() {
        return selectedPiece;
    }
}
