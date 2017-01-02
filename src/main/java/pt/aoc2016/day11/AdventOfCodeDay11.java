package pt.aoc2016.day11;

import java.util.*;

/**
 *  The first floor contains a promethium generator and a promethium-compatible microchip.
 *  The second floor contains a cobalt generator, a curium generator, a ruthenium generator, and a plutonium generator.
 *  The third floor contains a cobalt-compatible microchip, a curium-compatible microchip, a ruthenium-compatible microchip, and a plutonium-compatible microchip.
 *  The fourth floor contains nothing relevant.
 *
 * Created by Marcos on 02/01/2017.
 */
public class AdventOfCodeDay11{

    private static final Map<Floor, List<String>> flourMap = new TreeMap<Floor, List<String>>();

    static {
        flourMap.put(new Floor("F4", null,"F3"), new ArrayList());
        flourMap.put(new Floor("F3", "F4","F2"), Arrays.asList(new String[]{"COBM","CURM","RUTM","PLUM"}));
        flourMap.put(new Floor("F2", "F3","F1"), Arrays.asList(new String[]{"COBG","CURG","RUTG","PLUG"}));
        flourMap.put(new Floor("F1", "F2",null), Arrays.asList(new String[]{"PROMG","PROMM"}));
    }


    public static void main(String[] args) {
        AdventOfCodeDay11 aoc11 = new AdventOfCodeDay11();

        Elevator el = new Elevator();

        aoc11.run(null, el);
    }

    public void run(Floor floor, Elevator elevator){
        for (Map.Entry entry : flourMap.entrySet()) {
            Floor key = (Floor) entry.getKey();
        }
    }

    public Elevator addToElevator(List<String> flour){
        for (String flourCompound : flour) {
            for (String flourCompound2 : flour) {
                if(!flourCompound.equals(flourCompound2)){

                }
            }
        }

        return null;
    }

    public boolean match(String c1, String c2){
        boolean opposit = c1.charAt(c1.length()-1) != c2.charAt(c2.length()-1);
        boolean match = c1.substring(0, c1.length() -1).equals(c2.substring(0, c2.length() -1));

        return opposit && match;
    }

    public boolean isMicroShip(String compound){
        return compound.charAt(compound.length() -1) == 'M';
    }

}
