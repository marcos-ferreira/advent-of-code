package pt.aoc2016.day2;

import pt.aoc2016.util.AbstractAoc;

import java.awt.*;
import java.util.*;

/**
 * Created by Marcos on 04/12/2016.
 */
public class AdventOfCodeDay2PartII extends AbstractAoc {

    private static final String[][] numPad = new String[][]{
            {"0", "0", "5", "0", "0"},
            {"0", "A", "6", "2", "0"},
            {"D", "B", "7", "3", "1"},
            {"0", "C", "8", "4", "0"},
            {"0", "0", "9", "0", "0"}
    };

    private int MAX_X = 4;
    private int MIN_X = 0;

    private int MAX_Y = 4;
    private int MIN_Y = 0;

    private Point currentPoint = new Point(0,2);

    private java.util.List<String> pressedNumbers = new ArrayList<String>();


    public static void main(String[] args) throws Exception {
        AdventOfCodeDay2PartII p2 = new AdventOfCodeDay2PartII();
        p2.run();
        System.out.print(p2.getPressedNumbers());


        //System.out.println(numPad[1][1]);//A
        //System.out.println(numPad[0][2]);//5
        //System.out.println(numPad[3][2]);//8
        //System.out.println(numPad[2][3]);//3
        //System.out.println(numPad[2][4]);//1

    }

    @Override
    public void processLine(String line) {
        for (int i = 0 ; i < line.length() ; i++){
            Direction direction = Direction.value(line.charAt(i));
            currentPoint = processPadMovement(direction, currentPoint);
            System.out.println(currentPoint + " " + String.valueOf(numPad[(int)currentPoint.getX()][(int)currentPoint.getY()]) + " " + direction);
        }
        pressedNumbers.add(String.valueOf(numPad[(int)currentPoint.getX()][(int)currentPoint.getY()]));
    }

    private Point processPadMovement(Direction direction, Point currentPoint) {
        int x = (int)currentPoint.getX();
        int y = (int)currentPoint.getY();

        switch (direction){
            case LEFT:
                x = x == MIN_X ? x : numPad[x - 1][y].equals("0") ? x : x - 1;
                break;
            case RIGHT:
                x = x == MAX_X ? x : numPad[x + 1][y].equals("0") ? x : x + 1;
                break;
            case DOWN:
                y = y == MIN_Y ? y : numPad[x][y - 1].equals("0") ? y : y - 1;
                break;
            case UP:
                y = y == MAX_Y ? y : numPad[x][y + 1].equals("0") ? y : y + 1;
                break;
        }
        return new Point(x, y);
    }

    @Override
    public String getFileResourceName() {
        return "/input-day-2.txt";
    }

    public java.util.List<String> getPressedNumbers(){
        return pressedNumbers;
    }


}
