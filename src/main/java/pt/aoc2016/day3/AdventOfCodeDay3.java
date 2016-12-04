package pt.aoc2016.day3;

import pt.aoc2016.util.Processor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Marcos on 03/12/2016.
 */
public class AdventOfCodeDay3 extends Processor{

    private static Pattern pattern = Pattern.compile("\\s+([0-999]{1,})\\s+([0-999]{1,})\\s+([0-999]{1,})");

    private int count = 0;
    private int allMatches;

    public static void main(String[] args) throws Exception {
        Matcher matcher = pattern.matcher("  617    1  399");
        if(matcher.find()) {
            String num1 = matcher.group(1);
            System.out.println("1 " + num1.trim());
            String num2 = matcher.group(2);
            System.out.println("2 " +num2.trim());
            String num3 = matcher.group(3);
            System.out.println("3 " +num3.trim());

        }

        matcher = pattern.matcher("    7  479  978");
        if(matcher.find()) {
            String num1 = matcher.group(1);
            System.out.println("1 " + num1.trim());
            String num2 = matcher.group(2);
            System.out.println("2 " +num2.trim());
            String num3 = matcher.group(3);
            System.out.println("3 " +num3.trim());

        }
        AdventOfCodeDay3 adventOfCodeDay3 = new AdventOfCodeDay3();
        adventOfCodeDay3.run();

        System.out.println("Possible Triangles: " + adventOfCodeDay3.getCount());
        System.out.println("All Matches: " + adventOfCodeDay3.getAllMatches());
        System.out.println("Last Line: " + adventOfCodeDay3.getLineNumber());
    }

    public String getFileResourceName() {
        return "/input-day-3.txt";
    }

    public void processLine(String line) {
        Matcher matcher = pattern.matcher(line);

        if(matcher.find()) {
            allMatches++;

            int trigleSide1 = Integer.parseInt(matcher.group(1).trim());
            int trigleSide2 = Integer.parseInt(matcher.group(2).trim());
            int trigleSide3 = Integer.parseInt(matcher.group(3).trim());

            boolean validI = trigleSide1 + trigleSide2 > trigleSide3;
            boolean validII = trigleSide2 + trigleSide3 > trigleSide1;
            boolean validIII = trigleSide1 + trigleSide3 > trigleSide2;

            if (validI && validII && validIII) {
                count++;
            }
        }
        else{
            System.out.println("No match for : " + line);
        }
    }

    public int getAllMatches() {
        return allMatches;
    }

    public int getCount() {
        return count;
    }
}
