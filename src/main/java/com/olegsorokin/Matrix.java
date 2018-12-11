package main.java.com.olegsorokin;

import java.util.Arrays;

public class Matrix {
    private int rows;
    private int columns;
    private float[] data;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        data = new float[rows * columns];

        for (int i = 0; i < rows * columns; i++) {
            data[i] = 0;
        }
    }

    public Matrix(float[] data, int rows, int columns) throws ArrayIndexOutOfBoundsException {
        if (data.length != rows * columns) {
            throw new ArrayIndexOutOfBoundsException("Array provided to Matrix constructor must have (columns * rows) elements!");
        }
        this.rows = rows;
        this.columns = columns;
        this.data = data;
    }

    public static Matrix multiply(Matrix a, Matrix b) throws ArrayIndexOutOfBoundsException {
        if (a.rows != b.columns) {
            throw new ArrayIndexOutOfBoundsException("Unable to multiply matrices, wrong matrices dimensions!");
        }
        Matrix result = new Matrix(a.rows, b.columns);
        for (int i = 0; i < a.rows; i++) {
            for (int j = 0; j < b.columns; j++) {
                for (int k = 0; k < a.columns; k++) {
                    result.data[j + i * b.columns] += a.data[k + i * a.columns] * b.data[j + k * b.columns];
                }
            }
        }
        return result;
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(data[j + i * columns]);
                System.out.print("   ");
            }
            System.out.println();
        }
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;

        if (!(other instanceof Matrix)) return false;

        Matrix matrix = (Matrix) other;

        return Arrays.equals(data, matrix.data) && rows == matrix.rows && columns == matrix.columns;
    }
}