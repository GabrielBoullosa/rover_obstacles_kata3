package refactoring;

import java.util.HashMap;
import java.util.Map;

public class Rover {

	private Heading heading;
	private Position position;

	public Rover(String facing, int x, int y) {
	}

	public Rover(Heading heading, int x, int y) {
	}

	public Rover(Heading heading, Position position) {
		this.heading = heading;
		this.position = position;
	}

	public Heading heading() {
		return heading;
	}

	public Position position() {
		return position;
	}

	public static class Position {
		private int x;
		private int y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public enum Order {
			Forward, Backward, Left, Right;
		}

		Map<Order, Action> actions = new HashMap<>();

		public interface Action {
			void execute();
		}

		public void go(String instructions){

		}

		public void go(Order... orders){

		}

		public Position forward(Heading heading) {
			if(heading == Heading.North) y++;
			if(heading == Heading.South) y--;
			if(heading == Heading.East) x++;
			if(heading == Heading.West) x--;
			return this;
		}

		public Position backward(Heading heading) {
			return forward(oposite(heading));
		}

			public Heading oposite(Heading heading) {
				return heading.turnLeft().turnLeft();
			}

		@Override
		public boolean equals(Object object) {
			return isSameClass(object) && equals((Position) object);
		}

		private boolean equals(Position position) {
			return position == this || (x == position.x && y == position.y);
		}

		private boolean isSameClass(Object object) {
			return object != null && object.getClass() == Position.class;
		}

	}


	public enum Heading {
		North, East, South, West;

		public static Heading of(String label) {
			return of(label.charAt(0));
		}

		public static Heading of(char label) {
			if (label == 'N') return North;
			if (label == 'S') return South;
			if (label == 'W') return West;
			if (label == 'E') return East;
			return null;
		}

		public Heading turnRight() {
			return values()[add(+1)];
		}

		public Heading turnLeft() {
			return values()[add(-1)];
		}

		private int add(int offset) {
			return (this.ordinal() + offset + values().length) % values().length;
		}

	}


}

