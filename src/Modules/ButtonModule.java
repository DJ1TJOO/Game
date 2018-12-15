package Modules;

import Entities.Entity;
import Enums.CommanderTypes;
import GameState.GameStateManager;
import GameState.GameStates.World1;
import Main.Game;

import java.awt.*;

public class ButtonModule {
    private GameStateManager gsm;
    private Image image;
    private int x, y, width, height;
    private String name, text, action;
    private boolean over = false, isPressed = false;
    private Font textFont;

    public ButtonModule(String name, String text, int x, int y, int width, int height, String action, GameStateManager gsm) {
        this.name = name;
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.action = action;
        this.gsm = gsm;
        textFont = new Font("Century Gothic", Font.PLAIN, height - height / 5);
    }

    public ButtonModule(String name, String text, int x, int y, int width, int height, String action, GameStateManager gsm, Image image) {
        this.name = name;
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.action = action;
        this.gsm = gsm;
        this.image = image;
        textFont = new Font("Century Gothic", Font.PLAIN, height - height / 5);
    }

    public void tick() {
        action();
        if (!MouseListenerModule.mouseHover(x, y, width, height)) {
            isPressed = false;
        }

    }

    public void mouseClicked() {
        if (MouseListenerModule.mouseHover(x, y, width, height)) {
            isPressed = true;
        } else {
            isPressed = false;
        }
    }

    public void render(Graphics2D g) {
        if (image == null) {
            g.setColor(Color.red);
            g.fillRect(x, y, width, height);
        } else {
            g.drawImage(image, x, y,null);
        }
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

    public boolean isOver() {
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

    public void setOver(Boolean over) {
        this.over = over;
    }

    public void setPressed(Boolean isPressed) {
        this.isPressed = isPressed;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void action(){
        if (isPressed()) {
            String action1 = this.action.substring(1, this.action.length());
            if(action.startsWith("/")){
                String[] args = action1.split(" ");
                Commander commander;
                Entity entity;
                if(GameStateManager.getCurrentGameStateString().equals("MENUSTATE")){
                    commander = new Commander(0,0,0,0,"client", CommanderTypes.CLIENT);
                    entity = null;
                } else if(GameStateManager.getCurrentGameStateString().equals("WORLD")){
                    commander = new Commander(0,0,0,0,"player", CommanderTypes.PLAYER);
                    entity = null;
                    for (Entity entity1: World1.players) {
                        entity = entity1;
                    }
                } else {
                    commander = new Commander(0,0,0,0,"server", CommanderTypes.SERVER);
                    entity = null;
                }
                ExecuteModule.execute(entity, commander, args, action1, gsm);
                isPressed = false;
            }
        }
    }

}
