package main.java.com.olegsorokin;

import main.java.com.olegsorokin.interfaces.IMultiplicator;
import main.java.com.olegsorokin.utils.Pair;
import main.java.com.olegsorokin.utils.Pairs;
import main.java.com.olegsorokin.utils.Random;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MultiplicationTable {
    private int[][] table;
    private int size;
    public Integer identity2Index;

//    public <T> MultiplicationTable(final List<T> elements, final IMultiplicator<T> multiplicator) {
//        size = elements.size();
//        table = new int[size][size];
//
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//                table[i][j] = elements.indexOf(multiplicator.multiply(elements.get(i), elements.get(j)));
//            }
//        }
//    }
    
    private <T> MultiplicationTable(Integer tableSize) {
        size = tableSize;
        table = new int[size][size];
    }
    
    public static <T> MultiplicationTable createTable(final List<T> elements, final IMultiplicator<T> multiplicator) {
    	MultiplicationTable result = new MultiplicationTable(elements.size());

        for (int i = 0; i < result.size; i++) {
            for (int j = 0; j < result.size; j++) {
            	result.table[i][j] = elements.indexOf(multiplicator.multiply(elements.get(i), elements.get(j)));
            }
        }
        
        return result;
    }
    
    public static <T> MultiplicationTable createUniqueTable(final List<T> elements, final IMultiplicator<T> multiplicator, final T identity2) {
    	ArrayList<Pair<T, T>> equivalentMatrices = new ArrayList<>();
        
        ArrayList<T> banned = new ArrayList<>();
        for (T element : elements) {
        	T equivalent = multiplicator.multiply(element, identity2);
            
            if (banned.contains(element) || banned.contains(equivalent)) {
            	continue;
            }
            banned.add(element);
            banned.add(equivalent);
            
            equivalentMatrices.add(new Pair<>(element, equivalent));
        }
        
        MultiplicationTable result = new MultiplicationTable(equivalentMatrices.size());
        
	    for (int i = 0; i < equivalentMatrices.size(); i++) {
		    for (int j = 0; j < equivalentMatrices.size(); j++) {
		    	T multiplication = multiplicator.multiply(equivalentMatrices.get(i).getFirst(), equivalentMatrices.get(j).getFirst());
		    	result.table[i][j] = Pairs.indexOfInBoth(multiplication, equivalentMatrices);
		    }
		}
        
        return result;
    }

    public Integer multiply(Integer index1, Integer index2) {
        if (index1 > size || index1 < 0 || index2 > size || index2 < 0) {
            return -1;
        }
        return table[index1][index2];
    }

    public Integer power(Integer element, Integer n) {
        if (element > size || element < 0 || n <= 0) {
            return -1;
        }
        Integer result = element;
        for (int i = 1; i < n; i++) {
            result = table[result][element];
        }
        return result;
    }

    public int size() {
        return size;
    }

    public void print() {
        for (final int[] row : table) {
            for (final int element : row) {
                System.out.print(element);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public ArrayList<Pair<Integer, Integer>> getCommutative() {
        ArrayList<Pair<Integer, Integer>> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (table[i][j] == table[j][i]) {
                    result.add(new Pair<>(i, j));
                }
            }
        }
        return result;
    }

    public ArrayList<Integer> getNeutrals() {
        ArrayList<Integer> result = new ArrayList<>();
        boolean flag = true;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!(table[i][j] == j)) {
                    flag = false;
                }
            }
            if (flag) {
                result.add(i);
            }
            flag = true;
        }
        return result;
    }

    public ArrayList<Pair<Integer, Integer>> getInverses(int neutral) {
        if (neutral > size || neutral < 0) {
            return new ArrayList<>();
        }
        ArrayList<Pair<Integer, Integer>> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (table[i][j] == neutral) {
                    result.add(new Pair<>(i, j));
                }
            }
        }
        return result;
    }

    public ArrayList<Pair<Integer, Integer>> getOrders(int neutral) {
        if (neutral > size || neutral < 0) {
            return new ArrayList<>();
        }
        ArrayList<Pair<Integer, Integer>> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (power(i, j) == neutral) {
                    result.add(new Pair<>(i, j));
                    break;
                }
            }
        }
        return result;
    }

//    public ArrayList<Integer> getEquivalents(int identity) {
//        if (identity > size || identity < 0) {
//            return new ArrayList<>();
//        }
//        ArrayList<Integer> result = new ArrayList<>();
//        for (int i = 0; i < size; i++) {
//            Integer value = table[identity][i];
//            if (!result.contains(value)) {
//                result.add(i);
//            }
//        }
//        return result;
//    }

    public ArrayList<Integer> getCenter() {
        ArrayList<Integer> result = new ArrayList<>();
        boolean flag = true;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!(table[i][j] == table[j][i])) {
                    flag = false;
                }
            }
            if (flag) {
                result.add(i);
            }
            flag = true;
        }
        return result;
    }

    public ArrayList<Integer> conjugate(Integer element, final List<Pair<Integer, Integer>> inverses) {
        if (element > size || element < 0) {
            return new ArrayList<>();
        }
        HashSet<Integer> result = new HashSet<>();
        for (int i = 0; i < size; i++) {
            ArrayList<Integer> iInverses = Pairs.getSecondForFirst(i, inverses);
            if (iInverses.size() != 0) {
                Integer inverse = iInverses.get(0);
                Integer value = table[table[inverse][element]][i];
                result.add(value);
            }
        }
        return new ArrayList<>(result);
    }

    private ArrayList<Integer> getSequence() {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(i);
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> getConjugacyClasses(final List<Pair<Integer, Integer>> inverses) {
        if (inverses.size() == 0) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> original = getSequence();
       
        
        int counter = 0;
        while (true) {
            if (original.size() == 0) {
                return result;
            }
            
//            ArrayList<ArrayList<Integer>> conjugationVariants = new ArrayList<>();
//            for (int i : original) {
//                ArrayList<Integer> conjugations = conjugate(i, inverses);
//                conjugationVariants.add(conjugations);
//            }
//            
////            System.out.print("#");
////            System.out.print(counter);
////            System.out.print(" (length: ");
////            System.out.print(conjugationVariants.size());
////            System.out.println(") ");
////            counter++;
//            
//            System.out.format("Length: %d \n", original.size());
//            
//            int min = 100000;
//            int index = -1;
//            for (int i = 0; i < conjugationVariants.size(); i++) {
//                if (conjugationVariants.get(i).size() < min) {
//                    min = conjugationVariants.get(i).size();
//                    index = i;
//                }
//            }
//            original.removeAll(conjugationVariants.get(index));
//            result.add(conjugationVariants.get(index));
            
            Integer rnd = Random.randomInt(original.size() - 1);
            ArrayList<Integer> conjugations = conjugate(original.get(rnd), inverses);
            
            System.out.format("N: %d \n", counter);
            System.out.format("rnd: %d \n", rnd);
            System.out.format("Length: %d \n", original.size());
            
            original.removeAll(conjugations);
            result.add(conjugations);
        }
    }
}
