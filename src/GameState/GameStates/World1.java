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
import java.awt.event.MouseEvent;
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
        buttons.add(new ButtonModule("crafting", "Crafting", 10, 160, 80, 24, "/craft", gsm));
        bg = new BackgoundModule(new Color(19, 255, 253));
        for (ButtonModule b: buttons) {
            ModuleHandler.buttons.add(b);
        }
        TerrainModule.generate();
        int xPlayer = 0;
        int yPlayer = 0;
       /* for (int i = xPlayer - 32; i < (xPlayer + 32); i++) {
            if(TerrainModule.top.get(i) != null){
                yPlayer = TerrainModule.top.get(i);
                xPlayer = i;
            }
        }*/
        yPlayer = TerrainModule.getTop(xPlayer);
        Game.sys(yPlayer + " y generated");
        players.add(new Player(xPlayer,yPlayer - 120,50,120, KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D, cam));
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
        TerrainModule.render(g, cam);
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

    @Override
    public void mouseClicked(MouseEvent e) {
        for (Player p: players) {
            p.mouseClicked(e);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }
}
