package Modules;

import Main.Game;

import java.awt.*;

public class BackgoundModule {
    Color skycolor;

    public BackgoundModule(Color skycolor){
        this.skycolor = skycolor;
    }

    public static void render(Graphics g){
        g.fillRect(0, 0, Game.PIX_WIDTH, Game.PIX_HEIGHT);
    }
}
