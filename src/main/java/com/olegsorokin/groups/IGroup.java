package main.java.com.olegsorokin.groups;

import main.java.com.olegsorokin.Matrix;

import java.util.ArrayList;

public interface IGroup {
    float getModulus();
    ArrayList<Matrix> getInitials() throws Exception;
}
