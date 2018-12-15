package Entities;

import java.awt.*;

public class Block extends Entity {
    public Block(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void render(Graphics2D g) {
        g.fillRect((int)x,(int)y, width, height);
    }

    @Override
    public void tick() {

    }

    @Override
    public void keyPressed(int k) {

    }

    @Override
    public void keyReleased(int k) {

    }
}
