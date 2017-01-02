package pt.aoc2016.day11;

/**
 * Created by Marcos on 02/01/2017.
 */
public class Elevator {
    private String s1 = null;
    private String s2 = null;

    public String getS1(){
        return s1;
    }

    public void setS1(String s1){
        this.s1 = s1;
    }

    public String getS2(){
        return s2;
    }

    public void setS2(String s2){
        this.s2 = s2;
    }

    public boolean hasRoom(){
        return s1 == null || s2 == null;
    }
}
