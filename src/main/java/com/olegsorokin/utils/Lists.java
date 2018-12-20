package main.java.com.olegsorokin.utils;

import java.util.ArrayList;

public class Lists {
    public static <T> void removeIndexes(ArrayList<Integer> indexes, ArrayList<T> list) {
        for (int i = indexes.size() - 1; i >= 0; i--) {
            list.remove((int) indexes.get(i));
        }
    }
}
