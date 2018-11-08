package modules;

import java.awt.*;

public class Button {
    private int x, y;
    private String name, text;

    public Button(String name, String text, int x, int y){
        this.name = name;
        this.text = text;
        this.x = x;
        this.y = y;
    }

    public void tick(){

    }

    public void render(Graphics2D g){

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setText(String text) {
        this.text = text;
    }
}
