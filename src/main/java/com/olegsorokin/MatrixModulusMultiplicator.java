package main.java.com.olegsorokin;

import main.java.com.olegsorokin.interfaces.IMultiplicator;
import main.java.com.olegsorokin.utils.Math;

public class MatrixModulusMultiplicator implements IMultiplicator<Matrix> {
    private final float modulus;

    public MatrixModulusMultiplicator(float modulus) {
        this.modulus = modulus;
    }
    
    @Override
    public Matrix multiply(Matrix first, Matrix second) {
        return first.multiply(second).map(x -> Math.mod(x, modulus));
    }

    public Matrix power(Matrix matrix, Integer power) {
        return matrix.power(power).map(x -> Math.mod(x, modulus));
    }
}
