package Entities;

import GameState.GameStates.World1;
import Main.Game;
import Modules.RenderModule;
import Modules.TerrainModule;

import java.awt.event.KeyEvent;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;

public class Player extends Entity {

    private final int jumpKey;
    private final int downKey;
    private final int leftKey;
    private final int rightKey;

    private float fallSpeed = 0.2f;
    private float dy = 0f;
    private float dx = 0f;

    private boolean falling = false;
    private boolean canJump = true;
    private boolean left = false;
    private boolean right = false;


    private Camera cam;

    public Player(int x, int y, int width, int height, int jumpKey, int downKey, int leftKey, int rightKey, Camera cam) {
        super(x, y, width, height);
        this.jumpKey = jumpKey;
        this.downKey = downKey;
        this.leftKey = leftKey;
        this.rightKey = rightKey;
        this.cam = cam;
        Game.sys(getY() + " y player");
    }

    @Override
    public void render(Graphics2D g) {

        g.setColor(Color.blue);
        g.fillRect((int)getX(),(int)getY(),getWidth(),getHeight());
    }

   boolean grafivtyfirst = false;

    @Override
    public void tick() {
        if(right && left){
            dx = 0;
        } else if (right) {
            dx = 5;
        } else if (left) {
            dx = -5;
        } else {
            dx = 0;
        }

        if(falling){
            fallSpeed *= 1.1;
            dy += fallSpeed;
            canJump = false;
            if (dy > 11) {
                dy = 11;
            }
        }
        setPosCheckCol();

        //Game.sys(dy + " dy player");
        Game.sys(getY() + " y player");
        Game.sys(getX() + " x player");
        //Game.sys(cam.getY() + " y cam");
    }

    private void setPosCheckCol() {
        /*List<Block> blocksinC = new ArrayList<Block>();
        for (Block block : TerrainModule.blocks.keySet()) {
            if(block.getX() < cam.getX() + Game && block.getX() > cam.getX()){
                if(block.getY() < cam.getY() + height && block.getY() > cam.getY()){
                    blocksinC.add(block);
                }
            }
        }
        for (Block block : blocksinC) {
            if(block.getBounds().intersects(rectDown) || block.getBounds().intersects(rectUp)){
                dy = 0;
                falling = false;
            }
            if(block.getBounds().intersects(rectLeft) || block.getBounds().intersects(rectRight)){
                dx = 0;
            }
        }
*/
       /* place_free hoort hier bij*/
       Rectangle rectDown = new Rectangle((int)(x + width / 2 - 7), (int)(y + height - 10), 14, 10);
        Rectangle rectUp = new Rectangle((int)(x + width / 2 - 7), (int)(y), 14, 10);
        Rectangle rectLeft = new Rectangle((int)(x), (int)(y + height / 2 - 7), 10, 14);
        Rectangle rectRight = new Rectangle((int)(x + width - 10), (int)(y + height / 2 - 7), 10, 14);
        for (Block block : TerrainModule.blocks.keySet()) {
                    if (!place_free((int) (x + dx), (int)y, getBounds(), block.getBounds())) {
                        dx = 0;
                    }

                    if (!place_free((int)x, (int) (y + dy), getBounds(), block.getBounds())) {
                        dy = 0;
                        canJump = true;
                        falling = false;
                    } else {
                        falling = true;
                        fallSpeed = 1.1f;
                    }
        }
        x += dx;
        y += dy;
    }

    private boolean place_free(int x, int y, Rectangle myRect, Rectangle otherRect) {
        myRect.x = x;
        myRect.y = y;
        if (myRect.intersects(otherRect)) {
            return false;
        }
        return true;
    }

    @Override
    public void keyPressed(int k) {
        if(k == jumpKey){
            if(canJump){
                dy = -15;
            }
        }
        if(k == downKey){
            //falling = true;
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
        if(k == downKey){
            //falling = false;
        }
        if(k == leftKey){
            left = false;
        }
        if(k == rightKey){
            right = false;
        }
    }

    public void mouseClicked(MouseEvent e) {

    }


    public Rectangle getBounds(){
        return new Rectangle((int)x,(int)y,width,height);
    }
}
