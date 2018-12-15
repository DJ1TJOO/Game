package Modules;

import Main.Game;

import java.awt.*;

public class BackgoundModule {
    private Color skycolor;

    public BackgoundModule(Color skycolor){
        this.skycolor = skycolor;
    }

    public void render(Graphics g){
        g.setColor(skycolor);
        g.fillRect(-10000000, -10000000, 10000000 * 3, 10000000 * 3);
    }
}
