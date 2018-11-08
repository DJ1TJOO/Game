package modules;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseListenerModule implements MouseListener {

    private static int mx,my;
    private static ModuleHandler handler;

    public MouseListenerModule(ModuleHandler handler){
        this.handler = handler;
    }

    public void mouseClicked(MouseEvent e) {
        mx = e.getX();
        my = e.getY();
        handler.mouseClicked(e);
    }

    public void mouseEntered(MouseEvent e) {
        mx = e.getX();
        my = e.getY();
        handler.mouseEntered(e);
    }

    public void mouseExited(MouseEvent e) {
        mx = e.getX();
        my = e.getY();
        handler.mouseExited(e);
    }

    public void mousePressed(MouseEvent e) {
        mx = e.getX();
        my = e.getY();
        handler.mousePressed(e);
    }

    public void mouseReleased(MouseEvent e) {
        mx = e.getX();
        my = e.getY();
        handler.mouseReleased(e);
    }

    public static boolean mouseHover(int x, int y, int width, int height) {
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

