package pt.mf.aoc.day2;

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

        for (Map.Entry<Integer, List<Grab>> entry : gameMap.entrySet()) {
            Integer gameId = entry.getKey();
            int minRed = 0;
            int minBlue = 0;
            int minGreen = 0;
            for (Grab grab : entry.getValue()) {
                Map<Cube, Integer> cubes = grab.getCubes();
                for (Map.Entry<Cube, Integer> cube : cubes.entrySet()) {
                    Cube key = cube.getKey();
                    Integer value = cube.getValue();
                    switch (key) {
                        case RED :{
                            minRed = value > minRed ? value : minRed;
                            break;
                        }
                        case BLUE: {
                            minBlue = value > minBlue ? value : minBlue;
                            break;
                        }
                        case GREEN:{
                            minGreen = value > minGreen ? value : minGreen;
                            break;
                        }
                    }
                }
            }
            int power = minRed*minBlue*minGreen;
            total+= power;
        }

        return total;
    }
}
