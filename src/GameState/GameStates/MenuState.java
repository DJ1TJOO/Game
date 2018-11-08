package GameState.GameStates;

import GameState.GameState;
import GameState.GameStateManager;
import modules.Button;

import java.awt.*;

public class MenuState extends GameState {
    private Button button1 = null;

    public MenuState(GameStateManager gsm) {
        this.gsm = gsm;
    }

    @Override
    public void init() {
        button1 = new Button("start", "Start", 0, 0, 100, 20, "WORLD1");
    }

    @Override
    public void render(Graphics2D g) {
        button1.render(g);
    }

    @Override
    public void tick() {
        button1.tick();
        if(button1.getOver()){
            System.err.println("over");
        }
    }

    @Override
    public void keyPressed(int k) {

    }

    @Override
    public void keyReleased(int k) {

    }
}
