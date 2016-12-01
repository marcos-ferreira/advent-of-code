package pt.aoc2016.day1;

import java.awt.*;

/**
 * Created by Marcos on 01/12/2016.
 */
public class Location {

    private Point currentPosition;
    private Direction currentDirection;

    public Location(Point currentPosition, Direction currentDirection) {
        this.currentPosition = currentPosition;
        this.currentDirection = currentDirection;
    }

    public Point getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Point currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }
}
