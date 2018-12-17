package main.java.com.olegsorokin;

import main.java.com.olegsorokin.groups.Group168;
import main.java.com.olegsorokin.interfaces.IGroup;
import main.java.com.olegsorokin.utils.Pair;

import java.util.ArrayList;

class Main {
    public static void main(String[] args) throws Exception {
        IGroup group = new Group168();

        MatrixModulusMultiplicator multiplicator = new MatrixModulusMultiplicator(group.getModulus());
        GroupGenerator<Matrix> generator = new GroupGenerator<>();

        ArrayList<Matrix> elements = generator.generate(group.getInitials(), multiplicator);
        System.out.println(elements.size());

        MultiplicationTable<Matrix> table = new MultiplicationTable<>(elements, multiplicator);

        ArrayList<Integer> neutrals = table.getNeutrals();
        for (final Integer x : neutrals) {
            System.out.println(x);
            elements.get(x).print();
        }

//        ArrayList<Pair<Integer, Integer>> inverses = table.getInverses(neutrals.get(0));
//        for (final Pair x : inverses) {
//            x.print();
//        }

//        ArrayList<Pair<Integer, Integer>> commutative = table.getCommutative();
//        for (final Pair x : commutative) {
//            x.println();
//        }
    }
}