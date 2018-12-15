package Modules;

import Entities.Block;
import Enums.BlockTypes;
import Main.Game;

import java.awt.*;
import java.util.HashMap;
import java.util.Random;

public class TerrainModule {

    public static HashMap<Block, Integer> blocks = new HashMap<Block, Integer>();
    static int skyheight = 120;

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
        float HEIGHT_MAX = 300;

        double height = new Random().nextDouble() * HEIGHT_MAX;
        double slope = (new Random().nextDouble() * STEP_MAX) * 2 - STEP_MAX;

        Game.sys(height + " height");
        Game.sys(slope + " slope");

        for (int i = -50; i < 150; i++) {
            height += slope;
            slope += (new Random().nextDouble() * STEP_CHANGE) * 2 - STEP_CHANGE;

            // clip height and slope to maximum
            if (slope > STEP_MAX) { slope = STEP_MAX; }
            if (slope < -STEP_MAX) { slope = -STEP_MAX; }

            if (height > HEIGHT_MAX) {
                height = HEIGHT_MAX;
                slope *= -1;
            }
            if (height < 0) {
                height = 0;
                slope *= -1;
            }

            Game.sys(height + " height");
            Game.sys(slope + " slope");
            for (int y = 0; y < (HEIGHT_MAX); y++) {
                blocks.put(new Block(i * 64, (int)(y * 64 + (int)height * 64 - skyheight * 64), 64 ,64, BlockTypes.STONE), 1);
            }
            for (int y = ((int)HEIGHT_MAX - 50); y < (HEIGHT_MAX); y++) {
                blocks.put(new Block(i * 64, (int)(y * 64 - skyheight * 64), 64 ,64, BlockTypes.STONE), 1);
            }
        }

        //set block types

    }

    public static void render(Graphics2D g){
        for (Block block: blocks.keySet()) {
            block.render(g);
        }
    }
}
