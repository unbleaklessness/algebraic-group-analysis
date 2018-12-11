package test.java.com.olegsorokin;

import main.java.com.olegsorokin.Matrix;

import org.junit.Test;
import org.junit.Assert;

public class MatrixTest {
    @Test
    public void testMultiplication3x2() {
        Matrix m1 = new Matrix(new float[] {1, 2, 3, 4, 5, 6}, 3, 2);
        Matrix m2 = new Matrix(new float[] {6, 5, 4, 3, 2, 1}, 2, 3);
        Matrix m3 = Matrix.multiply(m1, m2);
        Matrix expected = new Matrix(new float[] {12, 9, 6, 30, 23, 16, 48, 37, 26}, 3,3);
        Assert.assertEquals(m3, expected);
    }

    @Test
    public void testMultiplication2() {
        Matrix m1 = new Matrix(new float[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, 3, 3);
        Matrix m2 = new Matrix(new float[] {9, 8, 7, 6, 5, 4, 3, 2, 1}, 3, 3);
        Matrix m3 = Matrix.multiply(m1, m2);
        Matrix expected = new Matrix(new float[] {30, 24, 18, 84, 69, 54, 138, 114, 90}, 3,3);
        Assert.assertEquals(m3, expected);
    }
}
