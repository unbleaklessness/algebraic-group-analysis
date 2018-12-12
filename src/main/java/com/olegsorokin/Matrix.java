package main.java.com.olegsorokin;

import java.util.Arrays;
import java.util.Comparator;

public class Matrix implements Comparator<Matrix>, Comparable<Matrix> {
    private int rows;
    private int columns;
    private float[] data;

    public Matrix(int rows, int columns) throws Exception {
        if (rows == 0 || columns == 0) {
            throw new Exception("Passed zero value as number of rows/columns to Matrix constructor.");
        }
        this.rows = rows;
        this.columns = columns;
        data = new float[rows * columns];
    }

    public Matrix(final float[] data, int rows, int columns) throws Exception {
        if (rows == 0 || columns == 0) {
            throw new Exception("Passed zero value as number of rows/columns to Matrix constructor.");
        }
        if (data.length != rows * columns) {
            throw new Exception("Array provided to Matrix constructor must have (rows * columns) elements.");
        }
        this.rows = rows;
        this.columns = columns;
        this.data = data;
    }

    public static Matrix multiply(final Matrix a, final Matrix b) throws Exception {
        if (a.rows != b.columns) {
            throw new Exception("Unable to multiply matrices, wrong matrices dimensions.");
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

    public static Matrix modMultiply(float modulus, final Matrix a, final Matrix b) throws Exception {
        Matrix result = multiply(a, b);
        for (int i = 0; i < result.rows * result.columns; i++) {
            result.data[i] %= modulus;
        }
        return result;
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(data[j + i * columns]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public int compare(final Matrix m1, final Matrix m2) {
        return Arrays.compare(m1.data, m2.data);
    }

    @Override
    public int compareTo(final Matrix other) {
        return Arrays.compare(data, other.data);
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) return true;

        if (!(other instanceof Matrix)) return false;

        Matrix matrix = (Matrix) other;

        return Arrays.equals(data, matrix.data) && rows == matrix.rows && columns == matrix.columns;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(data);
    }
}