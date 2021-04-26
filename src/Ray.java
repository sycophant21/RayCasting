import javax.vecmath.Vector2d;
import java.awt.*;
import java.util.Objects;

public class Ray {
    private Vector2d vectorToShow;
    private Vector2d direction;
    private double maxDistance;
    private final double angle;

    public Ray(Vector2d vectorToShow, Vector2d direction, double angle) {
        this.direction = direction;
        this.vectorToShow = vectorToShow;
        this.angle = angle;
    }

    public double getAngle() {
        return angle;
    }

    public void setMaxDistance(double maxDistance) {
        this.maxDistance = maxDistance;
    }

    public double getMaxDistance() {
        return maxDistance;
    }

    public Vector2d getDirection() {
        return direction;
    }

    public void setDirection(Vector2d direction) {
        this.direction = direction;
        this.direction.normalize();
        //this.direction.scale(3);
    }

    public Vector2d getVectorToShow() {
        return vectorToShow;
    }

    public void setVectorToShow(Vector2d vectorToShow) {
        this.vectorToShow = vectorToShow;
    }

    public void show(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.translate((int) this.vectorToShow.x, (int) this.vectorToShow.y);
        graphics.drawLine(0, 0, (int)(this.direction.x), (int)(this.direction.y));
        graphics.translate(-(int) this.vectorToShow.x, -(int) this.vectorToShow.y);
    }

    public Coordinates isIntersecting(Obstacle obstacle) {
        double x1 = obstacle.getStartPoint().x;
        double y1 = obstacle.getStartPoint().y;
        double x2 = obstacle.getEndPoint().x;
        double y2 = obstacle.getEndPoint().y;

        double x3 = this.vectorToShow.x;
        double y3 = this.vectorToShow.y;
        double x4 = this.vectorToShow.x + this.direction.x;
        double y4 = this.vectorToShow.y + this.direction.y;

        double denominator = ((x1 - x2) * (y3 - y4)) - ((y1 - y2) * (x3 - x4));
        if (denominator == 0) {
            return new Coordinates(0, 0, false);
        }
        double t = (((x1 - x3) * (y3 - y4)) - ((y1 - y3) * (x3 - x4))) / denominator;
        double u = -(((x1 - x2) * (y1 - y3)) - ((y1 - y2) * (x1 - x3))) / denominator;
        if ((t > 0 && t < 1) && u > 0) {
            return new Coordinates(x1 + (t * (x2 - x1)), y1 + (t * (y2 - y1)), true);
        } else {
            return new Coordinates(0, 0, false);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ray)) return false;
        Ray ray = (Ray) o;
        return Double.compare(ray.getAngle(), getAngle()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAngle());
    }
}
