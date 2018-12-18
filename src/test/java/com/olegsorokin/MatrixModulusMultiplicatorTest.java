package test.java.com.olegsorokin;

import main.java.com.olegsorokin.Matrix;
import main.java.com.olegsorokin.MatrixModulusMultiplicator;
import org.junit.Assert;
import org.junit.Test;

public class MatrixModulusMultiplicatorTest {
    @Test
    public void Multiply_3x2_By_2x3_Modulo_6() {
        MatrixModulusMultiplicator multiplicator = new MatrixModulusMultiplicator(6);
        Matrix m1 = new Matrix(new float[] {1, 12, -87, 32, 99, -5}, 3, 2);
        Matrix m2 = new Matrix(new float[] {54, -8, 11, -67, -11, 10}, 2, 3);
        Matrix actual = multiplicator.multiply(m1, m2);
        Matrix expected = new Matrix(new float[] {0, 4, 5, 4, 2, 5, 5, 1, 1}, 3, 3);
        Assert.assertEquals(actual, expected);
    }
}
