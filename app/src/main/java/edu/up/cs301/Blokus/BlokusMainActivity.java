package edu.up.cs301.Blokus;

import edu.up.cs301.Blokus.BlokusInfo.BlokusGameState;
import edu.up.cs301.Blokus.BlokusPlayer.BlokusDumbAi;
import edu.up.cs301.Blokus.BlokusPlayer.BlokusHumanPlayer;
import edu.up.cs301.game.GameFramework.GameMainActivity;
import edu.up.cs301.game.GameFramework.LocalGame;
import edu.up.cs301.game.GameFramework.gameConfiguration.GameConfig;
import edu.up.cs301.game.GameFramework.gameConfiguration.GamePlayerType;
import edu.up.cs301.game.GameFramework.infoMessage.GameState;
import edu.up.cs301.game.GameFramework.players.GamePlayer;
import edu.up.cs301.game.R;
import java.util.ArrayList;

/**
 * Primary Activity for Blokus
 *
 * @author Max Clark, Skyelar Cann, Gavin Raguindin
 * @version March 31st, 2022
 */
public class BlokusMainActivity extends GameMainActivity {

    private static final String TAG = "BlokusMainActivity";
    public static final int PORT_NUMBER = 56437;

    /**
     * Blokus game for 4 players. Default to 1 Human Player and 3 Computer Players.
     *
     * @return defaultConfig
     */
    @Override
    public GameConfig createDefaultConfig() {

        // Define the allowed player types
        ArrayList<GamePlayerType> playerTypes = new ArrayList<GamePlayerType>();

        //Blokus GUI
        playerTypes.add(new GamePlayerType("Local Blokus Human Player") {
            public GamePlayer createPlayer(String name) {
                return new BlokusHumanPlayer(name, R.layout.activity_main);
            }
        });

        //Dumb Computer Player
        playerTypes.add(new GamePlayerType("Dumb Computer Player") {
            public GamePlayer createPlayer(String name) {
                return new BlokusDumbAi(name);
            }
        });

        /**
        //Dumb Computer Player #2 (Will be changed to Smart Computer Player later)
        playerTypes.add(new GamePlayerType("Smart Computer Player") {
            public GamePlayer createPlayer(String name) {
                return new BlokusDumbAi(name);
            }
        });
         */

        // Create a game configuration class for Blokus
        GameConfig defaultConfig = new GameConfig(playerTypes, 4,4, "Blokus", PORT_NUMBER);

        // Add the default players
        defaultConfig.addPlayer("Human", 0); //GUI
        defaultConfig.addPlayer("Computer Player #1", 1); //Default is Dumb AI
        defaultConfig.addPlayer("Computer Player #2", 1); //Default is Dumb AI
        defaultConfig.addPlayer("Computer Player #3", 1); //Default is Dumb AI

        // Set the initial information for the remote player
        defaultConfig.setRemoteData("Remote Player", "", 1);

        return defaultConfig;
    } //createDefaultConfig

    /**
     * Creates a new game to run on tablet given the GameState is null
     *
     * @param gameState - Game State for this game.
     *
     * @return gameState typeCasted to BlokusGameState for LocalGame
     */
    @Override
    public LocalGame createLocalGame(GameState gameState) {
        if(gameState == null) {
            gameState = new BlokusGameState();
        }

        return new BlokusLocalGame((BlokusGameState) gameState);
    } //createLocalGame
}
