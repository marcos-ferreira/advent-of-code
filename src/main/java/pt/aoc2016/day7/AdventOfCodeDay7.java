package pt.aoc2016.day7;

import pt.aoc2016.util.AbstractAoc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Marcos on 08/12/2016.
 */
public class AdventOfCodeDay7 extends AbstractAoc{

    private int countTLS = 0;

    public static void main(String[] args) throws Exception {
        AdventOfCodeDay7 aocD7 = new AdventOfCodeDay7();
        aocD7.run();
        System.out.println(aocD7.getCountTLS());
    }

    public void processLine(String line) {
        if(isValidTLS(line)){
            countTLS++;
        }
    }

    public boolean isValidTLS(String ipv7){
        List<String> bracketWords = getBracketWords(ipv7);
        for (String bracketW: bracketWords) {
            if(isABBAString(bracketW)){
                return false;
            }
        }

        List<String> bounderyWords = getBounderyWords(ipv7);
        for (String bounderyW: bounderyWords) {
            if(isABBAString(bounderyW)){
                return true;
            }
        }

        return false;
    }

    public List<String> getBracketWords(String ipv7){
        // pattern get all strings inside brackets
        Pattern patternIn = Pattern.compile("(\\[.*?\\])");

        List<String> bracketWordList = new ArrayList<String>();
        Matcher matcher = patternIn.matcher(ipv7);

        while(matcher.find()){
            bracketWordList.add(matcher.group(1));
        }

        return bracketWordList;
    }


    public List<String> getBounderyWords(String ipv7){
        List<String> bracketWordList = getBracketWords(ipv7);

        String bounderyWordLine = ipv7;
        for (String bracketWord: bracketWordList) {
            bounderyWordLine = bounderyWordLine.replace(bracketWord, " ");
        }

        return Arrays.asList(bounderyWordLine.split(" "));
    }

    public static boolean isABBAString(String value){
        // pattern to get all abba xyyx cddc aaaa xxxx on a string
        Pattern abbaPattern = Pattern.compile("(.)(.)\\2\\1");

        // pattern to get all xxxx aaaa bbbb on a string
        Pattern invalidAbba = Pattern.compile("(\\w)\\1(\\w)\\2");

        Matcher matcher = abbaPattern.matcher(value);

        while(matcher.find()){
            String abba = matcher.group(0);
            Matcher invAbba = invalidAbba.matcher(abba);
            if(!invAbba.find()){
                return true;
            }
        }

        return false;
    }

    public int getCountTLS(){
        return countTLS;
    }

    private void printList(List<String> l){
        for (String s : l) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public String getFileResourceName() {
        return "/input-day-7.txt";
    }
}
