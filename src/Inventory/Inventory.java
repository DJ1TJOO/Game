package Inventory;

import Entities.Block;
import Enums.BlockTypes;
import Main.Game;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Inventory {

    public List<Item> items = new ArrayList<Item>();


    public Inventory() {

    }

    public void tick(){

    }

    public void render(Graphics2D g){

        /*g.setColor(Color.DARK_GRAY);
        int height = (int)(Game.PIX_HEIGHT/1.7);
        int width = Game.PIX_WIDTH/4;
        g.fillRect(0, 0, width, height);
        int aIR = 10;
        int size = width/(aIR * 2);
        Game.sys(size + "");
        int xx = width/(aIR);
        int yy = 15;
        for (Block block : inventoryBlocks) {
            if(block.type == BlockTypes.STONE){
                g.setColor(Color.darkGray);
            }
            if(block.type == BlockTypes.GRASS){
                g.setColor(Color.green);
            }
            if(block.type == BlockTypes.DIRT){
                g.setColor(new Color(165,42,42));
            }
            g.fillRect(xx,yy, size,size);
            xx+= size + width/(size + aIR);
        }*/
    }
}
