package main.java.com.olegsorokin;

import main.java.com.olegsorokin.interfaces.IContainer;

import java.util.ArrayList;

public class CommonContainer implements IContainer<Matrix> {
    private ArrayList<Matrix> elements;

    public CommonContainer(ArrayList<Matrix> elements) {
        this.elements = elements;
    }

    @Override
    public int indexOf(Matrix object) {
        return elements.indexOf(object);
    }

    @Override
    public Matrix get(int index) {
        return elements.get(index);
    }

    @Override
    public int size() {
        return elements.size();
    }
}
