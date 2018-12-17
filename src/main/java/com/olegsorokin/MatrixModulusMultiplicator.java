package main.java.com.olegsorokin;

import main.java.com.olegsorokin.interfaces.IMultiplicator;

public class MatrixModulusMultiplicator implements IMultiplicator<Matrix> {
    private final float modulus;

    public MatrixModulusMultiplicator(float modulus) {
        this.modulus = modulus;
    }
    
    @Override
    public Matrix multiply(Matrix first, Matrix second) {
        return first.multiply(second).map((x) -> x % modulus);
    }
}
