package main.java.com.olegsorokin;

import main.java.com.olegsorokin.groups.Group168;
import main.java.com.olegsorokin.groups.IGroup;
import main.java.com.olegsorokin.utils.Pair;

import java.util.ArrayList;

class Main {
    public static void main(String[] args) throws Exception {
        IGroup group = new Group168();

        MatrixModMultiplicator multiplicator = new MatrixModMultiplicator(group.getModulus());
        GroupGenerator<Matrix> generator = new GroupGenerator<>();

        ArrayList<Matrix> elements = generator.generate(group.getInitials(), multiplicator);
        System.out.println(elements.size());

        MultiplicationTable<Matrix> table = new MultiplicationTable<>(elements, multiplicator);
        MultiplicationTableAnalyser analyser = new MultiplicationTableAnalyser(table);

        ArrayList<Pair<Integer, Integer>> commutatives = analyser.getCommutatives();
        for (final Pair<Integer, Integer> x : commutatives) {
            x.println();
        }
    }
}