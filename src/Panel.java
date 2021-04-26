import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.List;

public class Panel extends JPanel {
    private final List<Ray> rays;
    private final ObstacleInitializer obstacleInitializer;
    private final Particle particle;

    public Panel(List<Ray> rays, ObstacleInitializer obstacleInitializer, Particle particle) {
        this.rays = rays;
        this.obstacleInitializer = obstacleInitializer;
        this.particle = particle;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        /*Graphics2D graphics2D = (Graphics2D) g;*/
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 1440, 770);
        particle.show(g);
/*        for (Obstacle obstacle : obstacleInitializer.getObstacles()) {
            obstacle.show(g);
        }*/
        particle.drawLight(g, obstacleInitializer.getObstacles());

    }
}
