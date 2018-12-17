package main.java.com.olegsorokin;

import main.java.com.olegsorokin.interfaces.IMultiplicable;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

public class Matrix implements Comparator<Matrix>, Comparable<Matrix>, IMultiplicable<Matrix> {
    private int rows;
    private int columns;
    private float[] data;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        data = new float[rows * columns];
    }

    public Matrix(final float[] data, int rows, int columns) {
        if (data.length != rows * columns) {
            this.rows = 0;
            this.columns = 0;
            this.data = new float[0];
        } else {
            this.rows = rows;
            this.columns = columns;
            this.data = data;
        }
    }

    public Matrix multiply(final Matrix other) {
        if (rows != other.columns) {
            return new Matrix(0, 0);
        }
        Matrix result = new Matrix(rows, other.columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < other.columns; j++) {
                for (int k = 0; k < columns; k++) {
                    result.data[j + i * other.columns] += data[k + i * columns] * other.data[j + k * other.columns];
                }
            }
        }
        return result;
    }

    public Matrix power(final int n) {
        if (rows != columns) {
            return new Matrix(0, 0);
        }
        if (n < 0) {
            // TODO: Add support for negative powers.
            System.out.println("Raising a matrix in a negative power is not yet supported!");
            return new Matrix(0, 0);
        } else if (n == 0) {
            return identity(rows);
        }
        Matrix result = copy();
        for (int i = 1; i < n; i++) {
            result = result.multiply(this);
        }
        return result;
    }

    public static Matrix identity(int size) {
        Matrix result = new Matrix(size, size);
        int index = 0;
        for (int i = 0; i < size; i++) {
            result.data[index] = 1;
            index += size + 1;
        }
        return result;
    }

    public Matrix copy() {
        Matrix result = new Matrix(rows, columns);
        for (int i = 0; i < rows * columns; i++) {
            result.data[i] = data[i];
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
    }

    public Matrix map(Function<Float, Float> function) {
        Matrix result = new Matrix(rows, columns);
        for (int i = 0; i < rows * columns; i++) {
            result.data[i] = function.apply(data[i]);
        }
        return result;
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