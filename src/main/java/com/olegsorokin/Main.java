package main.java.com.olegsorokin;

import main.java.com.olegsorokin.groups.Group168;
import main.java.com.olegsorokin.interfaces.IGroup;
import main.java.com.olegsorokin.utils.Lists;
import main.java.com.olegsorokin.utils.Pair;

import java.util.ArrayList;

class Main {
    public static void main(String[] args) throws Exception {
        IGroup group = new Group168();

        MatrixModulusMultiplicator multiplicator = new MatrixModulusMultiplicator(group.getModulus());
        GroupGenerator<Matrix> generator = new GroupGenerator<>();

        ArrayList<Matrix> elements = generator.generate(group.getInitials(), multiplicator);
        MultiplicationTable<Matrix> table = new MultiplicationTable<>(new CommonContainer(elements), multiplicator);

        float ax = group.getModulus() - 1;
        int lm = elements.get(0).getRows();
        Integer identity2 = elements.indexOf(new Matrix(new float[] {ax, 0, 0, ax}, lm, lm));

        ArrayList<Integer> equivalents = table.getEquivalents(identity2);
        ArrayList<Integer> neutrals = table.getNeutrals();
        ArrayList<Pair<Integer, Integer>> inverses = table.getInverses(neutrals.get(0));
        ArrayList<Pair<Integer, Integer>> commutative = table.getCommutative();
        ArrayList<Pair<Integer, Integer>> orders = table.getOrders(neutrals.get(0));

        ////////////////////////////////////////////////////////////////////

        ArrayList<Matrix> uniqueElements = new ArrayList<>(elements);
        Lists.removeIndexes(equivalents, uniqueElements);

        DoubleContainer doubleContainer = new DoubleContainer(elements, uniqueElements);
        MultiplicationTable<Matrix> uniqueTable = new MultiplicationTable<>(doubleContainer, multiplicator);

        ArrayList<Integer> uNeutrals = uniqueTable.getNeutrals();
        ArrayList<Pair<Integer, Integer>> uInverses = uniqueTable.getInverses(uNeutrals.get(0));
        ArrayList<Pair<Integer, Integer>> uCommutative = uniqueTable.getCommutative();
        ArrayList<Pair<Integer, Integer>> uOrders = uniqueTable.getOrders(uNeutrals.get(0));

        uCommutative.get(0).print();
    }
}