package GameState;

import java.awt.Graphics2D;

public abstract class GameState {

    protected GameStateManager gsm;
    public boolean pause;

    public abstract void init();

    public abstract void unload();

    public abstract void render(Graphics2D g);

    public abstract void tick();

    public abstract void keyPressed(int k);

    public abstract void keyReleased(int k);
}
