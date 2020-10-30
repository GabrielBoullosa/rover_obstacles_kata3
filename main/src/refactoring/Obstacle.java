package refactoring;

public class Obstacle {
    private Dimensions dimensions;

    public Obstacle(int x, int y) {
        dimensions = new Dimensions(x, y);
    }

    public int dimensionX() {
        return dimensions.x_length();
    }

    public int dimensionY() {
        return dimensions.y_length();
    }

    public String dimensions() {
        return null;
    }

    public static class Dimensions {
        private int x_length;
        private int y_length;

        public Dimensions(int x_length, int y_length) {
            this.x_length = x_length;
            this.y_length = y_length;
        }

        public int x_length() {
            return x_length;
        }

        public int y_length() {
            return y_length;
        }
    }
}
