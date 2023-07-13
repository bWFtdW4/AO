import java.util.HashMap;
import java.util.Map;

public class CoordinateManager {

    private Map<Integer, Coordinate> coordinates;

    public CoordinateManager() {
        coordinates = new HashMap<>();
    }

    public void addCoordinate(int id, int coordinateX, int coordinateY) {
        coordinates.put(id, new Coordinate(coordinateX, coordinateY));
    }

    public void removeCoordinate(int id) {
        coordinates.remove(id);
    }

    public Coordinate getCoordinate(int id) {
        return coordinates.get(id);
    }

    public void hasCoordinate(int id) {
        coordinates.containsKey(id);
    }

    public static class Coordinate {
        private int coordinateX;
        private int coordinateY;

        public Coordinate(int coordinateX, int coordinateY) {
            this.coordinateX = coordinateX;
            this.coordinateY = coordinateY;
        }

        public int getCoordinateX() {
            return coordinateX;
        }

        public int getCoordinateY() {
            return coordinateY;
        }

        public void setCoordinateX(int coordinateX) {
            this.coordinateX = coordinateX;
        }

        public void setCoordinateY(int coordinateY) {
            this.coordinateY = coordinateY;
        }
    }

}
