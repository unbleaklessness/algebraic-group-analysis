package main.java.com.olegsorokin;

import java.util.ArrayList;

public class MultiplicationTable<T> implements IMultiplicator<Integer> {
    private Integer[][] table;
    private ArrayList<T> elements;

    public MultiplicationTable(final ArrayList<T> elements, final IMultiplicator<T> multiplicator) {
        int size = elements.size();

        table = new Integer[size][size];
        this.elements = elements;

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

    public T getElement(int n) {
        return elements.get(n);
    }

    public int size() {
        return table.length;
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
}
