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
    private static final Map<Integer, List<Grab>> gameMap = new HashMap<>();

    private static final Pattern GAME_REGEX = Pattern.compile("Game (\\d*): (.*)");
    private static final Pattern GRAB_REGEX = Pattern.compile("(\\d*) (blue|red|green)");

    public static void main(String[] args) throws Exception {
        new AdventOfCodeDay2().run();

        for (Map.Entry<Integer, List<Grab>> entry : gameMap.entrySet()) {
            System.out.println(entry.getKey());
            for (Grab grab : entry.getValue()) {
                System.out.println(grab);
            }
        }
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

    private Grab getGrab(String cubes) {
        Matcher matcher = GRAB_REGEX.matcher(cubes);

        var grabList = new ArrayList<Grab>();
        Grab grab = new Grab();
        while (matcher.find()) {
            var cubeCount = Integer.parseInt(matcher.group(1));
            var cube = getCube(matcher.group(2));

            grab.getCubes().put(cube, cubeCount);
            grabList.add(grab);
        }
        return grab;
    }

    private Cube getCube(String cubeColor) {
        return switch (cubeColor) {
            case "blue" -> Cube.BLUE;
            case "red" -> Cube.RED;
            case "green" -> Cube.GREEN;
            default -> throw new IllegalArgumentException("Invalid cube color " + cubeColor);
        };
    }
}
