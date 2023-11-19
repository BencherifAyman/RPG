package rpg;

public class Boss extends Destructible {
    public Boss() {
        super(900, "Boss", 100);
    }

    public void hit_me(double damage) {
        super.life = (int)((double)super.life - damage);
    }

    // Nouvelle méthode pour vérifier si le joueur est sur les coordonnées du boss
    public static boolean isPlayerOnBossPosition() {
        return Map.playerPos.getX() == 700 && Map.playerPos.getY() == 600;
    }

    // Nouvelle méthode pour gérer le combat contre le boss
    public static void startBossBattle() {
        BattleHandler bossBattle = new BattleHandler(new Boss());
        bossBattle.start();
        bossBattle.checkResult();
    }
}
