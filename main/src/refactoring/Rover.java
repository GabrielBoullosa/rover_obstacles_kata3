package refactoring;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Rover {

	private Heading heading;
	private Position position;
	private ArrayList<Obstacle> obstacles;

	public Rover(String facing, int x, int y) {
		heading = Heading.of(facing);
		position = new Position(x,y);
		obstacles = new ArrayList<>();
	}

	public Rover(Heading heading, int x, int y) {
		this.heading = heading;
		position = new Position(x,y);
		obstacles = new ArrayList<>();
	}

	public Rover(Heading heading, Position position) {
		this.heading = heading;
		this.position = position;
		obstacles = new ArrayList<>();
	}

	public Heading heading() {
		return heading;
	}

	public Position position() {
		return position;
	}

	public void obstacleAdd(Obstacle obstacle) { obstacles.add(obstacle); }

	public Obstacle Obstacle(int index) { return obstacles.get(index); }

	public boolean nextIsObstacle(Order order){
		for (Obstacle o : obstacles)
			if (order == Order.Forward && forwardObstacle(o)) return true;
			else if (order == Order.Backward && backwardObstacle(o)) return true;
			else if(order == Order.Left || order == Order.Right) break;
		return false;
	}

	public boolean forwardObstacle(Obstacle o) {
		if (heading == Heading.North && posInObstacleRange(o, 0, 1)) return true;
		else if (heading == Heading.South && posInObstacleRange(o, 0, -1)) return true;
		else if (heading == Heading.East && posInObstacleRange(o, 1, 0)) return true;
		else if (heading == Heading.West && posInObstacleRange(o, -1, 0)) return true;
		return false;
	}

	public boolean backwardObstacle(Obstacle o) {
		if (heading == Heading.South && posInObstacleRange(o, 0, 1)) return true;
		else if (heading == Heading.North && posInObstacleRange(o, 0, -1)) return true;
		else if (heading == Heading.West && posInObstacleRange(o, 1, 0)) return true;
		else if (heading == Heading.East && posInObstacleRange(o, -1, 0)) return true;
		return false;
	}

	public boolean posInObstacleRange(Obstacle o, int xSum, int ySum){
		if(o.positionY() <= (position.y + ySum) && (position.y + ySum) <= o.finalPositionY()
		   && o.positionX() <= (position.x + xSum) && (position.x + xSum) <= o.finalPositionX())
			return true;
		return false;
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
		orders.forEach(order -> { if(!nextIsObstacle(order)) actions.get(order).execute(); });
	}

	public void go(Order... orders){
		for (Order order: orders){
			if(!nextIsObstacle(order))
				execute(order);
		}
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
			return forward(opposite(heading));
		}

		public Heading opposite(Heading heading) {
			return heading.turnLeft().turnLeft();
		}

		@Override
		public String toString() {
			return "Position: " +
					"x=" + x +
					", y=" + y ;
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

