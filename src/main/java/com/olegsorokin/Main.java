package main.java.com.olegsorokin;

import main.java.com.olegsorokin.groups.Group168;
import main.java.com.olegsorokin.groups.IGroup;

import java.util.ArrayList;

class Main {
    public static void main(String[] args) throws Exception {
        IGroup group = new Group168();

        ArrayList<Matrix> elements = GroupGenerator.generate(group.getModulus(), group.getInitials());
        System.out.println(elements.size());

        MultiplicationTable table = new MultiplicationTable(group.getModulus(), elements);
        table.print();
    }
}