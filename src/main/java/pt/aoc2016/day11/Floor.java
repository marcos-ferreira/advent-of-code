package pt.aoc2016.day11;

/**
 * Created by Marcos on 02/01/2017.
 */
public class Floor {
    private String current;
    private String next;
    private String previous;

    public Floor(String current, String next, String previous) {
        this.current = current;
        this.next = next;
        this.previous = previous;
    }

    public String getCurrent() {
        return current;
    }

    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }
}
