package main.java.com.olegsorokin.groups;

import main.java.com.olegsorokin.Matrix;
import main.java.com.olegsorokin.interfaces.IGroup;

import java.util.ArrayList;

public class Group168 implements IGroup {
    @Override
    public float getModulus() {
        return 7;
    }

    @Override
    public ArrayList<Matrix> getInitials() {
        ArrayList<Matrix> result = new ArrayList<>();
        result.add(new Matrix(new float[] {0, 3, 2, 4}, 2, 2));
        result.add(new Matrix(new float[] {0, 1, 6, 0}, 2, 2));
        result.add(new Matrix(new float[] {1, 1, 0, 1}, 2, 2));
        result.add(new Matrix(new float[] {3, 0, 0, 5}, 2, 2));
        return result;
    }
}
