import javax.swing.*;
import javax.vecmath.Vector2d;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        List<Obstacle> boundary = new ArrayList<>();
        boundary.add(new Obstacle(new Vector2d(0,0), new Vector2d(1440,0)));
        boundary.add(new Obstacle(new Vector2d(0,0), new Vector2d(0,770)));
        boundary.add(new Obstacle(new Vector2d(1440,0), new Vector2d(1440,770)));
        boundary.add(new Obstacle(new Vector2d(0,770), new Vector2d(1440,770)));

        List<Obstacle> obstacles = new ArrayList<>();
        Particle particle = new Particle(new Vector2d(60,60), new ArrayList<>(), boundary);
        //Ray ray = new Ray(new Vector2d(100, 200), new Vector2d(1, 0));
        Panel panel = new Panel(new ArrayList<>(), new ObstacleInitializer(obstacles), particle);
        jFrame.add(panel);
        jFrame.setTitle("POV");
        jFrame.addMouseListener(new ObstacleCreator(obstacles, panel));
        jFrame.addMouseMotionListener(new MousePointerListener(particle, panel, obstacles));
        //jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //jFrame.setSize(1440, 750);
        jFrame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        jFrame.setResizable(false);
        jFrame.setVisible(true);
    }
}
