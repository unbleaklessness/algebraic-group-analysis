package main.java.com.olegsorokin;

import main.java.com.olegsorokin.groups.Group168;
import main.java.com.olegsorokin.interfaces.IGroup;
import main.java.com.olegsorokin.utils.Pair;

import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        IGroup group = new Group168();

        MatrixModulusMultiplicator multiplicator = new MatrixModulusMultiplicator(group.getModulus());
        GroupGenerator<Matrix> generator = new GroupGenerator<>();

        ArrayList<Matrix> elements = generator.generate(group.getInitials(), multiplicator);
        MultiplicationTable table = new MultiplicationTable(elements, multiplicator);

        Integer identity2 = elements.indexOf(Matrix.identity(2).map(x -> x * group.getModulus() - 1));

        ArrayList<Integer> equivalents = table.getEquivalents(identity2);
        ArrayList<Integer> neutrals = table.getNeutrals();
        ArrayList<Pair<Integer, Integer>> inverses = table.getInverses(neutrals.get(0));
        ArrayList<Pair<Integer, Integer>> commutative = table.getCommutative();
        ArrayList<Pair<Integer, Integer>> orders = table.getOrders(neutrals.get(0));
        ArrayList<Integer> center = table.getCenter();
    }
}