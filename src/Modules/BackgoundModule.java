package Modules;

import java.awt.*;

public class BackgoundModule {
    Color skycolor;

    public BackgoundModule(Color skycolor){
        this.skycolor = skycolor;
    }

    public static void render(Graphics g){
        g.fillRect();
    }
}
