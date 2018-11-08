package modules;

import java.awt.*;

public class Button {
    private int x, y, width, height;
    private String name, text, action;
    private boolean over = false, isPressed = false;
    private Font textFont;

    public Button(String name, String text, int x, int y, int width, int height, String action){
        this.name = name;
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.action = action;
        textFont = new Font("Century Gothic", Font.PLAIN, height - height/5);
    }

    public void tick(){

    }

    public void mouseClicked() {
        if(MouseListenerModule.mouseHover(x,y,width,height)){
            isPressed = true;
        } else {
            isPressed = false;
        }
    }

    public void render(Graphics2D g){
        g.setColor(Color.red);
        g.fillRect(x,y,width,height);
        g.setColor(Color.black);
        RenderModule.drawCenteredString(g, text, new Rectangle(x, y, width, height), textFont);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public boolean isOver(){
        return over;
    }

    public boolean isPressed() {
        return isPressed;
    }

    public String getAction() {
        return action;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setOver(Boolean over){
        this.over = over;
    }

    public void setPressed(Boolean isPressed){
        this.isPressed = isPressed;
    }

    public void setAction(String action) {
        this.action = action;
    }

}
