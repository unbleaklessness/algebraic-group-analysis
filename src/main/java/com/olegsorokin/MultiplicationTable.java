package main.java.com.olegsorokin;

import main.java.com.olegsorokin.interfaces.IMultiplicator;
import main.java.com.olegsorokin.utils.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class MultiplicationTable {
    private int[][] table;
    private int size;

    private MultiplicationTable() {}

    public <T> MultiplicationTable(final ArrayList<T> elements, final IMultiplicator<T> multiplicator) {
        size = elements.size();
        table = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = elements.indexOf(multiplicator.multiply(elements.get(i), elements.get(j)));
            }
        }
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

    public ArrayList<Integer> getEquivalents(int identity) {
        if (identity > size || identity < 0) {
            return new ArrayList<>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Integer value = table[identity][i];
            if (!result.contains(value)) {
                result.add(i);
            }
        }
        return result;
    }

    public ArrayList<Integer> getCenter() {
        ArrayList<Integer> result = new ArrayList<>();
        boolean flag = true;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!(table[i][j] == table[j][i])) {
                    flag = false;
                }
            }
            if (flag == true) {
                result.add(i);
            }
            flag = true;
        }
        return result;
    }
}
