import javax.vecmath.Vector2d;
import java.awt.*;

public class Obstacle {
    private final Vector2d startPoint;
    private final Vector2d endPoint;

    public Obstacle(Vector2d startPoint, Vector2d endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Vector2d getEndPoint() {
        return endPoint;
    }

    public Vector2d getStartPoint() {
        return startPoint;
    }

    public void show(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.drawLine((int)this.startPoint.x, (int)this.startPoint.y, (int)this.endPoint.x, (int)this.endPoint.y);
    }
}
