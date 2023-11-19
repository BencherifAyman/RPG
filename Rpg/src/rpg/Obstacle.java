//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package rpg;

public class Obstacle extends Destructible {
    public Obstacle() {
        super(400, "Obstacle", 60);
    }

    public void hit_me(double damage) {
        super.life = (int)((double)super.life - damage);
    }
}
