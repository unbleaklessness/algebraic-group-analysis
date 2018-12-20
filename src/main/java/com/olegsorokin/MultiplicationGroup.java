package main.java.com.olegsorokin;

import java.util.ArrayList;

public class MultiplicationGroup<T> {
    private ArrayList<T> elements;
    private MultiplicationTable<T> table;

    public MultiplicationGroup(ArrayList<T> elements, MultiplicationTable<T> table) {
        this.elements = elements;
        this.table = table;
    }

    public int tableMultiply(int first, int second) {
        return table.multiply(first, second);
    }

    public T elementMultiply(int first, int second) {
        return elements.get(table.multiply(first, second));
    }
}
