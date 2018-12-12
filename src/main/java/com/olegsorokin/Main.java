package main.java.com.olegsorokin;

import main.java.com.olegsorokin.groups.Group1024;
import main.java.com.olegsorokin.groups.IGroup;

import java.util.HashSet;

class Main {
    public static void main(String[] args) throws Exception {
        IGroup group = new Group1024();

        HashSet<Matrix> elements = GroupGenerator.generate(group.getModulus(), group.getInitials());
        System.out.println(elements.size());
    }
}