    //
    // Source code recreated from a .class file by IntelliJ IDEA
    // (powered by FernFlower decompiler)
    //

    package rpg;

    public class Axe extends Weapon {
        private static final String name = "Axe";
        private static final double damage = 200.0;
        private static final double monsterDamageMultiplicator = 1.2;
        private static final double obstacleDamageMultiplicator = 1.5;

        public Axe() {
            super("Axe", 200.0, 1.2, 1.5);
        }

        public Axe(double damage) {
            super("Axe", damage, 1.2, 1.5);
        }

        public String Ascii_art() {
            return "  ,:\\      /:.\r\n //  \\_()_/  \\\\\r\n||   |    |   ||\r\n||   |    |   ||\r\n||   |____|   ||\r\n \\\\  / || \\  //\r\n  `:/  ||  \\;'\r\n       ||\r\n       ||\r\n       XX\r\n       XX\r\n       XX\r\n       XX\r\n       OO\r\n       `'";
        }
    }
