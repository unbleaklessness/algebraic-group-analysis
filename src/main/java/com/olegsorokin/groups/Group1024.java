package main.java.com.olegsorokin.groups;

import main.java.com.olegsorokin.Matrix;
import main.java.com.olegsorokin.interfaces.IGroup;

import java.util.ArrayList;

public class Group1024 implements IGroup {
    @Override
    public float getModulus() {
        return 13;
    }

    @Override
    public ArrayList<Matrix> getInitials() {
        ArrayList<Matrix> result = new ArrayList<>();
        result.add(new Matrix(new float[] {2, 0, 0, 7}, 2, 2));
        result.add(new Matrix(new float[] {0, 5, 5, 3}, 2, 2));
        result.add(new Matrix(new float[] {1, 1, 0, 1}, 2, 2));
        result.add(new Matrix(new float[] {0, 1, 12, 0}, 2, 2));
        result.add(new Matrix(new float[] {2, 2, 3, 10}, 2, 2));
        return result;
    }
}
