package rpg;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JFrame;

public class Map extends JFrame implements KeyListener {
    private static int width = 900;
    private static int height = 900;
    private static int nbEnemies = 16;
    public static ArrayList<Destructible> enemies = new ArrayList<>();
    public static ArrayList<MapAction> enemiesPos = new ArrayList<>();
    public static ArrayList<Destructible> obstacles = new ArrayList<>();
    public static ArrayList<MapAction> obstaclesPos = new ArrayList<>();
    public static MapDrawing mapDrawing = new MapDrawing();
    public static MapAction playerPos;

    static {
        playerPos = new MapAction(GameLogic.player);
    }


    public Map() {
        this.setTitle("Map");
        this.setSize(width, height);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(this);

        for (int i = 0; i < nbEnemies / 2; ++i) {
            Monster currMonster = new Monster();
            enemies.add(currMonster);
            enemiesPos.add(new MapAction(currMonster));

            Obstacle currObstacle = new Obstacle();
            obstacles.add(currObstacle);
            obstaclesPos.add(new MapAction(currObstacle));
        }

        this.add(mapDrawing);
    }

    public void showMap() {
        this.setVisible(true);
    }

    public void keyPressed(KeyEvent e) {
        MapAction.randomEnemyPosition();

        if (!this.checkIfEnemy()) {
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_LEFT && playerPos.getY() > 0) {
                playerPos.changePosition("left");
            } else if (keyCode == KeyEvent.VK_UP && playerPos.getX() > 0) {
                playerPos.changePosition("up");
            } else if (keyCode == KeyEvent.VK_RIGHT && playerPos.getY() < 800) {
                playerPos.changePosition("right");
            } else if (keyCode == KeyEvent.VK_DOWN && playerPos.getX() < 800) {
                playerPos.changePosition("down");
            }

            this.checkIfWin();
            mapDrawing.repaint();

            try {
                this.checkIfBattle();
            } catch (InterruptedException var4) {
                var4.printStackTrace();
            }
        }
    }

    public void checkIfWin() {
        if (playerPos.getX() == 0 && playerPos.getY() == 800) {
            this.removeKeyListener(this);

            // Combat contre le boss
            Boss boss = new Boss();
            GameLogic.printHeading("You reached the boss! Get ready for the final battle!");
            BattleHandler bossBattle = new BattleHandler(boss);
            bossBattle.start();
            bossBattle.checkResult();

            if (!boss.isDead()) {
                GameLogic.printHeading("The boss defeated you. Game Over!");
            } else {
                GameLogic.printHeading("Congratulations! You have defeated the boss of the world!");
            }

            System.exit(0);
        }
    }

    public void checkIfBattle() throws InterruptedException {
        for (int i = 0; i < enemies.size(); ++i) {
            if (enemiesPos.get(i).getX() == playerPos.getY() && enemiesPos.get(i).getY() == playerPos.getY()) {
                this.removeKeyListener(this);
                Destructible currEnemy = enemies.get(i);
                System.out.println("You met a(n) " + currEnemy.getName() + " !");
                boolean exit = false;
                System.out.println("(1) => fight");
                System.out.println("(2) => flee");
                int input = GameLogic.readInt("->", 2);
                if (input == 2) {
                    exit = true;
                    GameLogic.printHeading("You escaped! , you do not earn Honor!");
                    GameLogic.printHeading("You can now move on the map");
                    this.addKeyListener(this);
                } else {
                    GameLogic.printHeading("The fight is in progress..");
                    Thread.sleep(3000L);
                    BattleHandler battle = new BattleHandler(currEnemy);
                    battle.start();
                    battle.checkResult();
                    if (currEnemy.isDead()) {
                        this.addKeyListener(this);
                    }
                }
            }
        }
    }

    private boolean checkIfEnemy() {
        for (int i = 0; i < enemies.size(); ++i) {
            if (enemiesPos.get(i).getX() == playerPos.getX() && enemiesPos.get(i).getY() == playerPos.getY()) {
                return true;
            }
        }
        return false;
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }
}
