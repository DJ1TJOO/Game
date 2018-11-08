package GameState.GameStates;

import GameState.GameState;
import GameState.GameStateManager;
import main.Game;
import modules.Button;
import modules.ModuleHandler;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

public class MenuState extends GameState {
    List<Button> buttons = new ArrayList<Button>();

    public MenuState(GameStateManager gsm) {
        this.gsm = gsm;
    }

    @Override
    public void init() {
        int Width = 200;
        buttons.add(new Button("start", "Start", Game.WIDTH / 2 - Width / 2, 40, Width, 40, "WORLD1"));
        buttons.add(new Button("compain", "Compain", Game.WIDTH / 2 - Width / 2, 100, Width, 40, "WORLD1"));
        buttons.add(new Button("options", "Options", Game.WIDTH / 2 - Width / 2, 160, Width, 40, "OPTIONS"));
        buttons.add(new Button("credits", "Credits", Game.WIDTH / 2 - Width / 2, 220, Width, 40, "CREDITS"));
        buttons.add(new Button("logs", "Logs", Game.WIDTH / 2 - Width / 2, 280, Width, 40, "URLGITHUB"));
        for (Button b: buttons) {
            ModuleHandler.buttons.add(b);
        }
    }

    @Override
    public void render(Graphics2D g) {
        for (Button button : buttons) {
            button.render(g);
        }
    }

    @Override
    public void tick() {
        for (Button button : buttons) {
            if (button.isPressed()) {
                gsm.loadState(GameStateManager.toInt(button.getAction()));
            }
            button.setX(Game.WIDTH / 2 - 200 / 2);
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
