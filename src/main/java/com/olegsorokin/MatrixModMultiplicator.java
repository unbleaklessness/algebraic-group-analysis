package main.java.com.olegsorokin;

public class MatrixModMultiplicator implements IMultiplicator<Matrix> {
    private final float modulus;

    public MatrixModMultiplicator(float modulus) {
        this.modulus = modulus;
    }
    
    @Override
    public Matrix multiply(Matrix first, Matrix second) {
        return first.multiply(second).map((x) -> x % modulus);
    }
}
