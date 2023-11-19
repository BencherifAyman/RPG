package rpg;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class MapDrawing extends JPanel {
    public MapDrawing() {
        this.setBackground(Color.LIGHT_GRAY);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dessiner les ennemis (Monstres et Obstacles)
        for (int i = 0; i < Map.enemies.size(); ++i) {
            // Dessiner les monstres en vert
            if (Map.enemies.get(i) instanceof Monster) {
                g.setColor(Color.GREEN);
                g.fillRect(((MapAction) Map.enemiesPos.get(i)).getY(), ((MapAction) Map.enemiesPos.get(i)).getX(), 10, 10);
            }
            // Dessiner les obstacles en noir
            else if (Map.enemies.get(i) instanceof Obstacle) {
                g.setColor(Color.BLACK);
                g.fillRect(((MapAction) Map.enemiesPos.get(i)).getY(), ((MapAction) Map.enemiesPos.get(i)).getX(), 10, 10);
            }
        }


        // Dessiner les obstacles en noir
        for (int i = 0; i < Map.obstacles.size(); ++i) {
            g.setColor(Color.BLACK);
            g.fillRect(((MapAction) Map.obstaclesPos.get(i)).getY(), ((MapAction) Map.obstaclesPos.get(i)).getX(), 10, 10);
        }


        // Dessiner le joueur en bleu
        g.setColor(Color.BLUE);
        g.fillRect(Map.playerPos.getY(), Map.playerPos.getX(), 10, 10);
    }
}
