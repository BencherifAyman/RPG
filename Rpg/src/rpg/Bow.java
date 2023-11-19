//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package rpg;

public class Bow extends Weapon {
    private static final String name = "Bow";
    private static final double damage = 200.0;
    private static final double monsterDamageMultiplicator = 1.2;
    private static final double obstacleDamageMultiplicator = 1.5;

    public Bow() {
        super("Bow", 200.0, 1.2, 1.5);
    }

    public Bow(double damage) {
        super("Bow", damage, 1.2, 1.5);
    }

    protected String Ascii_art() {
        return "   (\r\n    \\\r\n     )\r\n##-------->\n     )\r\n    /\r\n   (";
    }
}
