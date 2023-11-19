//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package rpg;

public abstract class Destructible {
    protected int life;
    protected String name;
    protected int damage;

    public Destructible(int life, String name, int damage) {
        this.life = life;
        this.name = name;
        this.damage = damage;
    }

    public Destructible(String boss, int bossMaxHp, int bossAttack, int bossDefense) {

    }

    public abstract void hit_me(double var1);

    protected void attackPlayer() {
        GameLogic.player.hit_me((double)this.damage);
    }

    public boolean isDead() {
        return this.life <= 0;
    }

    public int getLife() {
        return this.life;
    }

    public String getName() {
        return this.name;
    }
}
