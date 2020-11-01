package com.codemanship.marsrover;

import org.junit.Test;
import refactoring.Obstacle;

import static org.assertj.core.api.Assertions.assertThat;

public class Obstacle_ {
    @Test
    public void could_create_obstacles_with_an_dimension() {
        Obstacle obstacle = new refactoring.Obstacle(3, 1, new Obstacle.Position(0,0));
        assertThat(obstacle.dimensionX()).isEqualTo(3);
        assertThat(obstacle.dimensionY()).isEqualTo(1);
        assertThat(obstacle.dimensions()).isEqualTo(new Obstacle.Dimensions(3, 1).toString());
        assertThat(new Obstacle(5, 2, 3, 3).dimensions()).isEqualTo(new Obstacle.Dimensions(5, 2).toString());
    }

    @Test
    public void could_create_obstacles_with_an_position() {
        assertThat(new Obstacle(3, 1, new Obstacle.Position(0,0)).position()).isEqualTo(new Obstacle.Position(0, 0).toString());
        assertThat(new Obstacle(5, 2, 3, 3).position()).isEqualTo(new Obstacle.Position(3, 3).toString());
        assertThat(new Obstacle(new Obstacle.Dimensions(1, 1), 1, 2).position()).isEqualTo(new Obstacle.Position(1, 2).toString());
    }
    @Test
    public void could_have_obstacle_positions_with_his_dimension_associated() {
        assertThat(new Obstacle(3, 1, new Obstacle.Position(0,0)).position()).isEqualTo(new Obstacle.Position(0, 0).toString());
        assertThat(new Obstacle(3, 1, new Obstacle.Position(0,0)).finalPosition().toString()).isEqualTo(new Obstacle.Position(2, 0).toString());
    }
}
