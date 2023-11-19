//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package rpg;

import java.util.ArrayList;
import java.util.HashMap;

public class WeaponStore {
    static ArrayList<Weapon> stock = new ArrayList();
    static HashMap<String, Integer> catalog = new HashMap();

    public WeaponStore() {
        catalog.put("Axe", 150);
        catalog.put("Bow", 150);
        catalog.put("Wand", 150);
        stock.add(new Axe());
        stock.add(new Bow());
        stock.add(new Wand());
    }

    public void showWeaponStore() {
        GameLogic.clearConsole();
        showItems();
        boolean exit = false;

        do {
            System.out.println("You actualy have : " + GameLogic.player.money + " Gold");
            System.out.println("Choose the weapon that you would like to buy");
            System.out.println("(1) => Axe");
            System.out.println("(2) => Bow");
            System.out.println("(3) => Wand");
            System.out.println("(4) => Exit weapon store");
            int input = GameLogic.readInt("->", 4);
            Player var10000;
            if (input == 1) {
                if (GameLogic.player.money >= (Integer)catalog.get("Axe")) {
                    GameLogic.player.inventory.add(new Axe(250.0));
                    var10000 = GameLogic.player;
                    var10000.money -= 150;
                    GameLogic.clearConsole();
                    showItems();
                    GameLogic.printHeading("You bought the axe !");
                } else {
                    GameLogic.clearConsole();
                    showItems();
                    GameLogic.printHeading("Sorry you don't have enought gold to buy this weapon !");
                }
            } else if (input == 2) {
                if (GameLogic.player.money >= (Integer)catalog.get("Bow")) {
                    GameLogic.player.inventory.add(new Bow(250.0));
                    var10000 = GameLogic.player;
                    var10000.money -= 150;
                    GameLogic.clearConsole();
                    showItems();
                    GameLogic.printHeading("You bought the Bow !");
                } else {
                    GameLogic.clearConsole();
                    showItems();
                    GameLogic.printHeading("Sorry you don't have enought gold to buy this weapon !");
                }
            } else if (input == 3) {
                if (GameLogic.player.money >= (Integer)catalog.get("Wand")) {
                    GameLogic.player.inventory.add(new Wand(250.0));
                    var10000 = GameLogic.player;
                    var10000.money -= 150;
                    GameLogic.clearConsole();
                    showItems();
                    GameLogic.printHeading("You bought the Wand !");
                } else {
                    GameLogic.clearConsole();
                    showItems();
                    GameLogic.printHeading("Sorry you don't have enought gold to buy this weapon !");
                }
            } else {
                exit = true;
            }
        } while(!exit);

    }

    public static void showItems() {
        for(int i = 0; i < stock.size(); ++i) {
            System.out.println(((Weapon)stock.get(i)).Ascii_art());
            System.out.println(((Weapon)stock.get(i)).getName() + " Price : " + catalog.get(((Weapon)stock.get(i)).getName()) + " gold" + " Damage : " + ((Weapon)stock.get(i)).damage);
        }

    }
}
