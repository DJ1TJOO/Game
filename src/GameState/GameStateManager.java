package GameState;

import GameState.GameStates.MenuState;
import GameState.GameStates.Urlgithub;
import GameState.GameStates.World1;
import Main.Game;

import javax.print.DocFlavor;
import java.awt.*;
import java.util.HashMap;

public class GameStateManager {
    private static GameState[] gameState;
    private static int currentState;
    private static HashMap<String, Integer> gameStates = new HashMap<String, Integer>();
    public static final int GAMESTATES = 3;
    private static final GameStateManager GameStateManager = new GameStateManager();

    public GameStateManager() {
        gameState = new GameState[GAMESTATES];
        gameStates.put("MENUSTATE", 0);
        gameStates.put("URLGITHUB", 1);
        gameStates.put("WORLD", 2);
        currentState = gameStates.get("MENUSTATE");

        loadState(currentState);

    }

    public static int toInt(String action) {
        Game.sys(action);
        return gameStates.get(action);
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

    public void loadState(int state) {
        unload(currentState);
        if (state == gameStates.get("MENUSTATE")) {
            gameState[state] = new MenuState(GameStateManager);
        } else if (state == gameStates.get("URLGITHUB")) {
            gameState[state] = new Urlgithub(GameStateManager);
        } else if (state == gameStates.get("WORLD")) {
            gameState[state] = new World1(GameStateManager);
        }
        currentState = state;
        gameState[state].init();

    }

    private void unload(int state){
        gameState[state] = null;
    }
}
