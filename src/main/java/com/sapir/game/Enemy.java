package com.sapir.game;

public class Enemy extends Character {

    private int damage;

    public Enemy(String name, int health, int level, int damage) {
        super(name, health, level);
        setDamage(damage);
    }

    public int getDamage() {
        return damage;
    }

    private void setDamage(int damage) {
        if (damage < 1) {
            this.damage = 1;
        } else if (damage > 5) {
            this.damage = 5;
        } else {
            this.damage = damage;
        }
    }

    @Override
    public String toString() {
        return  "Name: " + getName() + "\n" +
                "Health: " + getHealth() + "\n" +
                "Level: " + getLevel() + "\n" +
                "Damage: " + damage;
    }
}
