import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.List;

public class MousePointerListener implements /*MouseListener*/MouseMotionListener {
    private final Particle particle;
    private final Panel panel;
    private final List<Obstacle> obstacles;

    public MousePointerListener(Particle particle, Panel panel, List<Obstacle> obstacles) {
        this.particle = particle;
        this.panel = panel;
        this.obstacles = obstacles;
    }


/*    @Override
    public void mouseClicked(MouseEvent e) {
        //particle.setOrigin(new Vector2d(e.getX(), e.getY()));
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

    }*/

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //particle.setOrigin(new Vector2d(e.getXOnScreen(), e.getYOnScreen()));
        if (obstacles.size() > 10) {
            panel.repaint();
        }
    }
}
