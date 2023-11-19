//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package rpg;

public class Player extends Character {
    public Player(String name) {
        super(name);
        this.money = 300;
        this.ChooseClasse();
    }

    public void attack(Destructible enemy) {
        enemy.life = (int)((double)enemy.life - this.weapon.damage);
    }

    public void hit_me(double damage) {
        this.hp = (int)((double)this.hp - damage);
    }

    public void ChooseClasse() {
        GameLogic.clearConsole();
        GameLogic.printHeading("Choose your classe");
        System.out.println("(1) => Warrior : A classe with great hp but less pm");
        System.out.println("(2) => Archer : A classe with a good balance between HP and PM");
        System.out.println("(3) => Magicien : A classe with a good great pm but less HP");
        int input = GameLogic.readInt("->", 3);
        GameLogic.clearConsole();
        if (input == 1) {
            GameLogic.printHeading("You choose Warrior as your classe ! ");
            this.maxHp = 1000;
            this.hp = 1000;
            this.classe = "Warrior";
            this.inventory.add(new Axe());
            this.weapon = (Weapon)super.inventory.get(0);
        } else if (input == 2) {
            GameLogic.printHeading("You choose Archer as your classe ! ");
            this.maxHp = 1000;
            this.hp = 1000;
            this.classe = "Archer";
            this.inventory.add(new Bow());
            this.weapon = (Weapon)super.inventory.get(0);
        } else {
            GameLogic.printHeading("You choose Magicien as your classe ! ");
            this.maxHp = 1000;
            this.hp = 1000;
            this.classe = "Magicien";
            this.inventory.add(new Wand());
            this.weapon = (Weapon)super.inventory.get(0);
        }

        GameLogic.anythingToContinue();
    }

    public int getMoney() {
        return this.money;
    }

    public void changeWeapon() {
        boolean exit = false;
        System.out.println("Your current weapon: " + this.weapon.getName() + ". Do you want to change ?");
        System.out.println("(1) => Yes");
        System.out.println("(2) => No");

        do {
            int input = GameLogic.readInt("->", 2);
            if (input != 1) {
                exit = true;
            } else {
                System.out.println("Select a weapon in your inventory");

                int input2;
                for(input2 = 0; input2 < this.inventory.size(); ++input2) {
                    System.out.println(input2 + 1 + "-" + ((Weapon)this.inventory.get(input2)).getName());
                }

                if (this.inventory.size() > 2) {
                    System.out.println("(1) => To equip the first weapon");
                    System.out.println("(2) => To equip the second weapon");
                    System.out.println("(3) => To equip the third weapon");
                    input2 = GameLogic.readInt("->", 3);
                    if (input2 == 1) {
                        System.out.println("You succefully equiped the first weapon !");
                    }

                    exit = true;
                    if (input2 == 2) {
                        System.out.println("You succefully equiped the second weapon !");
                    }

                    exit = true;
                    if (input2 == 3) {
                        System.out.println("You succefully equiped the third weapon !");
                    }

                    exit = true;
                } else if (this.inventory.size() == 2) {
                    System.out.println("(1) => To equip the first weapon");
                    System.out.println("(2) => To equip the second weapon");
                    input2 = GameLogic.readInt("->", 2);
                    if (input2 == 1) {
                        System.out.println("You succefully equiped the first weapon !");
                    }

                    exit = true;
                    if (input2 == 2) {
                        System.out.println("You succefully equiped the second weapon !");
                    }

                    exit = true;
                } else {
                    System.out.println("Sorry you don't have other weapon to use !");
                }

                exit = true;
            }
        } while(!exit);

    }
}
