package modules;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseListenerModule implements MouseListener {

    public void mouseClicked(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX() / 2;
        int my = e.getY() / 2;

    }

    public void mouseReleased(MouseEvent e) {

    }

    @SuppressWarnings("unused")
    private boolean mouseOver(int mx, int my, int x, int y, int width, int height, int state) {
        //if (state == GameStateManager.getStateI()) {
        if (mx > x && mx < x + width) {
            if (my > y && my < y + height) {
                return true;
            } else
                return false;
        } else
            return false;
        // } else {
        //     return false;
        // }
    }

}

