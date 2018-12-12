package main.java.com.olegsorokin;

import main.java.com.olegsorokin.utils.Pair;

import java.util.ArrayList;

public class MultiplicationTableAnalyser {
    private MultiplicationTable table;

    public MultiplicationTableAnalyser(MultiplicationTable table) {
        this.table = table;
    }

    public ArrayList<Pair<Integer, Integer>> getCommutatives() {
        ArrayList<Pair<Integer, Integer>> result = new ArrayList<>();
        for (int i = 0; i < table.size(); i++) {
            for (int j = 0; j < table.size(); j++) {
                if (table.multiply(i, j) == table.multiply(j, i)) {
                    result.add(new Pair<>(i, j));
                }
            }
        }
        return result;
    }
}
