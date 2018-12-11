package main.java.com.olegsorokin.groups;

import main.java.com.olegsorokin.Matrix;

public class Group168 implements IGroup {

    @Override
    public float getModulus() {
        return 7;
    }

    @Override
    public Matrix[] getInitials() throws Exception {
        return new Matrix[] {
                new Matrix(new float[] {0, 3, 2, 4}, 2, 2),
                new Matrix(new float[] {0, 1, 6, 0}, 2, 2),
                new Matrix(new float[] {1, 1, 0, 1}, 2, 2),
                new Matrix(new float[] {3, 0, 0, 5}, 2, 2),
        };
    }
}
