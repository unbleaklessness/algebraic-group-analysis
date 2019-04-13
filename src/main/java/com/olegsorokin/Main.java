package main.java.com.olegsorokin;

import main.java.com.olegsorokin.groups.Group1092;
import main.java.com.olegsorokin.groups.Group168;
import main.java.com.olegsorokin.interfaces.IGroup;
import main.java.com.olegsorokin.utils.Pair;

import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        IGroup group = new Group1092();

        MatrixModulusMultiplicator multiplicator = new MatrixModulusMultiplicator(group.getModulus());
        GroupGenerator<Matrix> generator = new GroupGenerator<>();

        Matrix identity1M = Matrix.identity(2);
        Matrix identity2M = Matrix.identity(2).map(x -> x * (group.getModulus() - 1));
        
        ArrayList<Matrix> elements = generator.generate(group.getInitials(), multiplicator);
        MultiplicationTable table = MultiplicationTable.createUniqueTable(elements, multiplicator, identity2M);
        
//        ArrayList<Integer> equivalents = table.getEquivalents(identity2);
        ArrayList<Integer> neutrals = table.getNeutrals();
        ArrayList<Pair<Integer, Integer>> inverses = table.getInverses(neutrals.get(0));
//        ArrayList<Pair<Integer, Integer>> commutative = table.getCommutative();
//        ArrayList<Pair<Integer, Integer>> orders = table.getOrders(neutrals.get(0));
//        ArrayList<Integer> center = table.getCenter();
        ArrayList<ArrayList<Integer>> conjugacyClasses = table.getConjugacyClasses(inverses);
        
        int counter = 1;
        for (final ArrayList<Integer> cls : conjugacyClasses) {
        	System.out.format("%d (Length: %d): ", counter, cls.size());
            for (final Integer x : cls) {
                System.out.format("%d ", x);
            }
            System.out.println();
            counter++;
        }
    }
}