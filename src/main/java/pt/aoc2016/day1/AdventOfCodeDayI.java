package pt.aoc2016.day1;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Marcos on 01/12/2016.
 */
public class AdventOfCodeDayI {
    private static final String[] input = new String[] { "R5", "L2", "L1", "R1", "R3", "R3", "L3", "R3", "R4", "L2",
            "R4", "L4", "R4", "R3", "L2", "L1", "L1", "R2", "R4", "R4", "L4", "R3", "L2", "R1", "L4", "R1", "R3", "L5",
            "L4", "L5", "R3", "L3", "L1", "L1", "R4", "R2", "R2", "L1", "L4", "R191", "R5", "L2", "R46", "R3", "L1",
            "R74", "L2", "R2", "R187", "R3", "R4", "R1", "L4", "L4", "L2", "R4", "L5", "R4", "R3", "L2", "L1", "R3",
            "R3", "R3", "R1", "R1", "L4", "R4", "R1", "R5", "R2", "R1", "R3", "L4", "L2", "L2", "R1", "L3", "R1", "R3",
            "L5", "L3", "R5", "R3", "R4", "L1", "R3", "R2", "R1", "R2", "L4", "L1", "L1", "R3", "L3", "R4", "L2", "L4",
            "L5", "L5", "L4", "R2", "R5", "L4", "R4", "L2", "R3", "L4", "L3", "L5", "R5", "L4", "L2", "R3", "R5", "R5",
            "L1", "L4", "R3", "L1", "R2", "L5", "L1", "R4", "L1", "R5", "R1", "L4", "L4", "L4", "R4", "R3", "L5", "R1",
            "L3", "R4", "R3", "L2", "L1", "R1", "R2", "R2", "R2", "L1", "L1", "L2", "L5", "L3", "L1" };

    private static List<Point> list = new ArrayList<Point>();

    public static void main(String[] args) throws PointAlreadyAddedException {
        new AdventOfCodeDayI().run();
    }

    public void run() throws PointAlreadyAddedException {
        runPartI();
        runPartII();
    }

    private void runPartI() throws PointAlreadyAddedException {
        Point position = new Point(0, 0);
        Direction direction = Direction.NORTH;
        Location location = new Location(position, direction);

        for (int i = 0; i < input.length; i++) {
            Move moveTo = Move.value(String.valueOf(input[i].charAt(0)));
            Integer moveValue = Integer.parseInt(input[i].substring(1));

            location = calculate(location.getCurrentPosition(), location.getCurrentDirection(), moveTo, moveValue, false);
        }

        System.out.println("Part I: " + calculateManhattanDistance(new Point(0, 0), location.getCurrentPosition()));

        list.clear();
        list = new ArrayList<Point>();
    }

    private void runPartII() {
        Point p = new Point(0, 0);
        Direction currentDirection = Direction.NORTH;
        Location location = new Location(p, currentDirection);

        try {
            for (int i = 0; i < input.length; i++) {
                Move moveTo = Move.value(String.valueOf(input[i].charAt(0)));
                Integer moveValue = Integer.parseInt(input[i].substring(1));

                location = calculate(location.getCurrentPosition(), location.getCurrentDirection(), moveTo, moveValue,
                        true);
            }

        } catch (PointAlreadyAddedException e) {
            System.out.println("Part II: " + calculateManhattanDistance(new Point(0, 0), e.getPoint()));
        }

        list.clear();
        list = new ArrayList<Point>();
    }

    private Location calculate(Point currentPosition, Direction direction, Move moveTo, Integer moveValue, boolean isPartII)
            throws PointAlreadyAddedException {


        int x = (int) currentPosition.getX();
        int y = (int) currentPosition.getY();

        switch (direction) {
            case NORTH:
                switch (moveTo) {
                    case LEFT:
                        direction = Direction.WEST;
                        x = x - moveValue;

                        if (isPartII) {
                            for (int i = x; i < currentPosition.getX(); i++) {
                                addPoint(new Point(i, y));
                            }
                        }
                        break;
                    case RIGHT:
                        direction = Direction.EAST;
                        x = x + moveValue;

                        if (isPartII) {
                            for (int i = (int) currentPosition.getX() + 1; i <= x; i++) {
                                addPoint(new Point(i, y));
                            }
                        }
                        break;
                    default:
                        break;
                }
                break;
            case SOUTH:
                switch (moveTo) {
                    case LEFT:
                        direction = Direction.EAST;
                        x = x + moveValue;

                        if (isPartII) {
                            for (int i = (int) currentPosition.getX() + 1; i <= x; i++) {
                                addPoint(new Point(i, y));
                            }
                        }

                        break;
                    case RIGHT:
                        direction = Direction.WEST;
                        x = x - moveValue;

                        if (isPartII) {
                            for (int i = x; i < currentPosition.getX(); i++) {
                                addPoint(new Point(i, y));
                            }
                        }

                        break;
                    default:
                        break;
                }
                break;
            case EAST:
                switch (moveTo) {
                    case LEFT:
                        direction = Direction.NORTH;
                        y = y + moveValue;

                        if (isPartII) {
                            for (int i = (int) currentPosition.getY() + 1; i <= y; i++) {
                                addPoint(new Point(x, i));
                            }
                        }

                        break;
                    case RIGHT:
                        direction = Direction.SOUTH;
                        y = y - moveValue;

                        if (isPartII) {
                            for (int i = y; i < currentPosition.getY(); i++) {
                                addPoint(new Point(x, i));
                            }
                        }
                        break;
                    default:
                        break;
                }
                break;
            case WEST:
                switch (moveTo) {
                    case LEFT:
                        direction = Direction.SOUTH;
                        y = y - moveValue;

                        if (isPartII) {
                            for (int i = y; i < currentPosition.getY(); i++) {
                                addPoint(new Point(x, i));
                            }
                        }
                        break;
                    case RIGHT:
                        direction = Direction.NORTH;
                        y = y + moveValue;

                        if (isPartII) {
                            for (int i = (int) currentPosition.getY() + 1; i <= y; i++) {
                                addPoint(new Point(x, i));
                            }
                        }
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;

        }

        Point p = new Point(x, y);
        return new Location(p, direction);
    }

    private void addPoint(Point p) throws PointAlreadyAddedException {
        if (list.contains(p)) {
            throw new PointAlreadyAddedException("Point " + p + " already exists!", p);
        }

        list.add(p);
    }

    private int calculateManhattanDistance(Point p1, Point p2) {
        return (int) (Math.abs(p2.getX() - p1.getX()) + Math.abs(p2.getY() - p1.getY()));
    }

}
