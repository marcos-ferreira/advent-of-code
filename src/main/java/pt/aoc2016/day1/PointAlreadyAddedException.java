package pt.aoc2016.day1;

import java.awt.*;

/**
 * Created by Marcos on 01/12/2016.
 */
public class PointAlreadyAddedException extends Exception{

    private static final long serialVersionUID = 1L;

    private Point point;


    public PointAlreadyAddedException(String msg, Point p) {
        this.point = p;
    }

    public Point getPoint() {
        return point;
    }
}
