package GameState;

import Entities.Camera;
import GameState.GameStates.MenuState;
import GameState.GameStates.Urlgithub;
import GameState.GameStates.World1;
import Main.Game;
import Modules.ButtonModule;

import javax.print.DocFlavor;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.HashMap;

public class GameStateManager {
    private static GameState[] gameState;
    private static int currentState;
    private static HashMap<String, Integer> gameStates = new HashMap<String, Integer>();
    public static final int GAMESTATES = 3;
    Camera cam;

    public GameStateManager(Camera cam) {
        gameState = new GameState[GAMESTATES];
        gameStates.put("MENUSTATE", 0);
        gameStates.put("URLGITHUB", 1);
        gameStates.put("WORLD", 2);
        currentState = gameStates.get("MENUSTATE");
        this.cam = cam;
        loadState(currentState);

    }

    public static String getCurrentGameStateString(){
        return toString(currentState);
    }

    public static int toInt(String action) {
        return gameStates.get(action);
    }

    public static String toString(int gameState) {
        for (String key : gameStates.keySet()) {
            if(gameStates.get(key) == gameState){
                return key;
            }
        }
        return null;
    }

    public void tick(){
        if (!(gameState[currentState] == null))
            gameState[currentState].tick();
    }
    public void renderHud(Graphics2D g){
        if (!(gameState[currentState] == null))
            gameState[currentState].renderHud(g);
    }
    public void render(Graphics2D g){
        if (!(gameState[currentState] == null))
            gameState[currentState].render(g);
    }
    public void mouseClicked(MouseEvent e) {
        if (!(gameState[currentState] == null))
            gameState[currentState].mouseClicked(e);
    }

    public void mouseEntered(MouseEvent e) {
        if (!(gameState[currentState] == null))
            gameState[currentState].mouseEntered(e);
    }

    public void mouseExited(MouseEvent e) {
        if (!(gameState[currentState] == null))
            gameState[currentState].mouseExited(e);
    }

    public void mousePressed(MouseEvent e) {
        if (!(gameState[currentState] == null))
            gameState[currentState].mousePressed(e);
    }

    public void mouseReleased(MouseEvent e) {
        if (!(gameState[currentState] == null))
            gameState[currentState].mouseReleased(e);
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
            gameState[state] = new MenuState(this, cam);
        } else if (state == gameStates.get("URLGITHUB")) {
            gameState[state] = new Urlgithub(this);
        } else if (state == gameStates.get("WORLD")) {
            gameState[state] = new World1(this, cam);
        }
        currentState = state;
        gameState[state].init();

    }

    private void unload(int state){
        gameState[state] = null;
    }
}
