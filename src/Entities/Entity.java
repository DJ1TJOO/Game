package Entities;

import java.awt.*;

abstract class Entity {
    private static float x, y;
    private static int width, height;

    public Entity(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    abstract void render(Graphics2D g);

    abstract void tick();

    abstract void keyPressed(int k);

    abstract void keyReleased(int k);

    public static float getX() {
        return x;
    }

    public static float getY() {
        return y;
    }

    public static int getHeight() {
        return height;
    }

    public static int getWidth() {
        return width;
    }

    public static void setX(float x) {
        Entity.x = x;
    }

    public static void setY(float y) {
        Entity.y = y;
    }
}
