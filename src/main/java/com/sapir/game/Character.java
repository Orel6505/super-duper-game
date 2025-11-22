package com.sapir.game;

public class Character {

    private String name;
    private int health;
    private int level;

    public Character() {
        this.name = "Unknown";
        this.health = 0;
        this.level = 0;
    }

    public Character(String name, int health, int level) {
        this.name = name;
        setHealth(health);
        setLevel(level);
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public void levelUp() {
        if (level < 5) {
            level++;
        }
    }

    public void heal(int amount) {
        if (amount > 0) {
            health += amount;
            if (health > 10) {
                health = 10;
            }
        }
    }

    private void setHealth(int health) {
        if (health < 0) {
            this.health = 0;
        } else if (health > 10) {
            this.health = 10;
        } else {
            this.health = health;
        }
    }

    private void setLevel(int level) {
        if (level < 0) {
            this.level = 0;
        } else if (level > 5) {
            this.level = 5;
        } else {
            this.level = level;
        }
    }

    @Override
    public String toString() {
        return  "Name: " + name + "\n" +
                "Health: " + health + "\n" +
                "Level: " + level;
    }
}
