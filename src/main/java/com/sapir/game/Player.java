package com.sapir.game;

import java.util.Arrays;

public class Player extends Character {
    private Item [] inventory;

    public Player(String name, int health, int level) {
        super(name, health, level);
        inventory = new Item[5];
    }
    public Player(String name, int health, int level, Item[] inventory) {
        super(name, health, level);
        this.inventory = inventory;
    }

    public boolean addItem(Item item) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] == null) {
                inventory[i] = item;
                return true;
            }
        }
        return false;
    }
    public int calculateInventoryValue() {
        int totalValue = 0;
        for (Item item : inventory) {
            if (item != null) {
                totalValue += item.getValue();
            }
        }
        return totalValue;
    }
   public boolean hasMagicalItem() {
        for (Item item : inventory) {
            if (item != null && item.isMagical()) {
                return true;
            }
        }
        return false;
    }
   @Override
   public String toString() {
    boolean first = true;
    String inventory = "";
    for (Item item : this.inventory) {
        if (item != null) {
            if (!first) {
                inventory += " | ";
            }
            inventory += item.getName();
            first = false;
        }
    }
    return "Name: " + getName() + "\nHealth: "
            + getHealth() + "\nLevel: " + getLevel() +
            "\nInventory: " + inventory;
   }
    
    
}
