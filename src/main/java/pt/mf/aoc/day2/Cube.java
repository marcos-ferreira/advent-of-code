package pt.mf.aoc.day2;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Cube {
    RED("red"), //
    BLUE("blue"), //
    GREEN("green");

    private String color;

    public static Cube getCube(String color) {
        return switch (color) {
            case "blue" -> Cube.BLUE;
            case "red" -> Cube.RED;
            case "green" -> Cube.GREEN;
            default -> throw new IllegalArgumentException("Invalid cube color " + color);
        };
    }
}
