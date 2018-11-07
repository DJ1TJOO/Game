package GameState;

import GameState.GameStates.MenuState;

import java.awt.*;

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

    public void tick(){
        if (!(gameState[currentState] == null))
            gameState[currentState].tick();
    }

    public void render(Graphics2D g){
        if (!(gameState[currentState] == null))
            gameState[currentState].render(g);
    }

    public void keyPressed(int k) {
        if (!(gameState[currentState] == null))
            gameState[currentState].keyPressed(k);
    }

    public void keyReleased(int k) {
        if (!(gameState[currentState] == null))
            gameState[currentState].keyReleased(k);
    }

    private static void loadState(int state) {
        if (state == MENUSTATE) {
            gameState[state] = new MenuState(GameStateManager);
        }
    }
}
