package pt.mf.aoc.day3;

import lombok.AllArgsConstructor;
import lombok.Data;
import pt.mf.aoc.AbstractAoc;

import java.util.ArrayList;
import java.util.List;

public class AdventOfCodeDay3 extends AbstractAoc {

    // load input
    private final List<String> input = new ArrayList<>();

    private char[][] matrix = null;

    public static void main(String[] args) throws Exception {
        var aoc = new AdventOfCodeDay3();
        aoc.run(); // read and load input
        aoc.processMatrix();
        aoc.printMatrix();
    }

    public void processMatrix() {
        this.processInput();

        for (int i = 1; i < matrix.length - 1; i++) {
           for (int j = 1; j < matrix[i].length - 1; j++) {
                if(Character.isDigit(matrix[i][j])) {
                    StringBuilder number = new StringBuilder();
                    for (int x = j; x < matrix[i].length - 1; x++) {
                        if (!Character.isDigit(matrix[i][x])) {
                            j = x;
                            break;
                        }

                        number.append(matrix[i][x]);
                    }
                    int num = Integer.parseInt(number.toString());
                    System.out.println(num);
                }
            }
        }
    }

    @Data
    @AllArgsConstructor
    static class Point {
        private int x;
        private int y;
    }

    private boolean searchForAdjSymbol(char c, int x, int y) {
        for (int i = y - 1; i < y + 1; i++) {
            for (int j = x - 1; j < x + 1; j++) {
                // matrix[i][j]
            }
        }

        return false; //
    }

    /**
     * build matrix
     */
    private void processInput() {
        initMatrix();

        for (int i = 0 ; i < input.size() ; i++) {
            processInputRow(i, input.get(i));
        }
    }

    private void processInputRow(int y, String line) {
        for(int x = 0 ; x < line.length() ; x++)
            matrix[y+1][x+1] = line.charAt(x);
    }

    private void initMatrix(){
        matrix = new char[input.size() + 2][input.size() + 2];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                matrix[i][j] = '-';
    }

    /**
     * print matrix after processing input
     */
    public void printMatrix() {
        for (int i = 1; i < matrix.length - 1; i++) {
            for (int j = 1; j < matrix[i].length -1; j++) {
                System.out.print(matrix[i][j] + " ");
                if (j == matrix[j].length - 2) {
                    System.out.println(); // break line
                }
            }
        }
    }

    @Override
    public void processLine(String line) {
        input.add(line);
    }

    @Override
    public String getFileResourceName() {
        return "/day-3/input-day-3.txt";
    }
}
