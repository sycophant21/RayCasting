public class Coordinates {
    private final double x;
    private final double y;
    private final boolean exists;

    public Coordinates(double x, double y, boolean exists) {
        this.x = x;
        this.y = y;
        this.exists = exists;
    }

    public boolean exists() {
        return exists;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
