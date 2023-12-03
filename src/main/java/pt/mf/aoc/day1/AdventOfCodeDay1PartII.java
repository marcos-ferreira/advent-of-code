package pt.mf.aoc.day1;

import pt.mf.aoc.AbstractAoc;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdventOfCodeDay1PartII extends AbstractAoc {

    private static final Pattern DIGIT_REGEX = Pattern.compile("(?=(1|2|3|4|5|6|7|8|9|one|two|three|four|five|six|seven|eight|nine))",
            Pattern.CASE_INSENSITIVE);

    private static int total = 0;

    private static final Map<String, Integer> numberMapping = Map.of(
            "one", 1,
            "two", 2,
            "three", 3,
            "four", 4,
            "five", 5,
            "six", 6,
            "seven", 7,
            "eight", 8,
            "nine", 9);

    public static void main(String[] args) throws Exception {
        new AdventOfCodeDay1PartII().run();
        System.out.println("total: 54277 " + total);
    }

    public void processLine(String line) {
        int number = getNumber(line);
        total += number;
    }

    protected int getNumber(String line) {
        return Integer.parseInt(getFirstDigit(line).concat(getLastDigit(line)));
    }

    protected String getFirstDigit(String line) {
        Matcher matcher = DIGIT_REGEX.matcher(line);
        if (matcher.find()) {
            String firstNumber = matcher.group(1);
            Integer mappedNumber = numberMapping.get(firstNumber);
            return mappedNumber == null ? firstNumber : String.valueOf(mappedNumber);
        }

        throw new IllegalArgumentException("It was not possible to return first digit in line : " + line);
    }

    protected static String getLastDigit(String line) {
        Matcher matcher = DIGIT_REGEX.matcher(line);
        String lastNumber = null;
        while (matcher.find()) {
            lastNumber = matcher.group(1);
        }

        if (lastNumber != null) {
            Integer mappedNumber = numberMapping.get(lastNumber);
            return mappedNumber == null ? lastNumber : String.valueOf(mappedNumber);
        }

        throw new IllegalArgumentException("It was not possible to return last digit in line : " + line);
    }

    @Override
    public String getFileResourceName() {
        return "/day-1/input-day-1.txt";
    }
}
