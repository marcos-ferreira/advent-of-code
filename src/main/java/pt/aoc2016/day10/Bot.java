package pt.aoc2016.day10;

/**
 * Created by Marcos on 10/12/2016.
 */
public class Bot {
    private int number;

    private Chip[] chips = new Chip[2];

    public Bot(int number) {
        this.number = number;
    }

    public void addChip(Chip chip){
        if(chips[0] == null){
            chips[0] = chip;
        } else if (chips[1] == null){
            chips[1] = chip;
        }
        else{
            throw new IllegalArgumentException(" Bot already with two chips ");
        }
    }

    public Chip getLowValueShip(){
        // bot has no chips
        if(chips[0] == null && chips[1] == null){
            return null;
        }

        // bot has two chips
        if(chips[0] != null && chips[1] != null){
            if(chips[1].getValue() < chips[0].getValue()){
               return chips[1];
            }

            return chips[0];
        }

        // bot has only one chip
        return chips[1] == null ? chips[1] : chips[0];
    }

    public Chip getHighValueShip(){
        // bot has no chips
        if(chips[0] == null && chips[1] == null){
            return null;
        }

        // bot has two chips
        if(chips[0] != null && chips[1] != null){
            if(chips[1].getValue() > chips[0].getValue()){
                return chips[1];
            }

            return chips[0];
        }

        // bot has only one chip
        return chips[1] == null ? chips[1] : chips[0];
    }

    public boolean hasToChips(){
        return chips[0] != null && chips[1] != null;
    }

}
