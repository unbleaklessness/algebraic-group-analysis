package main.java.com.olegsorokin;

import main.java.com.olegsorokin.interfaces.IMultiplicator;
<<<<<<< Updated upstream
import main.java.com.olegsorokin.utils.Pair;
=======
>>>>>>> Stashed changes

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class MultiplicationTable<T> implements IMultiplicator<Integer> {
    private int[][] table;
    private int size;

    public MultiplicationTable(final ArrayList<T> elements, final IMultiplicator<T> multiplicator) {
        size = elements.size();
        table = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = elements.indexOf(multiplicator.multiply(elements.get(i), elements.get(j)));
            }
        }
    }

    @Override
    public Integer multiply(Integer row, Integer column) {
        return table[row][column];
    }

    public Integer power(Integer element, Integer n) {
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
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(table[i][j]);
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
        int[] row = IntStream.range(0, size).toArray();
        for (int i = 0; i < size; i++) {
            if (Arrays.equals(table[i], row)) {
                result.add(i);
            }
        }
        return result;
    }

    public ArrayList<Pair<Integer, Integer>> getInverses(int neutral) {
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

    /**
     * Get orders of elements.
     * @param neutral Index of the neutral element.
     * @return Pairs where first value is an element and second value is it's order.
     */
    public ArrayList<Pair<Integer, Integer>> getOrders(int neutral) {
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

    /**
     * Get pairs of equivalent elements.
     * @param identity Index of identity matrix. Equivalence will be calculated with respect to this matrix.
     * @return Pair of equivalent elements.
     */
    public ArrayList<Integer> getEquivalents(int identity) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Integer value = table[identity][i];
            if (!result.contains(value)) {
                result.add(i);
            }
        }
        return result;
    }
}
