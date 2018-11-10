package Modules;

import GameState.GameStateManager;
import Main.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListenerModule implements KeyListener {

    private GameStateManager gsm;

    public KeyListenerModule(GameStateManager gsm){
        this.gsm = gsm;
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        gsm.keyPressed(e.getKeyCode());
    }

    public void keyReleased(KeyEvent e) {
        gsm.keyReleased(e.getKeyCode());
    }
}
