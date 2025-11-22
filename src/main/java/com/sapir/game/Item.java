package com.sapir.game;

public class Item {
    private String name;
    private int value;
    private boolean isMagical;

    public Item() {
        this.name = "Unknown";
        this.value = 0;
        this.isMagical = false;
    }
    public Item(String name, int value, boolean isMagical) {
        this.name = name;
        this.value = value;
        this.isMagical = isMagical;
    }
    public String getName() {
        return name;
    }
    
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public boolean isMagical() {
        return isMagical;
    }
    @Override
    public String toString() {
        return "Name: " + name + "\nValue: " + value + "\n" +( isMagical ? "Magical Item" : "Non-Magical Item");
    }
    
    
}
