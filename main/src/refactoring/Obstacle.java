package refactoring;

public class Obstacle {
    private Dimensions dimensions;

    public Obstacle(int x, int y) {
        dimensions = new Dimensions(x, y);
    }

    public int dimensionX() {
        return 0;
    }

    public int dimensionY() {
        return 0;
    }

    public static class Dimensions {
        private int x_length;
        private int y_length;

        public Dimensions(int x_length, int y_length) {
            this.x_length = x_length;
            this.y_length = y_length;
        }

    }
}
