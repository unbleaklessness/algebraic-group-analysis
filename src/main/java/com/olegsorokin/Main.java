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

//        Matrix identity1M = Matrix.identity(2);
        Matrix identity2M = Matrix.identity(2).map(x -> x * (group.getModulus() - 1));
        
        ArrayList<Matrix> elements = generator.generate(group.getInitials(), multiplicator);
        MultiplicationTable table = MultiplicationTable.createUniqueTable(elements, multiplicator, identity2M);
        
//        Integer identity1 = elements.indexOf(identity1M);
//        Integer identity2 = elements.indexOf(identity2M);
        
//        UniqueMultiplicationTable table2 = new UniqueMultiplicationTable(elements, multiplicator, identity2M);
//        System.out.println(table2.equivalents.size());
//        ArrayList<Integer> center2 = table2.getCenter();
//        ArrayList<Pair<Integer, Integer>> commutative2 = table2.getCommutative();
        
//        elements.get(table2.equivalents.get(0).getFirst()).print();
//        elements.get(table2.equivalents.get(0).getSecond()).print();
        
//        ArrayList<Integer> equivalents = table.getEquivalents(identity2);
        ArrayList<Integer> neutrals = table.getNeutrals();
        ArrayList<Pair<Integer, Integer>> inverses = table.getInverses(neutrals.get(0));
        ArrayList<Pair<Integer, Integer>> commutative = table.getCommutative();
        ArrayList<Pair<Integer, Integer>> orders = table.getOrders(neutrals.get(0));
        ArrayList<Integer> center = table.getCenter();
        ArrayList<ArrayList<Integer>> conjugacyClasses = table.getConjugacyClasses(inverses);

//        System.out.println(inverses.size());
//        System.out.println(commutative2.size());
        
        int counter = 1;
        for (final ArrayList<Integer> cls : conjugacyClasses) {
            System.out.print(counter);
            System.out.print(": ");
            for (final Integer x : cls) {
                System.out.print(x);
                System.out.print(" ");
            }
            System.out.println();
            counter++;
        }
    }
}