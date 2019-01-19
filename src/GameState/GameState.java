package GameState;

import Entities.Camera;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public abstract class GameState {

    protected GameStateManager gsm;
    protected Camera cam;
    public boolean pause;

    public abstract void init();

    public abstract void unload();

    public abstract void renderHud(Graphics2D g);

    public abstract void render(Graphics2D g);

    public abstract void tick();

    public abstract void keyPressed(int k);

    public abstract void keyReleased(int k);

    public abstract void mouseClicked(MouseEvent e);

    public abstract void mouseEntered(MouseEvent e);

    public abstract void mouseExited(MouseEvent e);

    public abstract void mousePressed(MouseEvent e);

    public abstract void mouseReleased(MouseEvent e);
}
