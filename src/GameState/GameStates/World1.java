package GameState.GameStates;

import Entities.Player;
import GameState.GameState;
import GameState.GameStateManager;
import Main.Game;
import Modules.ButtonModule;
import Modules.ModuleHandler;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class World1 extends GameState {
    public static List<Player> players = new ArrayList<Player>();
    List<ButtonModule> buttons = new ArrayList<ButtonModule>();

    public World1(GameStateManager gsm) {
        this.gsm = gsm;
    }

    @Override
    public void init() {
        players.add(new Player(400, Game.GAME_HEIGHT - 120,50,120, KeyEvent.VK_UP, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT));
        players.add(new Player(100,Game.GAME_HEIGHT - 120,50,120, KeyEvent.VK_W, KeyEvent.VK_A, KeyEvent.VK_D));
        buttons.add(new ButtonModule("punch", "Punch", 10, 160, 100, 40, "/punch", gsm));
        buttons.add(new ButtonModule("kick", "Kick", 10, 220, 100, 40, "/kick", gsm));
        buttons.add(new ButtonModule("swipe", "Swipe", 10, 280, 100, 40, "/swipe", gsm));
        for (ButtonModule b: buttons) {
            ModuleHandler.buttons.add(b);
        }
    }

    @Override
    public void unload() {
        for (ButtonModule b: buttons) {
            ModuleHandler.buttons.remove(b);
        }
    }

    @Override
    public void render(Graphics2D g) {
        for (Player p : players) {
            p.render(g);
        }
        for (ButtonModule button : buttons) {
            button.render(g);
        }
    }

    @Override
    public void tick() {
        for (Player p : players) {
            p.tick();
        }
        for (ButtonModule button : buttons) {
            button.tick();
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
