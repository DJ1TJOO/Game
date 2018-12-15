package Modules;

import Entities.Entity;

import java.awt.*;

public class Commander extends Entity {
    String name;
    Enum type;

    public Commander(int x, int y, int width, int height, String name, Enum type){
        super(x, y, width, height);
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Enum getType() {
        return type;
    }

    public void setType(Enum type) {
        this.type = type;
    }

    @Override
    public void render(Graphics2D g) {

    }

    @Override
    public void tick() {

    }

    @Override
    public void keyPressed(int k) {

    }

    @Override
    public void keyReleased(int k) {

    }
}
