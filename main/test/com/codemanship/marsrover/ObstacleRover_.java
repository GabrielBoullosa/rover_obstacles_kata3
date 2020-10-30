package com.codemanship.marsrover;

import org.junit.Test;
import refactoring.Obstacle;
import refactoring.Rover;

import static org.assertj.core.api.Assertions.assertThat;
import static refactoring.Rover.Heading.West;

public class ObstacleRover_ {
    @Test
    public void could_create_obstacles() {
        Obstacle obstacle = new refactoring.Obstacle(3, 1);
        assertThat(obstacle.dimensionX()).isEqualTo(3);
        assertThat(obstacle.dimensionY()).isEqualTo(1);

    }
}
