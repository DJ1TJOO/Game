package Entities;

import java.awt.*;

public class Block extends Entity {
    Enum type;

    public Block(int x, int y, int width, int height, Enum type) {
        super(x, y, width, height);
        this.type = type;
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(Color.red);
        g.fillRect((int)x,(int)y, width, height);
        g.setColor(Color.darkGray);
        g.drawRect((int)x,(int)y, width, height);
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
