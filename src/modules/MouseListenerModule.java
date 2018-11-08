package modules;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseListenerModule implements MouseListener {

    private static int mx,my;

    public void mouseClicked(MouseEvent e) {
        mx = e.getX();
        my = e.getY();
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public static boolean mouseOverClicked(int x, int y, int width, int height) {
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

