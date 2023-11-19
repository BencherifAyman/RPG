//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package rpg;

public class MapAction {
    private int currX;
    private int currY;

    public MapAction(Player player) {
        this.currX = 800;
        this.currY = 0;
    }

    public MapAction(Monster currMonster) {
        this.currX = (int)(Math.random() * 3.0 + 1) * 100; // Position initiale fixe pour les ennemis
        this.currY = (int)(Math.random() * 3.0 + 1) * 100;
    }

    public MapAction(Obstacle currObstacle) {
        this.currX = (int)(Math.random() * 3.0 + 1) * 100; // Position initiale fixe pour les obstacles
        this.currY = (int)(Math.random() * 3.0 + 1) * 100;
    }


    public void changePosition(String direction) {
        int newX = this.currX;
        int newY = this.currY;

        if (direction.equals("up") && this.currX > 0) {
            newX -= 100;
        } else if (direction.equals("down") && this.currX < 700) { // Limite de déplacement vers le bas
            newX += 100;
        } else if (direction.equals("left") && this.currY > 0) {
            newY -= 100;
        } else if (direction.equals("right") && this.currY < 700) { // Limite de déplacement vers la droite
            newY += 100;
        }

        // Vérifier si la nouvelle position est la sortie
        if (!MapAction.isExit(newX, newY)) {
            this.currX = newX;
            this.currY = newY;
        }
    }


    public static void randomEnemyPosition() {
        for(int i = 0; i < Map.enemies.size(); ++i) {
            ((MapAction)Map.enemiesPos.get(i)).currX = (int)(Math.random() * 8.0) * 100;
            ((MapAction)Map.enemiesPos.get(i)).currY = (int)(Math.random() * 8.0) * 100;
        }


    }
    public static boolean isExit(int x, int y) {
        return x == 800 && y == 700; // Coordonnées de la sortie
    }

    public int getX() {
        return this.currX;
    }

    public int getY() {
        return this.currY;
    }
}
