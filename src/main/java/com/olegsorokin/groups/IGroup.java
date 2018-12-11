package main.java.com.olegsorokin.groups;

import main.java.com.olegsorokin.Matrix;

public interface IGroup {
    float getModulus();
    Matrix[] getInitials() throws Exception;
}
