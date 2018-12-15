package Entities;

import GameState.GameStates.World1;
import Main.Game;
import Modules.RenderModule;
import java.awt.event.KeyEvent;

import java.awt.*;

public class Player extends Entity {

    private final int jumpKey;
    private final int leftKey;
    private final int rightKey;

    private float gravity = 0.25f;
    private float jumpStart = -10.0f;
    private float moveSpeed = 1.6f;
    private float maxSpeed = 2.3f;
    private float stopSpeed = 0.4f;
    private float dy = 0f;
    private float dx = 0f;

    private boolean falling = false;
    private boolean jumping = false;
    private boolean left = false;
    private boolean right = false;



    public Player(int x, int y, int width, int height, int jumpKey, int leftKey, int rightKey) {
        super(x, y, width, height);
        this.jumpKey = jumpKey;
        this.leftKey = leftKey;
        this.rightKey = rightKey;
    }

    @Override
    public void render(Graphics2D g) {

        g.setColor(Color.green);
        g.fillRect((int)getX(),(int)getY(),getWidth(),getHeight());
    }

    @Override
    public void tick() {
        if(left && right){
            dx = 0;
        } else if (left) {
            dx -= moveSpeed;
            if (dx < -maxSpeed) {
                dx = -maxSpeed;
            }
        } else if (right) {
            dx += moveSpeed;
            if (dx > maxSpeed) {
                dx = maxSpeed;
            }
        } else {
            if (dx > 0) {
                dx -= stopSpeed;
                if (dx < 0) {
                    dx = 0;
                }
            } else if (dx < 0) {
                dx += stopSpeed;
                if (dx > 0) {
                    dx = 0;
                }
            }
        }
        if(dy > 0 && getY() >= (Game.GAME_HEIGHT - getHeight())){
            dy = 0;
            falling = false;
        }
        if(jumping && !falling){
            dy += jumpStart;
            falling = true;
        }
        if(falling){
            dy += gravity;
            if(dy < 0 && !jumping){
                dy += stopSpeed;
            }
            if (dy > 0) {
                jumping = false;
            }
        }


        addX(dx);
        addY(dy);
        setY(RenderModule.clamp(getY(), 0,(Game.GAME_HEIGHT - getHeight())));
        //Game.sys(getY() + "");
    }

    @Override
    public void keyPressed(int k) {
        if(k == jumpKey){
            jumping = true;
        }
        if(k == leftKey){
            left = true;
        }
        if(k == rightKey){
            right = true;
        }
    }

    @Override
    public void keyReleased(int k) {
        if(k == jumpKey){
            jumping = false;
        }
        if(k == leftKey){
            left = false;
        }
        if(k == rightKey){
            right = false;
        }
    }
}
