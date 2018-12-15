package GameState.GameStates;

import Entities.Camera;
import Entities.Player;
import GameState.GameState;
import GameState.GameStateManager;
import Main.Game;
import Modules.BackgoundModule;
import Modules.ButtonModule;
import Modules.ModuleHandler;
import Modules.TerrainModule;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class World1 extends GameState {
    public static List<Player> players = new ArrayList<Player>();
    List<ButtonModule> buttons = new ArrayList<ButtonModule>();
    BackgoundModule bg;

    public World1(GameStateManager gsm, Camera cam) {
        this.gsm = gsm;
        this.cam = cam;
    }

    @Override
    public void init() {
        players.add(new Player(100,Game.GAME_HEIGHT - 120,50,120, KeyEvent.VK_W, KeyEvent.VK_A, KeyEvent.VK_D, cam));
        buttons.add(new ButtonModule("crafting", "Crafting", 10, 160, 80, 24, "/craft", gsm));
        bg = new BackgoundModule(new Color(19, 255, 253));
        for (ButtonModule b: buttons) {
            ModuleHandler.buttons.add(b);
        }
        TerrainModule.generate();
    }

    @Override
    public void unload() {
        for (ButtonModule b: buttons) {
            ModuleHandler.buttons.remove(b);
        }
    }

    @Override
    public void render(Graphics2D g) {
        bg.render(g);
        TerrainModule.render(g);
        for (Player p : players) {
            p.render(g);
        }
        for (ButtonModule button : buttons) {
            button.render(g, cam);
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
