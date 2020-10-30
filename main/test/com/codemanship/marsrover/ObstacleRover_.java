package com.codemanship.marsrover;

import org.junit.Test;
import refactoring.Obstacle;
//import refactoring.Rover;

import static org.assertj.core.api.Assertions.assertThat;

public class ObstacleRover_ {
    @Test
    public void could_create_obstacles_with_an_dimension() {
        Obstacle obstacle = new refactoring.Obstacle(3, 1);
        assertThat(obstacle.dimensionX()).isEqualTo(3);
        assertThat(obstacle.dimensionY()).isEqualTo(1);
        assertThat(obstacle.dimensions()).isEqualTo(new Obstacle.Dimensions(3, 1).toString());

    }
}
