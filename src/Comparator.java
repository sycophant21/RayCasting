public class Comparator implements java.util.Comparator<Ray> {
    @Override
    public int compare(Ray o1, Ray o2) {
        return (int)(o2.getMaxDistance() - o1.getMaxDistance());
    }
}
