package com.sapir.game;

public class Main {
    public static void main(String[] args) {
         // 1. יצירת חפצים (Items)
        Item sword = new Item("Diamond Sword", 30, true);
        Item book = new Item("Iron Pickaxe", 20, false);
        Item shield = new Item("Diamond Axe", 15, false);
        Item wand = new Item("Iron Pickaxe", 15, false);

        // 2. יצירת שחקנים (Player)
        Player p1 = new Player("Steve", 10, 3);
        Player p2 = new Player("Alex", 10, 3);

        // הוספת חפצים לשחקנים
        p1.addItem(book);
        p1.addItem(sword);

        p2.addItem(shield);
        p2.addItem(wand);

        // 3. יצירת אויב (Enemy)
        Enemy enemy = new Enemy("Creeper", 8, 2, 3);

        // 4. יצירת עולם משחק (GameWorld)
        GameWorld world = new GameWorld();

        // הוספת שחקנים לעולם
        world.addPlayer(p1);
        world.addPlayer(p2);

        // 5. הצגת כל השחקנים
        System.out.println("=== All Players in Game ===");
        world.printAllPlayers();

        // 6. חישוב ערך כולל של כל החפצים בעולם
        for (Player p : world.getPlayers()) {
            if (p != null) {
                System.out.println("Total inventory value for " + p.getName() + ": " + p.calculateInventoryValue());
            }
        }

        // 7. סימולציית קרב בין שחקן לאויב
        System.out.println("\n=== Battle Simulation ===");
        simulateBattle(p1, enemy);

        // 8. תוצאות הסופיות
        System.out.println("\n=== World Summary ===");
        System.out.println(world);
    }


    // ------ סימולציית קרב ------
    public static void simulateBattle(Player player, Enemy enemy) {
        System.out.println(player.getName() + " - level: " + player.getLevel() +
                " VS " + enemy.getName() + " - level: " + enemy.getLevel());

        if (player.getLevel() > enemy.getLevel()) {
            System.out.println(player.getName() + " wins!");
            player.levelUp();
        }
        else if (enemy.getLevel() > player.getLevel()) {
            System.out.println(enemy.getName() + " wins!");
        }
        else {
            // רמות שוות → בדיקה לפי health
            if (player.getHealth() >= enemy.getHealth()) {
                System.out.println(player.getName() + " wins!");
                player.levelUp();
            } else {
                System.out.println(enemy.getName() + " wins!");
            }
        }
    }
}