package main.java.com.olegsorokin;

import main.java.com.olegsorokin.groups.Group1024;
import main.java.com.olegsorokin.groups.Group168;
import main.java.com.olegsorokin.groups.IGroup;

import java.util.ArrayList;

class Main {
    public static void main(String[] args) throws Exception {
        IGroup group = new Group1024();

        ArrayList<Matrix> elements = Generator.generate(group.getModulus(), group.getInitials());
        for (Matrix a : elements) {
            a.print();
        }
        System.out.println(elements.size());
    }
}