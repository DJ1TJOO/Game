package Modules;

import Entities.Block;
import Entities.Camera;
import Enums.BlockTypes;
import Main.Game;

import java.awt.*;
import java.util.HashMap;
import java.util.Random;

public class TerrainModule {

    public static HashMap<Block, Integer> blocks = new HashMap<Block, Integer>();
    static int skyheight = 120;
    public static int size = 64;
    public static Block[][] tilemap = new Block[1510][1210];

    public static void generate() {
        /*int id = 0;
        for (int blockX = -50; blockX < 150; blockX++) {
            Random r = new Random();
            int yAdd = r.nextInt(4);
            Game.sys(yAdd + "");
            for (int i = 0; i < (height); i++) {
                id++;
                blocks.put(new Block(blockX * 64, i * 64 - yAdd * 64 + skyheight * 64, 64 ,64), id);
            }
        }*/

        //generate blocks
        float STEP_MAX = 0.64f;
        float STEP_CHANGE = 0.2f;
        int HEIGHT_MAX = 30;

        double height = new Random().nextDouble() * HEIGHT_MAX;
        double slope = (new Random().nextDouble() * STEP_MAX) * 2 - STEP_MAX;

        //Game.sys(height + " height");
        //Game.sys(slope + " slope");

        for (int i = 0; i < 150; i++) {
            height += slope;
            slope += (new Random().nextDouble() * STEP_CHANGE) * 2 - STEP_CHANGE;

            // clip height and slope to maximum
            if (slope > STEP_MAX) { slope = STEP_MAX; }
            if (slope < -STEP_MAX) { slope = -STEP_MAX; }

            if (height > HEIGHT_MAX) {
                height = HEIGHT_MAX;
                slope *= -1;
            }
            if (height < 10) {
                height = 10;
                slope *= -1;
            }

            //Game.sys(height + " height");
            //Game.sys(slope + " slope");

            for (int y = HEIGHT_MAX; y < (100); y++) {
                int xx = i * size;
                int yy = (int)(y * size + skyheight * size);
                Block block = new Block(xx, yy, size ,size, BlockTypes.STONE);
                // Game.sys("Tilemap: x:" + xx/size + " y:" + yy/size + " isSet");
                tilemap[xx/size][yy/size] = block;
                blocks.put(block, 1);
            }
            for (int y = 0; y < (HEIGHT_MAX + 20); y++) {
                int xx = i * size;
                int yy = (int)(y * size + (int)height * size + skyheight * size);
                Block block = new Block(xx, yy, size ,size, BlockTypes.STONE);
                tilemap[xx/size][yy/size] = block;
                //Game.sys("Tilemap: x:" + xx/size + " y:" + yy/size + " isSet");
                blocks.put(block, 1);
            }
        }

        //set block types
        for (int i = 0; i < 150; i++){
            Block top = getTopBlock(i*64);
            top.type = BlockTypes.GRASS;
            int r = MathModule.getRandomNumberInRange(5, 10);
            for(int ri = 1; ri < r; ri++){
                tilemap[i][(int)top.getY()/64 + ri].type = BlockTypes.DIRT;
            }
        }
    }

    public static void render(Graphics2D g, Camera cam){
        for (Block block: blocks.keySet()) {
            if(block.getX() < cam.getX() + Game.GAME_WIDTH + size && block.getX() > cam.getX() - size){
                if(block.getY() < cam.getY() + size + Game.GAME_HEIGHT && block.getY() > cam.getY() - size){
                    block.render(g);
                }
            }
        }
    }

    public static int getTop(float x){
        Block currentTop = null;
        int currentY = 10000;
        for (Block block: blocks.keySet()) {
            if(block.getY() < currentY && block.getX() == x){
                currentTop = block;
                currentY = (int)block.getY();
            }
        }
        return currentY;
    }
    public static Block getTopBlock(float x){
        Block currentTop = null;
        int currentY = 10000;
        for (Block block: blocks.keySet()) {
            if(block.getY() < currentY && block.getX() == x){
                currentTop = block;
                currentY = (int)block.getY();
            }
        }
        return currentTop;
    }
}
