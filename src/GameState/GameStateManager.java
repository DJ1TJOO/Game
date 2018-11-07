package GameState;

import GameState.GameStates.MenuState;

public class GameStateManager {
    private static GameState[] gameState;
    private static int currentState;
    public static final int GAMESTATES = 14;
    public static final int MENUSTATE = 0;
    private static final GameStateManager GameStateManager = new GameStateManager();

    public GameStateManager() {
        gameState = new GameState[GAMESTATES];

        currentState = MENUSTATE;

        loadState(currentState);

    }

    private static void loadState(int state) {
        if (state == MENUSTATE) {
            gameState[state] = new MenuState(GameStateManager);
        }
    }
}
