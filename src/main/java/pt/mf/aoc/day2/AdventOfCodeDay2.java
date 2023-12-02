package pt.mf.aoc.day2;

import pt.mf.aoc.AbstractAoc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdventOfCodeDay2 extends AbstractAoc {

    /**
     * key - game ID
     * value - list of grabs of the given game
     */
    protected static final Map<Integer, List<Grab>> gameMap = new HashMap<>();

    private static final Pattern GAME_REGEX = Pattern.compile("Game (\\d*): (.*)");
    private static final Pattern GRAB_REGEX = Pattern.compile("(\\d*) (blue|red|green)");

    private static final int MAX_RED_CUBES = 12;
    private static final int MAX_GREEN_CUBES = 13;
    private static final int MAX_BLUE_CUBES = 14;

    public static void main(String[] args) throws Exception {
        var aocDay2 = new AdventOfCodeDay2();
        aocDay2.run();

        System.out.println("total possible games: " + aocDay2.processPossibleGames());
    }

    @Override
    public String getFileResourceName() {
        return "/day-2/input-day-2.txt";
    }

    @Override
    public void processLine(String line) {
        Matcher matcher = GAME_REGEX.matcher(line);
        if (matcher.find()) {
            Integer gameId = Integer.parseInt(matcher.group(1));
            String[] grabs = matcher.group(2).split(";");

            var grabList = new ArrayList<Grab>();
            for (String grab : grabs) {
                var g = getGrab(grab);
                grabList.add(g);
            }
            gameMap.put(gameId, grabList);
        }
    }

    private Grab getGrab(String grab) {
        Matcher matcher = GRAB_REGEX.matcher(grab);

        var grabList = new ArrayList<Grab>();
        var g = new Grab();
        while (matcher.find()) {
            var cubeCount = Integer.parseInt(matcher.group(1));
            var cube = getCube(matcher.group(2));

            g.getCubes().put(cube, cubeCount);
            grabList.add(g);
        }
        return g;
    }

    private Cube getCube(String cube) {
        return switch (cube) {
            case "blue" -> Cube.BLUE;
            case "red" -> Cube.RED;
            case "green" -> Cube.GREEN;
            default -> throw new IllegalArgumentException("Invalid cube color " + cube);
        };
    }

    public int processPossibleGames() {
        int total = 0;
        for (Map.Entry<Integer, List<Grab>> entry : gameMap.entrySet()) {
            Integer gameId = entry.getKey();

            if (isPossibleGame(entry)) {
                total += gameId;
            }
        }

        return total;
    }

    public void printGameMap() {
        for (Map.Entry<Integer, List<Grab>> entry : gameMap.entrySet()) {
            System.out.println(entry.getKey());
            for (Grab grab : entry.getValue()) {
                System.out.println(grab);
            }
        }
    }

    private boolean isPossibleGame(Map.Entry<Integer, List<Grab>> entry) {
        for (Grab grab : entry.getValue()) {
            Map<Cube, Integer> cubes = grab.getCubes();
            for (Map.Entry<Cube, Integer> cube : cubes.entrySet()) {
                Cube key = cube.getKey();
                Integer value = cube.getValue();
                if(!isValidCubeCount(key, value)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValidCubeCount(Cube cube, Integer cubeCount) {
        return switch (cube) {
            case RED -> cubeCount <= MAX_RED_CUBES;
            case BLUE -> cubeCount <= MAX_BLUE_CUBES;
            case GREEN -> cubeCount <= MAX_GREEN_CUBES;
        };
    }


}