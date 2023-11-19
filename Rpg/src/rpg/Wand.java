//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package rpg;

public class Wand extends Weapon {
    private static final String name = "Wand";
    private static final double damage = 200.0;
    private static final double monsterDamageMultiplicator = 1.2;
    private static final double obstacleDamageMultiplicator = 1.5;

    public Wand() {
        super("Wand", 200.0, 1.2, 1.5);
    }

    public Wand(double damage) {
        super("Wand", damage, 1.2, 1.5);
    }

    protected String Ascii_art() {
        return "             *\r\n       *   *\r\n     *    \\* / *\r\n       * --.:. *\r\n      *   * :\\ -\r\n        .*  | \\\r\n       * *     \\\r\n     .  *       \\";
    }
}
