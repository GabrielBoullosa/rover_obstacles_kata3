package refactoring;

public class Obstacle {
    private Dimensions dimensions;
    private Position position;

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
        return dimensions.toString();
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

        @Override
        public String toString() {
            return "El obstaculo tiene una dimensión de " + x_length
                    + "x" + y_length;
        }
    }

    public static class Position {
        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object object) {
            return isSameClass(object) && equals((Obstacle.Position) object);
        }

        private boolean equals(Obstacle.Position position) {
            return position == this || (x == position.x && y == position.y);
        }

        private boolean isSameClass(Object object) {
            return object != null && object.getClass() == Rover.Position.class;
        }

    }
}
