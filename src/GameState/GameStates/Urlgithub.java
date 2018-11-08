package GameState.GameStates;

import GameState.GameStateManager;
import GameState.GameState;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Urlgithub extends GameState {

    public Urlgithub(GameStateManager gsm) {
        this.gsm = gsm;
    }

    public void init() {
        gsm.loadState(GameStateManager.toInt("MENUSTATE"));
        try {
            Desktop.getDesktop().browse(new URI("https://github.com/DJ1TJOO/Game/commits/master"));
            System.out.println("t");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void unload() {

    }

    public void render(Graphics2D g) {

    }

    public void tick() {

    }

    public void keyPressed(int k) {

    }

    public void keyReleased(int k) {

    }
}
