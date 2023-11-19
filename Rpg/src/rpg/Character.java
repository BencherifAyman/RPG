//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package rpg;

import java.util.ArrayList;

public abstract class Character {
    protected String name;
    protected int maxHp;
    protected int hp;
    protected ArrayList<Weapon> inventory = new ArrayList();
    protected Weapon weapon;
    protected int money;
    protected String classe;
    protected int honor;

    public Character(String name) {
        this.name = name;
    }

    public boolean isDead() {
        return this.hp <= 0;
    }

    public abstract void attack(Destructible var1);

    public abstract void hit_me(double var1);
}
