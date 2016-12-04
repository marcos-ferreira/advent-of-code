package pt.aoc2016.day2;

/**
 * Created by Marcos on 04/12/2016.
 */
public enum Direction {
    UP,DOWN,LEFT,RIGHT;

    public static Direction value(char value){
        if(value == 'R'){
            return Direction.RIGHT;
        }

        if(value == 'L'){
            return Direction.LEFT;
        }

        if(value == 'U'){
            return Direction.UP;
        }

        if(value == 'D'){
            return Direction.DOWN;
        }

        throw new IllegalArgumentException("Invalid direction value " + value);
    }
}
