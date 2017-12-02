package pt.aoc2016.day10;

import pt.util.AbstractAoc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Marcos on 10/12/2016.
 */
public class AdventOfCodeDay10 extends AbstractAoc{

    // value «number» goes to bot «number»
    private Pattern value_pattern = Pattern.compile("value (.*) goes to bot (.*)");

    // bot «number» gives low to bot/output and high to bot/output
    private Pattern bot_pattern = Pattern.compile("bot (.*) gives low to (.*) (.*) and high to (.*) (.*)");

    // key - bot number | value - Bot
    private Map<Integer, Bot> botMap = new HashMap<Integer,Bot>();

    // key - output bin number | value - list of chips
    private Map<Integer, List<Chip>> outputMap = new HashMap<Integer,List<Chip>>();

    public static void main(String[] args) throws Exception {
        AdventOfCodeDay10 aocDay10 = new AdventOfCodeDay10();
        aocDay10.run();
    }

    public void processLine(String line) {
        Matcher bot_matcher = bot_pattern.matcher(line);
        Matcher value_matcher = value_pattern.matcher(line);

        if(bot_matcher.find()){
            Integer botGiveNumber = Integer.parseInt(bot_matcher.group(1));

            String lowReceiver = bot_matcher.group(2);
            Integer lowReceiverNumber = Integer.parseInt(bot_matcher.group(3));

            String highReceiver = bot_matcher.group(4);
            Integer highReceiverNumber = Integer.parseInt(bot_matcher.group(5));

        } else if(value_matcher.find()){

        }else{
            throw new IllegalArgumentException(" Invalid line " + line);
        }
    }

    private void processBotMatcher(Integer botGiveNumber, String lowReceiver, Integer lowReceiverNumber, String highReceiver, Integer highReceiverNumber){
        if(lowReceiver.equals("bot")) {
            Bot botGiver = botMap.get(botGiveNumber);
            if (botGiver == null) {
                botGiver = new Bot(botGiveNumber);
                botMap.put(botGiveNumber, botGiver);
            }else{

            }
        }
        else{
            List<Chip> chips = outputMap.get(lowReceiver);
            if(chips == null){
                chips = new ArrayList<Chip>();
                chips.add(new Chip(lowReceiverNumber));
                outputMap.put(lowReceiverNumber, chips);
            }else{
                chips.add(new Chip(lowReceiverNumber));
            }
        }

    }

    private void processValueMatcher(){

    }


    public String getFileResourceName() {
        return "/input-day-10.txt";
    }
}
