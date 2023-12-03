package pt.mf.aoc.day2;

import lombok.val;

import java.util.List;
import java.util.Map;

public class AdventOfCodeDay2PartII extends AdventOfCodeDay2{

    public static void main(String[] args) throws Exception {
        var aocDay2PartII = new AdventOfCodeDay2PartII();
        aocDay2PartII.run();

        System.out.println("total power set: " + aocDay2PartII.getPowerSetOfAllGames());
    }

    public int getPowerSetOfAllGames() {
        int total = 0;
        for (var game : gameMap.entrySet()) {
            int minRed = 0;
            int minBlue = 0;
            int minGreen = 0;
            for (var grab : game.getValue()) {
                var cubes = grab.getCubes();
                for (var cube : cubes.entrySet()) {
                    Cube color = cube.getKey();
                    Integer cubeCount = cube.getValue();
                    switch (color) {
                        case RED -> minRed = cubeCount > minRed ? cubeCount : minRed;
                        case BLUE -> minBlue = cubeCount > minBlue ? cubeCount : minBlue;
                        case GREEN -> minGreen = cubeCount > minGreen ? cubeCount : minGreen;
                    }
                }
            }
            int power = minRed*minBlue*minGreen;
            total+= power;
        }

        return total;
    }
}
