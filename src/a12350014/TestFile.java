package a12350014;

import java.util.*;

/**
 * TestFile.java
 * This class serves as an extensive demonstration of the Hogwarts Legacy project implementation
 * for the Programming 2 course at the University of Vienna (SS 2025).
 * It tests:
 * - Creation of wizards, spells, and items
 * - Magic interactions (casting, protection, damage, healing)
 * - Trading, stealing, and looting behavior
 * - Potion and scroll usage
 * - Boundary and exception behavior
 * Author: a12350014
 */
public class TestFile {

    public static void main(String[] args) {
        System.out.println("=== Hogwarts Legacy Implementation Test ===\n");

        // -------------------------
        // 1. Setup: Wizards
        // -------------------------
        Wizard harry = new Wizard("Harry", MagicLevel.STUDENT, 100, 150, 300, 50,
                1000,
                new HashSet<>(), new HashSet<>(), 500, new HashSet<>());
        Wizard draco = new Wizard("Draco", MagicLevel.ADEPT, 80, 120, 150, 40, 1500,
                new HashSet<>(), new HashSet<>(), 400, new HashSet<>());

        System.out.println("Initial Wizards:");
        System.out.println(harry);
        System.out.println(draco + "\n");

        // -------------------------
        // 2. Spells
        // -------------------------
        AttackingSpell confringo = new AttackingSpell("Confringo", 10, MagicLevel.NOOB, true, false, 20);
        AttackingSpell bombarda = new AttackingSpell("Bombarda", 20, MagicLevel.ADEPT, true, true, 50);
        HealingSpell episkey = new HealingSpell("Episkey", 5, MagicLevel.NOOB, true, false, 20);
        ProtectingSpell protego = new ProtectingSpell("Protego", 10, MagicLevel.ADEPT,
                new HashSet<>(Arrays.asList(confringo, bombarda)));

        // Wizards learn spells
        harry.learn(confringo);
        harry.learn(episkey);
        draco.learn(bombarda);
        draco.learn(protego);

        System.out.println("After learning spells:");
        System.out.println(harry);
        System.out.println(draco + "\n");

        // -------------------------
        // 3. Casting and Effects
        // -------------------------
        System.out.println("Casting spells:");
        harry.castSpell(confringo, draco); // should damage Draco
        draco.castSpell(protego, draco);   // Draco protects himself
        harry.castSpell(confringo, draco); // Draco protected -> should remove protection
        harry.castSpell(confringo, draco); // should hit again

        System.out.println("\nAfter spell casting:");
        System.out.println(harry);
        System.out.println(draco + "\n");

        // Draco heals himself
        draco.castSpell(episkey, draco);
        System.out.println("After healing attempt (should fail - Draco doesn't know Episkey):");
        System.out.println(draco + "\n");

        // Harry heals himself
        harry.castSpell(episkey, harry);
        System.out.println("After healing self:");
        System.out.println(harry + "\n");

        // -------------------------
        // 4. Magic Items
        // -------------------------
        HealthPotion healthPotion = new HealthPotion("Health Potion", 3, 10, 1, 15);
        ManaPotion manaPotion = new ManaPotion("Mana Potion", 2, 15, 1, 25);
        Scroll scrollOfBombarda = new Scroll("Scroll of Bombarda", 2, 50, 1, bombarda);

        // Add to inventories
        harry.addToInventory(healthPotion);
        harry.addToInventory(manaPotion);
        harry.addToInventory(scrollOfBombarda);

        System.out.println("After adding items to Harry's inventory:");
        System.out.println(harry + "\n");

        // Harry uses items
        harry.useItem(healthPotion, harry);
        harry.useItem(manaPotion, harry);
        harry.useItem(scrollOfBombarda, draco);

        System.out.println("After using all items:");
        System.out.println(harry);
        System.out.println(draco + "\n");

        // -------------------------
        // 5. Trading
        // -------------------------
        System.out.println("Trading test:");
        harry.sellItem(manaPotion, draco);
        System.out.println("After trading mana potion:");
        System.out.println(harry);
        System.out.println(draco + "\n");

        // -------------------------
        // 6. Stealing and Looting
        // -------------------------
        System.out.println("Stealing test:");
        draco.steal(harry);
        System.out.println("After theft:");
        System.out.println(harry);
        System.out.println(draco + "\n");

        System.out.println("Simulating Draco's death (damage until HP = 0):");
        while (!draco.isDead()) {
            harry.castSpell(confringo, draco);
        }
        System.out.println("Draco is dead: " + draco.isDead());
        System.out.println(draco + "\n");

        System.out.println("Harry attempts to loot Draco:");
        harry.loot(draco);
        System.out.println("After looting:");
        System.out.println(harry);
        System.out.println(draco + "\n");

        // -------------------------
        // 7. Concoction Example
        // -------------------------
        List<Spell> miniSpells = new ArrayList<>();
        miniSpells.add(new AttackingSpell("Diffindo", 10, MagicLevel.NOOB, true, false, 15));
        Concoction brew = new Concoction("My Brew", 4, 10, 1, 5, 10, miniSpells);

        harry.addToInventory(brew);
        harry.useItem(brew, draco);
        System.out.println("After using a Concoction:");
        System.out.println(harry);
        System.out.println(draco + "\n");

        // -------------------------
        // 8. Randomized Actions
        // -------------------------
        System.out.println("Randomized actions:");
        harry.castRandomSpell(draco);
        harry.useRandomItem(draco);
        System.out.println("Final state:");
        System.out.println(harry);
        System.out.println(draco + "\n");

        System.out.println("=== End of Test ===");
    }
}
