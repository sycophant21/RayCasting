import javax.vecmath.Vector2d;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

public class Particle {
    private final List<Ray> rays;
    private final List<Obstacle> boundary;
    private Vector2d origin;
    private Ray directionToMove;
    private Ray lastDirection;
    private double distanceFromEnd = -1;

    public Particle(Vector2d origin, List<Ray> rays, List<Obstacle> boundary) {
        this.origin = origin;
        this.rays = rays;
        this.boundary = boundary;
        initRays();
    }

    public void setOrigin(Vector2d origin) {
        this.origin.x = origin.x;
        this.origin.y = origin.y;
    }

    private void initRays() {
        for (int i = 0; i < 8; i++) {
            double angle = Math.toRadians(45 * i);
            rays.add(new Ray(origin, new Vector2d(Math.cos(angle), Math.sin(angle)), 45 * i));
        }
    }

    public void show(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        int size = 10;
        graphics.fillArc((int) (origin.x - (size / 2)), (int) (origin.y - (size / 2)), size, size, 0, 360);
        for (Ray ray : rays) {
            ray.show(graphics);
        }
    }

    public void drawLight(Graphics graphics, List<Obstacle> obstacles) {
        graphics.setColor(Color.WHITE);
        for (Ray ray : rays) {
            Coordinates closestCoordinates = new Coordinates(0, 0, false);
            double minDistance = Double.POSITIVE_INFINITY;
            //Obstacle obstacleToShow = null;
            for (Obstacle obstacle : obstacles) {
                obstacle.show(graphics);
                Coordinates coordinates = ray.isIntersecting(obstacle);
                if (coordinates.exists()) {
                    double currentDistance = distance(origin.x, origin.y, coordinates.getX(), coordinates.getY());
                    if (currentDistance < minDistance) {
                        minDistance = currentDistance;
                        closestCoordinates = coordinates;
                        ray.setMaxDistance(minDistance);
                        //obstacleToShow = obstacle;
                    }
                }
            }
/*            if (obstacleToShow != null) {
                obstacleToShow.show(graphics);
            }*/
            if (closestCoordinates.exists()) {
                Ellipse2D ellipse2D = new Ellipse2D.Double(closestCoordinates.getX() - 4, closestCoordinates.getY() - 4, 8, 8);
                graphics.fillArc((int) ellipse2D.getX(), (int) ellipse2D.getY(), (int) ellipse2D.getWidth(), (int) ellipse2D.getHeight(), 0, 360);
            } else {
                minDistance = Double.POSITIVE_INFINITY;
                for (Obstacle obstacle : boundary) {
                    Coordinates coordinates = ray.isIntersecting(obstacle);
                    if (coordinates.exists()) {
                        double distance = distance(origin.x, origin.y, coordinates.getX(), coordinates.getY());
                        if (distance < minDistance) {
                            minDistance = distance;
                            closestCoordinates = coordinates;
                            ray.setMaxDistance(minDistance);
                        }
                    }
                }
            }
            if (closestCoordinates.exists()) {
                graphics.setColor(Color.GREEN);
                graphics.drawLine((int) this.origin.x, (int) this.origin.y, (int) closestCoordinates.getX(), (int) closestCoordinates.getY());
            }
        }
        if (distanceFromEnd == -1) {
            move();
        } else {
            moveInDirection(getSlope());
            Ray ray = getNewDirection();
            if (distanceFromEnd > 25 && (ray.getAngle() != directionToMove.getAngle() + 180 || ray.getAngle() != directionToMove.getAngle() - 180)) {
/*                if (lastDirection != null && (ray.getAngle() != lastDirection.getAngle() + 180 || ray.getAngle() != lastDirection.getAngle() - 180) && ray != lastDirection) {
                    distanceFromEnd = directionToMove.getMaxDistance();
                }*/
                distanceFromEnd = directionToMove.getMaxDistance();
            } else {
                distanceFromEnd = -1;
                lastDirection = directionToMove;
                directionToMove = null;
                move();
            }
        }

    }

    private void move() {
        if (directionToMove == null) {
            findNewDirection();
            distanceFromEnd = directionToMove.getMaxDistance();
        }
        moveInDirection(getSlope());
    }

    private Coordinates getSlope() {
        double slope = directionToMove.getDirection().y / directionToMove.getDirection().x;
        double x;
        double y;
        if (directionToMove.getAngle() != 90 && directionToMove.getAngle() != 270) {
            if (directionToMove.getDirection().x < 0) {
                y = -slope;
                x = -1;
            } else if (directionToMove.getDirection().x > 0) {
                y = slope;
                x = 1;
            } else {
                y = slope;
                x = 0;
            }
        } else {
            if (directionToMove.getAngle() == 90) {
                y = 5;
            }
            else {
                y = -5;
            }
            x = 0;
        }
        return new Coordinates(x, y, true);
    }

    private void moveInDirection(Coordinates coordinates) {
        if (this.origin.y + coordinates.getY() < 770 && this.origin.x + coordinates.getX() < 1440) {
            this.origin.y += coordinates.getY();
            this.origin.x += coordinates.getX();
        }
    }


    private Ray getNewDirection() {
        List<Ray> rayList = new ArrayList<>(rays);
        rayList.sort(new Comparator());
        return rayList.get(0);
    }

    private void findNewDirection() {
        List<Ray> rayList = new ArrayList<>(rays);
        rayList.sort(new Comparator());
        directionToMove = rayList.get(0);
        if (lastDirection != null && (lastDirection.getAngle() == directionToMove.getAngle() + 180 || lastDirection.getAngle() == directionToMove.getAngle() - 180)) {
            directionToMove = rayList.get(1);
        } else if (lastDirection == null) {
            lastDirection = directionToMove;
        }
    }

    private double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

/*    private boolean isEqual(Ray ray , Ray ray1) {
        return  (
                (Math.ceil(ray.getMaxDistance()) == Math.ceil(ray1.getMaxDistance()))
                ||
                ((int)(ray.getMaxDistance()) == (int)(ray1.getMaxDistance()))
                ||
                (Math.ceil(ray.getMaxDistance()) == (int)(ray1.getMaxDistance()))
                ||
                ((int)(ray.getMaxDistance()) == Math.ceil(ray1.getMaxDistance()))
                );
    }

    private Ray getFirstNonEqual(List<Ray> rayList) {
        //double distance = rayList.get(0).getMaxDistance();
        for (Ray ray : rayList) {
            if (!isEqual(rayList.get(0),ray)) {
                return ray;
            }
        }
        return rayList.get(0);
    }*/
}
