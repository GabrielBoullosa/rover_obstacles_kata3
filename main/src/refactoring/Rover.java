package refactoring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public class Rover {

	private Heading heading;
	private Position position;

	public Rover(String facing, int x, int y) {
		heading = Heading.of(facing);
		position = new Position(x,y);
	}

	public Rover(Heading heading, int x, int y) {
		this.heading = heading;
		position = new Position(x,y);
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


	public enum Order {
		Forward, Backward, Left, Right;

		public static Order of(String label) {
			return of(label.charAt(0));
		}

		public static Order of(char label) {
			if (label == 'F') return Forward;
			if (label == 'B') return Backward;
			if (label == 'L') return Left;
			if (label == 'R') return Right;
			return null;
		}
	}

	Map<Order, Action> actions = new HashMap<>();
	{
		actions.put(Order.Forward, () -> position = position.forward(heading));
		actions.put(Order.Backward, () -> position = position.backward(heading));
		actions.put(Order.Left, () -> heading = heading.turnLeft());
		actions.put(Order.Right, () -> heading = heading.turnRight());
	}

	@FunctionalInterface
	public interface Action {
		void execute();
	}

	public void go(String instructions){
		Stream<Order> orders = Arrays.stream(instructions.split("")).map(Order::of).filter(Objects::nonNull);
		orders.forEach(order -> actions.get(order).execute());
	}

	public void go(Order... orders){
		for (Order order: orders) execute(order);
	}

	private void execute(Order order) {
		actions.get(order).execute();
	}

	public static class Position {
		private int x;
		private int y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
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

