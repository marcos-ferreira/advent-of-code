package pt.aoc2016.day2;

import pt.aoc2016.util.Processor;

import java.awt.*;

/**
 * Created by Marcos on 04/12/2016.
 */
public class AdventOfCodeDay2 extends Processor{

    private int[][] numPad = new int[][]{{123},{4,5,6},{7,8,9}};

    private int MAX_X = 2;
    private int MIN_X = 0;

    private int MAX_Y = 2;
    private int MIN_Y = 0;

    private Point currentPoint = new Point(1,1);


    public static void main(String[] args){

    }

    @Override
    public void processLine(String line) {
        for (int i = 0 ; i < line.length() ; i++){
            Direction direction = Direction.value(line.charAt(i));
            processPadMovement(direction);
        }
    }

    private void processPadMovement(Direction direction) {
        switch (direction){
            case LEFT:
                break;
            case RIGHT:
                break;
            case DOWN:
                break;
            case UP:
                break;
        }
    }

    @Override
    public String getFileResourceName() {
        return "/input-day-2.txt";
    }
}
