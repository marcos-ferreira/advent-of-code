package pt.mf.aoc.day1;

import pt.mf.aoc.utils.AbstractAoc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdventOfCodeDay1 extends AbstractAoc {

    private static final Pattern FIRST_DIGIT_REGEX = Pattern.compile("\\d");
    private static final Pattern LAST_DIGIT_REGEX = Pattern.compile("\\d(?=\\D*$)");

    private static int total = 0;

    public static void main(String[] args) throws Exception {
        new AdventOfCodeDay1().run();
        System.out.println(total);
    }

    @Override
    public String getFileResourceName() {
        return "/day-1/input-day-1.txt";
    }

    @Override
    public void processLine(String line) {
        int number = getNumber(line);
        System.out.println(number);
        total += number;
    }

    protected int getNumber(String line) {
        return Integer.parseInt(getFirstDigit(line).concat(getLastDigit(line)));
    }

    protected String getFirstDigit(String line) {
        Matcher matcher = FIRST_DIGIT_REGEX.matcher(line);
        if (matcher.find()) {
            return matcher.group();
        }

        throw new IllegalArgumentException("It was not possible to return first digit in line : " + line);
    }

    protected String getLastDigit(String line) {
        Matcher matcher = LAST_DIGIT_REGEX.matcher(line);
        if (matcher.find()) {
            return matcher.group();
        }

        throw new IllegalArgumentException("It was not possible to return last digit in line : " + line);
    }
}