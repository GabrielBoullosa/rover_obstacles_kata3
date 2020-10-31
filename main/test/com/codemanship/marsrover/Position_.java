package com.codemanship.marsrover;

import org.junit.Test;
import refactoring.Rover.Position;

import static org.assertj.core.api.Assertions.assertThat;
import static refactoring.Rover.Heading.*;

public class Position_ {

    @Test
    public void should_calculate_forward_position() {
        assertThat(new Position(0,0).forward(North).forward(West).forward(South)).isEqualTo(new Position(-1,0));
        assertThat(new Position(0,0).forward(East).forward(South)).isEqualTo(new Position(1,-1));
    }

    @Test
    public void should_calculate_backward_position() {
        assertThat(new Position(0,0).backward(North).backward(West).backward(South)).isEqualTo(new Position(1,0));
        assertThat(new Position(0,0).backward(East).backward(South)).isEqualTo(new Position(-1,1));
    }

    @Test
    public void should_calculate_forward_and_backward_position() {
        assertThat(new Position(0,0).backward(North).forward(West).forward(South)).isEqualTo(new Position(-1,-2));
        assertThat(new Position(0,0).forward(East).backward(South)).isEqualTo(new Position(1,1));
    }

}
