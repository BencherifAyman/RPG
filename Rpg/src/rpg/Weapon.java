//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package rpg;

public abstract class Weapon {
    protected String name;
    protected double damage;
    private double monsterDamageMultiplicator;
    private double obstacleDamageMultiplicator;

    public Weapon(String name, double damage, double monsterDamageMultiplicator, double obstacleDamageMultiplicator) {
        this.name = name;
        this.damage = damage;
        this.monsterDamageMultiplicator = monsterDamageMultiplicator;
        this.obstacleDamageMultiplicator = obstacleDamageMultiplicator;
    }

    public String getName() {
        return this.name;
    }

    protected abstract String Ascii_art();

    public String getAscii() {
        return this.Ascii_art();
    }

    public void attackEnemy(Destructible enemy) {
        if (enemy instanceof Monster) {
            enemy.hit_me((double)enemy.damage * this.monsterDamageMultiplicator);
        } else if (enemy instanceof Obstacle) {
            enemy.hit_me((double)enemy.damage * this.obstacleDamageMultiplicator);
        }

    }
}
