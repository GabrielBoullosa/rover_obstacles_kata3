package com.codemanship.marsrover;

import org.junit.Test;
import refactoring.Obstacle;
import refactoring.Rover;

import static org.assertj.core.api.Assertions.assertThat;
import static refactoring.Rover.Heading.North;
import static refactoring.Rover.Order.Forward;

public class ObstacleRover_ {

    @Test
    public void could_create_obstacles_and_rover() {
        assertThat(new Obstacle(2, 2, 1, 1).dimensions()).isEqualTo(new Obstacle.Dimensions(2, 2).toString());
        assertThat(new Obstacle(2, 2, 1, 1).position()).isEqualTo(new Obstacle.Position(1, 1).toString());
        assertThat(new Obstacle(2, 2, 1, 1).finalPosition().toString()).isEqualTo(new Obstacle.Position(2, 2).toString());
        assertThat(new Rover("N", 5, 5).heading()).isEqualTo(North);
        assertThat(new Rover("North", 5, 5).heading()).isEqualTo(North);
        assertThat(new Rover("North", 5, 5).position()).isEqualTo(new Rover.Position(5,5));
    }

    @Test
    public void could_add_obstacles_to_rover_obstacle_list() {
        Obstacle obstacle1 = new Obstacle(2, 2, 1, 1);
        Obstacle obstacle2 = new Obstacle(1, 2, 3, 2);
        Rover rover = new Rover("N", 5, 5);
        rover.obstacleAdd(obstacle1);
        rover.obstacleAdd(obstacle2);
        assertThat(rover.Obstacle(0)).isEqualTo(obstacle1);
        assertThat(rover.Obstacle(1)).isEqualTo(obstacle2);
    }

    @Test
    public void could_not_the_rover_move_if_forward_have_an_obstacle() {
        Obstacle obstacle1 = new Obstacle(1, 1, 1, 2); // (1, 2) -> (1, 2)
        Obstacle obstacle2 = new Obstacle(2, 3, -2, -3); // (-1, -2) -> (0, 0)
        Rover rover = new Rover("N", 1, 1);
        rover.obstacleAdd(obstacle1);
        rover.obstacleAdd(obstacle2);
        rover.go(Forward);
        assertThat(rover.position()).isEqualTo(new Rover.Position(1, 1));
        rover.go("BLF");
        assertThat(rover.position()).isEqualTo(new Rover.Position(0, 1));
    }

}
