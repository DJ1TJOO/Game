package Entities;

import Enums.BlockTypes;
import Enums.ItemTypes;
import Inventory.Item;
import Main.Game;
import Modules.TerrainModule;

import java.awt.*;

public class Block extends Entity {
    public Enum type;
    boolean visible = true;
    TerrainModule tm;

    public Block(int x, int y, int width, int height, BlockTypes type, TerrainModule tm) {
        super(x, y, width, height);
        this.type = type;
        this.tm = tm;
    }

    public Item createItem(){
        return new Item(ItemTypes.blockToItem(type));
    }

    @Override
    public void render(Graphics2D g) {
        //g.setColor(Color.red);
        //g.fillRect((int)x,(int)y, width, height);
        if(visible){
            if(type == BlockTypes.STONE){
                g.setColor(Color.darkGray);
            }
            if(type == BlockTypes.GRASS){
                g.setColor(Color.green);
            }
            if(type == BlockTypes.DIRT){
                g.setColor(new Color(165,42,42));
            }
        } else {
            g.setColor(Color.black);
        }
        g.fillRect((int)x,(int)y, width, height);
    }

    @Override
    public void tick() {
        //no null this, left, right, up, down
        if(x/64 > 0 && y/64 > 0 && tm.tilemap[(int)x/64][(int)y/64] != null && tm.tilemap[(int)x/64 - 1][(int)y/64] != null && tm.tilemap[(int)x/64 + 1][(int)y/64] != null && tm.tilemap[(int)x/64][(int)y/64 - 1] != null && tm.tilemap[(int)x/64][(int)y/64 + 1] != null){
            visible = false;
        } else {
            visible = true;
        }
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
