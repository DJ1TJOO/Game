package GameState.GameStates;

import Entities.Camera;
import GameState.GameState;
import GameState.GameStateManager;
import Main.Game;
import Modules.ButtonModule;
import Modules.ModuleHandler;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MenuState extends GameState {
    List<ButtonModule> buttons = new ArrayList<ButtonModule>();

    public MenuState (GameStateManager gsm, Camera cam) {
        this.gsm = gsm;
        this.cam = cam;
    }

    @Override
    public void init() {
        int Width = 200;
        buttons.add(new ButtonModule("start", "Start", Game.WIDTH / 2 - Width / 2, 40, Width, 40, "/gamestate set WORLD", gsm));
        buttons.add(new ButtonModule("options", "Options", Game.WIDTH / 2 - Width / 2, 100, Width, 40, "/gamestate set OPTIONS", gsm));
        buttons.add(new ButtonModule("credits", "Credits", Game.WIDTH / 2 - Width / 2, 160, Width, 40, "/gamestate set CREDITS", gsm));
        buttons.add(new ButtonModule("logs", "Logs", Game.WIDTH / 2 - Width / 2, 220, Width, 40, "URLGITHUB", gsm));
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
        for (ButtonModule button : buttons) {
            button.render(g, cam);
        }
    }

    @Override
    public void tick() {
            for (ButtonModule button : buttons) {
                button.setX(Game.PIX_WIDTH / 2 - 200 / 2);
            }
        for (ButtonModule button : buttons) {
            button.tick();
        }
    }

    @Override
    public void keyPressed(int k) {

    }

    @Override
    public void keyReleased(int k) {

    }
}
