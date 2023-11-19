//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package rpg;

import java.util.Scanner;

public class GameLogic {
    static Scanner scanner;
    static Player player;
    public static boolean isRunning;

    static {
        scanner = new Scanner(System.in);
    }

    public GameLogic() {
    }

    public static int readInt(String prompt, int userChoices) {
        int input;
        do {
            System.out.println(prompt);

            try {
                input = Integer.parseInt(scanner.next());
            } catch (Exception var4) {
                input = -1;
                System.out.println("Please enter an integer");
            }
        } while(input < 1 || input > userChoices);

        return input;
    }

    public static void clearConsole() {
        for(int i = 0; i < 100; ++i) {
            System.out.println();
        }

    }

    public static void printSeparator(int n) {
        for(int i = 0; i < n; ++i) {
            System.out.print("-");
        }

        System.out.println();
    }

    public static void printHeading(String title) {
        printSeparator(30);
        System.out.println(title);
        printSeparator(30);
    }

    public static void anythingToContinue() {
        System.out.println("\nEnter anything to continue...");
        scanner.next();
    }

    public static void startGame() {
        boolean nameSet = false;
        clearConsole();
        printSeparator(40);
        printSeparator(30);
        System.out.println("Text RPG ");
        printSeparator(30);
        anythingToContinue();

        String name;
        do {
            clearConsole();
            printHeading("Please Choose a name for your character");
            name = scanner.next();
            clearConsole();
            printHeading("Are you sure about this name ?");
            System.out.println("(1) => Yes ! ");
            System.out.println("(2) => No ! make a change ");
            int input = readInt("->", 2);
            if (input == 1) {
                nameSet = true;
            }
        } while(!nameSet);

        Story.printIntro();
        player = new Player(name);
        isRunning = true;
        gameLoop();
    }

    public static void gameLoop() {
        while(isRunning) {
            printMenu();
            int input = readInt("->", 4);
            if (input == 1) {
                startAdventure();
                isRunning = false;
            } else if (input == 2) {
                characterInfo();
            } else if (input == 3) {
                WeaponStore shop = new WeaponStore();
                shop.showWeaponStore();
            } else {
                isRunning = false;
            }
        }

    }

    public static void startAdventure() {
        Map map = new Map();
        map.showMap();
    }

    public static void printMenu() {
        clearConsole();
        printHeading("MENU");
        System.out.println("Choose an action:");
        printSeparator(20);
        System.out.println("(1) => Start adventure");
        System.out.println("(2)=> Character information");
        System.out.println("(3) => Go to the weapon store ");
        System.out.println("(4) => Exit Game ");
    }

    public static void characterInfo() {
        clearConsole();
        printHeading("CHARACTER INFO");
        System.out.println(player.name);
        System.out.println("\tHP: " + player.hp + "/" + player.maxHp);
        System.out.println("\tMoney: " + player.money);
        System.out.println("\tWeapon equiped: " + player.weapon.name + "\tDamage : " + player.weapon.damage);
        System.out.println(player.weapon.getAscii());
        System.out.println();
        printSeparator(20);
        System.out.println("(1) => change equipement");
        System.out.println("(2) => go back to the main menu");
        int input2 = readInt("->", 2);
        if (input2 == 1) {
            player.changeWeapon();
            gameLoop();
        }

    }
}
