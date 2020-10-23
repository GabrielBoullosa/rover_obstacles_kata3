package com.codemanship.marsrover;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertArrayEquals;

public class Rover_ {

    @Test
    public void turnRightNtoE(){
        Rover rover = new Rover("N", 5, 5);
        rover.go("R");
        assertThat(rover.getFacing()).isEqualTo("E");
        assertThat(rover.getPosition()[0]).isEqualTo(5);
        assertThat(rover.getPosition()[1]).isEqualTo(5);
    }

    @Test
    public void turnRightEtoS(){
        Rover rover = new Rover("E", 5, 5);
        rover.go("R");
        assertThat(rover.getFacing()).isEqualTo("S");
    }

    @Test
    public void turnRightStoW(){
        Rover rover = new Rover("S", 5, 5);
        rover.go("R");
        assertThat(rover.getFacing()).isEqualTo("W");
    }

    @Test
    public void turnRightWtoN(){
        Rover rover = new Rover("W", 5, 5);
        rover.go("R");
        assertThat(rover.getFacing()).isEqualTo("N");
    }

    @Test
    public void turnLeftNtoW(){
        Rover rover = new Rover("N", 5, 5);
        rover.go("L");
        assertThat(rover.getFacing()).isEqualTo("W");
    }

    @Test
    public void turnLeftWtoS(){
        Rover rover = new Rover("W", 5, 5);
        rover.go("L");
        assertThat(rover.getFacing()).isEqualTo("S");
    }

    @Test
    public void turnLeftStoE(){
        Rover rover = new Rover("S", 5, 5);
        rover.go("L");
        assertThat(rover.getFacing()).isEqualTo("E");
    }

    @Test
    public void turnLeftEtoN(){
        Rover rover = new Rover("E", 5, 5);
        rover.go("L");
        assertThat(rover.getFacing()).isEqualTo("N");
    }

    @Test
    public void moveFowardFacingN(){
        Rover rover = new Rover("N", 5, 5);
        rover.go("F");
        assertArrayEquals(new int[]{5, 6}, rover.getPosition());
    }

    @Test
    public void moveFowardFacingE(){
        Rover rover = new Rover("E", 5, 5);
        rover.go("F");
        assertArrayEquals(new int[]{6, 5}, rover.getPosition());
    }

    @Test
    public void moveFowardFacingS(){
        Rover rover = new Rover("S", 5, 5);
        rover.go("F");
        assertArrayEquals(new int[]{5, 4}, rover.getPosition());
    }

    @Test
    public void moveFowardFacingW(){
        Rover rover = new Rover("W", 5, 5);
        rover.go("F");
        assertArrayEquals(new int[]{4, 5}, rover.getPosition());
    }

    @Test
    public void moveBackFacingN(){
        Rover rover = new Rover("N", 5, 5);
        rover.go("B");
        assertArrayEquals(new int[]{5, 4}, rover.getPosition());
    }

    @Test
    public void moveBackFacingE(){
        Rover rover = new Rover("E", 5, 5);
        rover.go("B");
        assertArrayEquals(new int[]{4, 5}, rover.getPosition());
    }

    @Test
    public void moveBackFacingS(){
        Rover rover = new Rover("S", 5, 5);
        rover.go("B");
        assertArrayEquals(new int[]{5, 6}, rover.getPosition());
    }

    @Test
    public void moveBackFacingW(){
        Rover rover = new Rover("W", 5, 5);
        rover.go("B");
        assertArrayEquals(new int[]{6, 5}, rover.getPosition());
    }

    @Test
    public void executesSequenceOfInstructions(){
        Rover rover = new Rover("N", 5, 5);
        rover.go("RFF");
        assertThat(rover.getFacing()).isEqualTo("E");
        assertArrayEquals(new int[]{7, 5}, rover.getPosition());
    }
}
