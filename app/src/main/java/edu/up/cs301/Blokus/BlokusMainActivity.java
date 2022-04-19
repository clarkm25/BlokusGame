package edu.up.cs301.Blokus;

import edu.up.cs301.Blokus.BlokusInfo.BlokusGameState;
import edu.up.cs301.Blokus.BlokusPlayer.BlokusDumbAi;
import edu.up.cs301.Blokus.BlokusPlayer.BlokusHumanPlayer;
import edu.up.cs301.Blokus.BlokusPlayer.BlokusSmartAi;
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
 * PROJECT #I INFO:
 * Game crashes due to an array out of bounds error from the Computer Player class. Our thoughts are
 * that the game is crashing due to recursive placePiece method failing to account for this error
 * which is causing it to crash when iterating through the AI turns. The method to check for legal
 * moves is also having problems finding legal moves once a piece has already been placed. However,
 * network play is available and multiple users are able to place at least one piece on the board.
 * The action for selecting a piece is also working well for both local players and WiFi players.
 * Finally, all of the buttons are working correctly and performing their required actions. The
 * "Help" button is opening a help menu (no matter who's turn it is) that describes the game and
 * point system as well as provides explanation for the buttons. The "Rotate" button properly
 * rotates a selected piece for the given user as long as it is the given user's turn. The "Pass"
 * button properly skips the user's turn given that it is the user's turn. Finally, the "Quit"
 * button properly closes the game (using System.exit()) no matter who's turn it is.
 *
 * ADDED: The main thing that was added was the pass method/button. This is both for the AI (in
 * order to make the AI have a chance of passing if they don't have any legal moves) and for the
 * user.
 *
 * REMOVED: BlokusHelpMenuAction class was removed as there was a problem with TextView having to
 * be sent across for the Help Menu and TextView is not serializable.
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


        //Dumb Computer Player #2
        playerTypes.add(new GamePlayerType("Smart Computer Player") {
            public GamePlayer createPlayer(String name) {
                return new BlokusSmartAi(name);
            }
        });

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
