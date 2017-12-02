package pt.aoc2016.day4;

import pt.util.AbstractAoc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Marcos on 05/12/2016.
 */
public class AdventOfCodeDay4 extends AbstractAoc {

    private Pattern pattern = Pattern.compile("(.*)-(.*)\\[(.*?)\\]");

    public static void main(String[] args) throws Exception {
        new AdventOfCodeDay4().run();
    }


    public String getFileResourceName() {
        return "/input-day-4.txt";
    }

    public void processLine(String line) {
        Matcher matcher = pattern.matcher(line);

        if(matcher.find()){
            String name = matcher.group(1);
            String sectorId = matcher.group(2);
            String hash = matcher.group(3);

            System.out.println(name + " " + sectorId + " " + hash);
        }
    }


    private class Room{
        
    }
}
