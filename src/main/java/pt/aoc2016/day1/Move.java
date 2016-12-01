package pt.aoc2016.day1;

/**
 * Created by Marcos on 01/12/2016.
 */
public enum Move {
    LEFT,RIGHT;

    /**
     * R - RIGHT
     * L - LEFT
     *
     * @param move
     * @return
     */
    public static Move value(String move){
        if(move.equals("R")){
            return Move.RIGHT;
        }

        if(move.equals("L")){
            return Move.LEFT;
        }

        throw new IllegalArgumentException("Invalid parameter " + move);
    }
}
