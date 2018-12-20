package main.java.com.olegsorokin;

import main.java.com.olegsorokin.interfaces.IContainer;

import java.util.ArrayList;

public class DoubleContainer implements IContainer<Matrix> {
    private ArrayList<Matrix> elements;
    private ArrayList<Matrix> fewElements;

    public DoubleContainer(ArrayList<Matrix> elements, ArrayList<Matrix> fewElements) {
        this.elements = elements;
        this.fewElements = fewElements;
    }

    @Override
    public int indexOf(Matrix object) {
        return elements.indexOf(object);
    }

    @Override
    public Matrix get(int index) {
        return fewElements.get(index);
    }

    @Override
    public int size() {
        return fewElements.size();
    }
}
