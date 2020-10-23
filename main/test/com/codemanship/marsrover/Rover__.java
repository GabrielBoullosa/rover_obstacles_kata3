package com.codemanship.marsrover;

import org.junit.Test;
import refactoring.Rover;

import static org.assertj.core.api.Assertions.assertThat;
import static refactoring.Rover.Heading.North;
import static refactoring.Rover.Heading.*;
import static refactoring.Rover.Position.Order.*;

public class Rover__ {
    @Test
    public void could_turn_left() {
        Rover rover = new Rover(North, new Rover.Position(3, 3));
        //rover.go(Left);
        assertThat(rover.heading()).isEqualTo(West);
        assertThat(rover.position()).isEqualTo(new Rover.Position(3,3));
    }

    @Test
    public void could_turn_right() {
        Rover rover = new Rover(East, new Rover.Position(5, 1));
        //rover.go(Right);
        assertThat(rover.heading()).isEqualTo(South);
        assertThat(rover.position()).isEqualTo(new Rover.Position(5,1));
    }

    @Test
    public void could_go_forward() {
        Rover rover = new Rover(South, new Rover.Position(-1, 1));
        //rover.go(Forward);
        assertThat(rover.heading()).isEqualTo(South);
        assertThat(rover.position()).isEqualTo(new Rover.Position(-1,0));
    }

    @Test
    public void could_go_backward() {
        Rover rover = new Rover(West, new Rover.Position(-4, 4));
        //rover.go(Backward);
        assertThat(rover.heading()).isEqualTo(West);
        assertThat(rover.position()).isEqualTo(new Rover.Position(-3,4));
    }
}
