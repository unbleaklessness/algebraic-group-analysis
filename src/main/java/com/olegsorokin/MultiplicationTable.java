package main.java.com.olegsorokin;

import java.util.ArrayList;

public class MultiplicationTable {
    private int[][] table;
    private ArrayList<Matrix> elements;

    public MultiplicationTable(float modulus, final ArrayList<Matrix> matrices) throws Exception {
        int size = matrices.size();
        table = new int[size][size];
        elements = matrices;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Matrix m = Matrix.modMultiply(modulus, matrices.get(i), matrices.get(j));
                table[i][j] = matrices.indexOf(m);
            }
        }
    }

    public int multiply(int row, int column) {
        return table[row][column];
    }

    public Matrix getMatrix(int n) {
        return elements.get(n);
    }

    public void print() {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(table[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
