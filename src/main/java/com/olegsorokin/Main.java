package main.java.com.olegsorokin;

import main.java.com.olegsorokin.Matrix;
import main.java.com.olegsorokin.groups.Group168;
import main.java.com.olegsorokin.groups.IGroup;

class Main {
    public static void main(String[] args) throws Exception {
        IGroup group = new Group168();

        Matrix[] elements = Generator.generate(group.getModulus(), group.getInitials());
        for (Matrix a : elements) {
            a.print();
        }
    }
}