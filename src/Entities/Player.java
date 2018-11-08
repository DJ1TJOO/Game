package Entities;

import Main.Game;
import Modules.RenderModule;

import java.awt.*;

public class Player extends Entity {

    private float gravity = 1.2f;
    private float stopSpeed = 0f;
    private float dy = 0f;

    private boolean falling = false;

    public Player(float x, float y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void render(Graphics2D g) {

        g.setColor(Color.green);
        g.fill3DRect((int)getX(),(int)getY(),getWidth(),getHeight(), true);
    }

    @Override
    public void tick() {
        if(!(getY() >= (Game.HEIGHT - getHeight()))){
            falling = true;
        } else {
            falling = false;
        }
        if(falling){
            dy += gravity * 0.1;
        }

        setY(getY() + dy);
        setY(RenderModule.clamp(getY(), 0,(float)(Game.HEIGHT - getHeight())));
    }

    @Override
    void keyPressed(int k) {

    }

    @Override
    void keyReleased(int k) {

    }
}
