package test.java.com.olegsorokin;

import org.junit.Test;
import org.junit.Assert;

import main.java.com.olegsorokin.Matrix;

public class MatrixTest {
    @Test
    public void Multiply_3x2_By_2x3() {
        Matrix m1 = new Matrix(new float[] {1, 2, 3, 4, 5, 6}, 3, 2);
        Matrix m2 = new Matrix(new float[] {6, 5, 4, 3, 2, 1}, 2, 3);
        Matrix actual = m1.multiply(m2);
        Matrix expected = new Matrix(new float[] {12, 9, 6, 30, 23, 16, 48, 37, 26}, 3,3);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void Multiply_3x3_By_3x3() {
        Matrix m1 = new Matrix(new float[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, 3, 3);
        Matrix m2 = new Matrix(new float[] {9, 8, 7, 6, 5, 4, 3, 2, 1}, 3, 3);
        Matrix actual = m1.multiply(m2);
        Matrix expected = new Matrix(new float[] {30, 24, 18, 84, 69, 54, 138, 114, 90}, 3,3);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void Matrix_3x3_In_Power_0() {
        Matrix m = new Matrix(new float[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, 3, 3);
        Matrix actual = m.power(0);
        Assert.assertEquals(Matrix.identity(3), actual);
    }

    @Test
    public void Matrix_3x3_In_Power_1() {
        Matrix m = new Matrix(new float[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, 3, 3);
        Matrix actual = m.power(1);
        Assert.assertEquals(m, actual);
    }

    @Test
    public void Matrix_3x3_In_Power_3() {
        Matrix m = new Matrix(new float[] {5, 6, 7, 1, 9, 3, 2, 5, 4}, 3, 3);
        Matrix actual = m.power(3);
        Matrix expected = new Matrix(new float[] {506, 1746, 996, 294, 1268, 630, 282, 1056, 572}, 3, 3);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void Non_Square_2x3_Matrix_In_Power_3() {
        Matrix m = new Matrix(new float[] {5, 6, 7, 1, 9, 3}, 2, 3);
        Matrix actual = m.power(3);
        Assert.assertEquals(new Matrix(0, 0), actual);
    }

    @Test
    public void Identity_1x1() {
        Matrix m = Matrix.identity(1);
        Matrix expected = new Matrix(new float[] {1}, 1, 1);
        Assert.assertEquals(m, expected);
    }

    @Test
    public void Identity_2x2() {
        Matrix m = Matrix.identity(2);
        Matrix expected = new Matrix(new float[] {1, 0, 0, 1}, 2, 2);
        Assert.assertEquals(m, expected);
    }

    @Test
    public void Identity_3x3() {
        Matrix m = Matrix.identity(3);
        Matrix expected = new Matrix(new float[] {1, 0, 0, 0, 1, 0, 0, 0, 1}, 3, 3);
        Assert.assertEquals(m, expected);
    }
}
