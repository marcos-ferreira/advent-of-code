package pt.aoc2016.day2;

import pt.aoc2016.util.AbstractAoc;

import java.awt.Point;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by Marcos on 04/12/2016.
 */
public class AdventOfCodeDay2 extends AbstractAoc {

    private static final int[][] numPad = new int[][]{{7,4,1},{8,5,2},{9,6,3}};

    private int MAX_X = 2;
    private int MIN_X = 0;

    private int MAX_Y = 2;
    private int MIN_Y = 0;

    private Point currentPoint = new Point(1,1);

    private List<Integer> pressedNumbers = new ArrayList<Integer>();


    public static void main(String[] args) throws Exception {
        AdventOfCodeDay2 aocD2 = new AdventOfCodeDay2();
        aocD2.run();
        System.out.print(aocD2.getPressedNumbers());

        //System.out.println(numPad[1][1]);
        //System.out.println(numPad[2][0]);
        //System.out.println(numPad[0][2]);
    }

    @Override
    public void processLine(String line) {
        for (int i = 0 ; i < line.length() ; i++){
            Direction direction = Direction.value(line.charAt(i));
            currentPoint = processPadMovement(direction, currentPoint);
        }
        pressedNumbers.add(numPad[(int)currentPoint.getX()][(int)currentPoint.getY()]);
    }

    private Point processPadMovement(Direction direction, Point currentPoint) {
        int x = (int)currentPoint.getX();
        int y = (int)currentPoint.getY();

        switch (direction){
            case LEFT:
                x = x == MIN_X ? x : x - 1;
                break;
            case RIGHT:
                x = x == MAX_X ? x : x + 1;
                break;
            case DOWN:
                y = y == MIN_Y ? y : y - 1;
                break;
            case UP:
                y = y == MAX_Y ? y : y + 1;
                break;
        }
        return new Point(x, y);
    }

    @Override
    public String getFileResourceName() {
        return "/input-day-2.txt";
    }

    public List<Integer> getPressedNumbers(){
        return pressedNumbers;
    }
}
