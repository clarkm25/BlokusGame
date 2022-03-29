package edu.up.cs301.Blokus.BlokusPlayer;

import edu.up.cs301.game.GameFramework.infoMessage.GameInfo;
import edu.up.cs301.game.GameFramework.players.GameComputerPlayer;

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
     *
     *
     * @param info
     */
    @Override
    protected void receiveInfo(GameInfo info) {

    } //recieveInfo
}
