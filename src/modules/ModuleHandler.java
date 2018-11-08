package modules;

import GameState.GameStateManager;
import main.Game;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class ModuleHandler {
    public static List<Button> buttons = new ArrayList<Button>();

    public ModuleHandler(GameStateManager gsm, Game game){
        game.addMouseListener(new MouseListenerModule(this));
        new KeyListenerModule(gsm);
    }

    public void mouseClicked(MouseEvent e) {
        for (Button b : buttons) {
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
