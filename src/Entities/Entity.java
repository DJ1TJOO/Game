package Entities;

import java.awt.*;

public abstract class Entity {
    protected float x, y;
    protected int width, height;

    public Entity(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean intersects(Entity e) {
        Rectangle r1 = getRactangle();
        Rectangle r2 = e.getRactangle();
        return r1.intersects(r2);
    }

    public Rectangle getRactangle() {
        return new Rectangle((int) x - width, (int) y - height, width, height);
    }

    abstract public void render(Graphics2D g);

    abstract public void tick();

    abstract public void keyPressed(int k);

    abstract public void keyReleased(int k);

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void addX(float addX){
        setX(getX() + addX);
    }

    public void addY(float addY){
        setY(getY() + addY);
    }
}
