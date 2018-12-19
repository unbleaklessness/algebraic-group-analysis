package main.java.com.olegsorokin;

import main.java.com.olegsorokin.interfaces.IMultiplicator;

public class MatrixMultiplicator implements IMultiplicator<Matrix> {
    private final float modulus;

    public MatrixMultiplicator(float modulus) {
        this.modulus = modulus;
    }
    
    @Override
    public Matrix multiply(final Matrix first, final Matrix second) {
        return first.multiply(second).map(x -> x % modulus);
    }
}
