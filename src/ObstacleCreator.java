import javax.vecmath.Vector2d;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class ObstacleCreator implements MouseListener {
    private final List<Obstacle> obstacles;
    private final Panel panel;
    private boolean isFirst = true;
    private int xCoordinate = 0;
    private int yCoordinate = 0;

    public ObstacleCreator(List<Obstacle> obstacles, Panel panel) {
        this.obstacles = obstacles;
        this.panel = panel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (isFirst) {
            xCoordinate = e.getX();
            yCoordinate = e.getY() - 30;
            isFirst = false;
        }
        else {
            obstacles.add(new Obstacle(new Vector2d(xCoordinate, yCoordinate), new Vector2d(e.getX(), e.getY() - 30)));
            isFirst = true;
        }
        panel.repaint();

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
