//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package rpg;

public class Monster extends Destructible {
    public Monster() {
        super(400, "Monster", 60);
    }

    public void hit_me(double damage) {
        super.life = (int)((double)super.life - damage);
    }
}
