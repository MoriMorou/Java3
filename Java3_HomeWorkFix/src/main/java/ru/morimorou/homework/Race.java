package ru.morimorou.homework;

import java.util.ArrayList;
import java.util.Arrays;

public class Race {
    private ArrayList<Stage> stages;
    public ArrayList<Stage> getStages() { return stages; }
    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }

//    public boolean winner = false;
//
//    public boolean hasWinner() {
//        return winner;
//    }
//    public void setWinner() {
//        winner = true;
//    }
}
