package edu.up.cs301.Blokus.BlokusPlayer;

import edu.up.cs301.Blokus.BlokusActions.BlokusPassAction;
import edu.up.cs301.game.GameFramework.infoMessage.GameInfo;
import edu.up.cs301.game.GameFramework.infoMessage.NotYourTurnInfo;
import edu.up.cs301.game.GameFramework.players.GameComputerPlayer;
import edu.up.cs301.game.GameFramework.utilities.Logger;

/**
 * Smart computer player for Blokus Game. Computer Player rotates pieces if there is no legal moves
 * without rotation.
 *
 * @author Max Clark, Skyelar Cann, Gavin Raguindin
 * @version March 31st 2022
 */
public class BlokusSmartAi extends GameComputerPlayer {

    /**
     * BlokusSmartAi
     *
     * default ctor for smart computer player
     *
     * @param name
     */
    public BlokusSmartAi(String name) {
        super(name);
    } //BlokusSmartAi

    /**
     * recieveInfo
     *
     * Method that makes action for the dumb computer player.
     *
     * @param info
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        if (info instanceof NotYourTurnInfo) return; //nothing happens if it isn't players turn

        Logger.log("BlokusSmartAi", "My turn!");

        //Allow for AI to take time between plays
        sleep(1);

        Logger.log("BlokusSmartAi", "Sending move");
        game.sendAction(new BlokusPassAction(this));
    } //receiveInfo
}
