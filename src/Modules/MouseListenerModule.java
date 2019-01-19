package Modules;

import Main.Game;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseListenerModule implements MouseListener {

    private static int mx,my;
    private static ModuleHandler handler;

    public MouseListenerModule(ModuleHandler handler){
        this.handler = handler;
    }

    public void tick(){
        mx = (int)((MouseInfo.getPointerInfo().getLocation().getX() - Game.frame.getLocationOnScreen().getX()) / Game.sx);
        my = (int)((MouseInfo.getPointerInfo().getLocation().getY() - Game.frame.getLocationOnScreen().getY() - 30) / Game.sy);
       // Game.sys(mx + " | " + my);
    }

    public void mouseClicked(MouseEvent e) {
        handler.mouseClicked(e);
    }

    public void mouseEntered(MouseEvent e) {
        handler.mouseEntered(e);
    }

    public void mouseExited(MouseEvent e) {
        handler.mouseExited(e);
    }

    public void mousePressed(MouseEvent e) {
        handler.mousePressed(e);
    }

    public void mouseReleased(MouseEvent e) {
        handler.mouseReleased(e);
    }
    public static double mouseDistance(Point p){
        Point pm = new Point(mx, my);
        return p.distance(pm);
    }

    public static float mouseDistanceFloat(Point p){
        Point pm = new Point(mx, my);
        return (float)p.distance(pm);
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

