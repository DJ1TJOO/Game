package GameState.GameStates;

import Entities.Player;
import GameState.GameState;
import GameState.GameStateManager;
import Main.Game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class World1 extends GameState {
    public static List<Player> players = new ArrayList<Player>();

    public World1(GameStateManager gsm) {
        this.gsm = gsm;
    }

    @Override
    public void init() {
        players.add(new Player(400, Game.GAME_HEIGHT - 120,50,120, KeyEvent.VK_UP, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT));
        players.add(new Player(100,Game.GAME_HEIGHT - 120,50,120, KeyEvent.VK_W, KeyEvent.VK_A, KeyEvent.VK_D));
    }

    @Override
    public void unload() {

    }

    @Override
    public void render(Graphics2D g) {
        for (Player p : players) {
            p.render(g);
        }
    }

    @Override
    public void tick() {
        for (Player p : players) {
            p.tick();
        }
    }

    @Override
    public void keyPressed(int k) {
        for (Player p : players) {
            p.keyPressed(k);
        }
    }

    @Override
    public void keyReleased(int k) {
        for (Player p : players) {
            p.keyReleased(k);
        }
    }
}
