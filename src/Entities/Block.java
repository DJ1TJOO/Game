package Entities;

import Enums.BlockTypes;

import java.awt.*;

public class Block extends Entity {
    public Enum type;

    public Block(int x, int y, int width, int height, Enum type) {
        super(x, y, width, height);
        this.type = type;
    }

    @Override
    public void render(Graphics2D g) {
        //g.setColor(Color.red);
        //g.fillRect((int)x,(int)y, width, height);
        if(type == BlockTypes.STONE){
            g.setColor(Color.darkGray);
        }
        if(type == BlockTypes.GRASS){
            g.setColor(Color.green);
        }
        if(type == BlockTypes.DIRT){
            g.setColor(new Color(165,42,42));
        }
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

    public Rectangle getBounds(){
        return new Rectangle((int)x,(int)y,width,height);
    }
}
