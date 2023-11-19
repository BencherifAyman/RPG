//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package rpg;

public class Story {
    public Story() {
    }

    public static void printIntro() {
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("STORY");
        GameLogic.printSeparator(30);
        System.out.println("You are a villager who's family was kidnapped by an unknown man...");
        System.out.println("By becoming one of those gifted people, it's time to get back your family!");
        GameLogic.anythingToContinue();
    }

    public static void printEnd() {
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("END");
        GameLogic.printSeparator(30);
        System.out.println("Congratulations" + GameLogic.player.name);
        System.out.println("By becoming one of those gifted people, it's time to get back your family!");
        GameLogic.anythingToContinue();
    }
}
