package Entities;

import java.awt.*;

abstract class Entity {
    private static int x, y, width, height;

    public Entity(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    abstract void render(Graphics2D g);

    abstract void tick();

    abstract void keyPressed(int k);

    abstract void keyReleased(int k);

    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }

    public static int getHeight() {
        return height;
    }

    public static int getWidth() {
        return width;
    }

    public static void setX(int x) {
        Entity.x = x;
    }

    public static void setY(int y) {
        Entity.y = y;
    }
}
