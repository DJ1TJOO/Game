package Entities;

import java.awt.*;

public class Player extends Entity {

    private float gravity = 1.2f;

    public Player(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void render(Graphics2D g) {

        g.setColor(Color.green);
        g.fill3DRect(getX(),getY(),getWidth(),getHeight(), true);
    }

    @Override
    public void tick() {
        
    }

    @Override
    void keyPressed(int k) {

    }

    @Override
    void keyReleased(int k) {

    }
}
