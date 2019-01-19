package Modules;

import GameState.GameStateManager;
import Main.Game;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class ModuleHandler {
    public static List<ButtonModule> buttons = new ArrayList<ButtonModule>();
    private MouseListenerModule mouseListener;
    private GameStateManager gsm;

    public ModuleHandler(GameStateManager gsm, Game game){
        this.gsm = gsm;
        game.addMouseListener(mouseListener = new MouseListenerModule(this));
        game.addKeyListener(new KeyListenerModule(gsm));
    }

    public void tick(){
        mouseListener.tick();
    }

    public void mouseClicked(MouseEvent e) {
        gsm.mouseClicked(e);
        for (ButtonModule b : buttons) {
            b.mouseClicked();
        }
    }

    public void mouseEntered(MouseEvent e) {
        gsm.mouseEntered(e);
    }

    public void mouseExited(MouseEvent e) {
        gsm.mouseExited(e);
    }

    public void mousePressed(MouseEvent e) {
        gsm.mousePressed(e);
    }

    public void mouseReleased(MouseEvent e) {
        gsm.mouseReleased(e);
    }
}
