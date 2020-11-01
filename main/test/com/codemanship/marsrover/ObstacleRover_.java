package com.codemanship.marsrover;

import org.junit.Test;
import refactoring.Obstacle;
import refactoring.Rover;

import static org.assertj.core.api.Assertions.assertThat;
import static refactoring.Rover.Heading.North;

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

}
