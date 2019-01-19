package Inventory;

import Enums.ItemTypes;

import java.util.HashMap;

public class Slot {
    private int ID, x, y;
    private HashMap<ItemTypes, Integer> contains = new HashMap<ItemTypes, Integer>();

    public Slot(int ID, int x, int y) {
        this.ID = ID;
        this.x = x;
        this.y = y;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public HashMap<ItemTypes, Integer> getContains() {
        return contains;
    }

    public void setContains(HashMap<ItemTypes, Integer> contains) {
        this.contains = contains;
    }

    public void addContains(ItemTypes type, int amount) {
        this.contains.put(type, amount);
    }

    public void deleteContains(ItemTypes type) {
        this.contains.remove(type);
    }

    public void removeAmountContains(ItemTypes type, int removeAmount) {
        this.contains.put(type, this.contains.get(type) - removeAmount);
    }

}
