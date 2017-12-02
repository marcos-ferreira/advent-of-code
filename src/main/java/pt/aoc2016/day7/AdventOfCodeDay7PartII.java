package pt.aoc2016.day7;

import pt.util.AbstractAoc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Marcos on 09/12/2016.
 */
public class AdventOfCodeDay7PartII extends AbstractAoc {
    private int countTLS = 0;

    public static void main(String[] args) throws Exception {
        AdventOfCodeDay7PartII aocD7PartII = new AdventOfCodeDay7PartII();
        aocD7PartII.run();
        System.out.println(aocD7PartII.getCountTLS());
    }

    public void processLine(String line) {
        if(isValidSSL(line)){
            //System.out.println("valid: " + line);
            countTLS++;
        } else{
            System.out.println("invalid: " + line);
        }
    }

    public boolean isValidSSL(String ipv7){
        // get all aba strings from brakets
        List<String> abaStrings = getABAStrings(getBounderyWords(ipv7));

        // invert all aba strings to bab strings
        List<String> babStrings = convertABAToBAB(abaStrings);

        // get all boundery words
        List<String> bounderyWords = getBracketWords(ipv7);

        // match any inverted aba (bab) in a boundery word
        for (String bounderyWord: bounderyWords) {
            for (String bab: babStrings) {
                if(bounderyWord.contains(bab)){
                    return true;
                }
            }
        }

        return false;
    }

    private List<String> convertABAToBAB(List<String> values){
        List<String> invertedValues = new ArrayList<String>();
        for (String value: values) {
            if(value.length() != 3 || value.charAt(0) != value.charAt(2) || value.charAt(0) == value.charAt(1)){
                throw new IllegalArgumentException(" Invalid 'aba' value " + value + " in list " + values);
            }

            StringBuilder sb = new StringBuilder();
            sb.append(value.charAt(1)).append(value.charAt(0)).append(value.charAt(1));
            invertedValues.add(sb.toString());
        }

        return invertedValues;
    }


    public List<String> getABAStrings(List<String> values){
        List<String> matches = new ArrayList<String>();

        for (String value: values) {
            // get all aba bab xyx xxx yyy aaa strings
            Pattern patternABA = Pattern.compile("(.).\\1"); //XXX: abab is suppose to match aba and bab and is not...

            // get all aaa xxx yyy aaa strings
            Pattern patternAAA = Pattern.compile("(.)\\1\\1");

            for (int i = 0; i < value.length(); i++) {  //MAJOR HACK..JUST FIX «patternABA» REGEX!!!
                Matcher matcher = patternABA.matcher(value.substring(i));
                while (matcher.find()){
                    String abba = matcher.group(0);
                    // is invalid if matches aaa xxx yyy ...
                    Matcher invalidABA = patternAAA.matcher(abba);
                    if(!invalidABA.find()){
                        if(!matches.contains(abba))
                            matches.add(abba);
                    }
                }
            }
        }
        return matches;
    }

    public int getCountTLS(){
        return countTLS;
    }

    private List<String> getBracketWords(String ipv7){
        // pattern get all strings inside brackets
        Pattern patternIn = Pattern.compile("(\\[.*?\\])");

        List<String> bracketWordList = new ArrayList<String>();
        Matcher matcher = patternIn.matcher(ipv7);

        while(matcher.find()){
            bracketWordList.add(matcher.group(1));
        }

        return bracketWordList;
    }


    private List<String> getBounderyWords(String ipv7){
        List<String> bracketWordList = getBracketWords(ipv7);

        String bounderyWordLine = ipv7;
        for (String bracketWord: bracketWordList) {
            bounderyWordLine = bounderyWordLine.replace(bracketWord, " ");
        }

        return Arrays.asList(bounderyWordLine.split(" "));
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
