package com.sapir.game;

public class GameWorld {
    private String name;
    private Player[] players;
    private Enemy[] enemies;
    private int difficulty;

    public GameWorld() {
        this.name = "Crystalpath";
        this.difficulty = 1;
        this.players = new Player[5];
        this.enemies = new Enemy[5];
    }
    public GameWorld(String name, int difficulty) {
        this.name = name;
        this.difficulty = difficulty;
        this.players = new Player[5];
        this.enemies = new Enemy[5];
    }
    public void addPlayer(Player player) {
        for (int i = 0; i < players.length; i++) {
            if (players[i] == null) {
                players[i] = player;
                return;
            }
        }
    }
    public void addEnemy(Enemy enemy) {
        for (int i = 0; i < enemies.length; i++) {
            if (enemies[i] == null) {
                enemies[i] = enemy;
                return;
            }
        }
    }
    public void printAllPlayers() {
        int count = 1;
        for (Player p : players) {
            if (p != null) {
                System.out.println("---------Player " + count +"----------");
                System.out.println(p.toString());
                
            }
            count++;
        }
    }
    public int getTotalValueOfWorld() {
        int total = 0;
        for (Player p : players) {
            if (p != null) {
                total += p.calculateInventoryValue();
            }
        }
        return total;
    }
    @Override
    public String toString() {
        int count = 0;
        for (Player p : players) {
            if (p != null) count++;
        }
        return "World Name: " + name + "\nDifficulty: " + difficulty + "\nNumber of players: " + count;
    }
}
