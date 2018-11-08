package GameState.GameStates;

import Entities.Player;
import GameState.GameState;
import GameState.GameStateManager;

import java.awt.*;

public class World1 extends GameState {
    Player player;

    public World1(GameStateManager gsm) {
        this.gsm = gsm;
    }

    @Override
    public void init() {
        player = new Player(0,0,25,60);
    }

    @Override
    public void unload() {

    }

    @Override
    public void render(Graphics2D g) {
        player.render(g);
    }

    @Override
    public void tick() {
        player.tick();
    }

    @Override
    public void keyPressed(int k) {

    }

    @Override
    public void keyReleased(int k) {

    }
}
