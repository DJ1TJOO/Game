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
        for (ButtonModule b : buttons) {
            b.mouseClicked();
        }
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }
}
