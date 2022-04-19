package edu.up.cs301.Blokus.BlokusPlayer;

import edu.up.cs301.Blokus.BlokusActions.BlokusPassAction;
import edu.up.cs301.Blokus.BlokusActions.BlokusPlaceAction;
import edu.up.cs301.Blokus.BlokusActions.BlokusSelectAction;
import edu.up.cs301.Blokus.BlokusInfo.BlokusBlock;
import edu.up.cs301.Blokus.BlokusInfo.BlokusGameState;
import edu.up.cs301.Blokus.BlokusViews.DrawBoard;
import edu.up.cs301.game.GameFramework.infoMessage.GameInfo;
import edu.up.cs301.game.GameFramework.infoMessage.NotYourTurnInfo;
import edu.up.cs301.game.GameFramework.players.GameComputerPlayer;
import edu.up.cs301.game.GameFramework.utilities.Logger;

import java.util.ArrayList;
import java.util.Random;

/**
 * Dumb computer player for Blokus that places first piece in first legal spot.
 *
 * @author Max Clark, Skyelar Cann, Gavin Raguindin
 * @version March 31st 2022
 */
public class BlokusDumbAi extends GameComputerPlayer {

    //21 pieces
    BlokusGameState myState;

    /**
     * BlokusDumbAi
     *
     * Default ctor for the dumb computer player
     *
     * @param name
     */
    public BlokusDumbAi(String name) {
        super(name);
    }

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

        Logger.log("BlokusDumbAi", "My turn!");

        myState = (BlokusGameState)info;

        //Allow for AI to take time between plays
        sleep(1);

        Logger.log("BlokusDumbAi", "Sending move");
        game.sendAction(new BlokusPassAction(this)); //Passes its turn
    } //receiveInfo
}
