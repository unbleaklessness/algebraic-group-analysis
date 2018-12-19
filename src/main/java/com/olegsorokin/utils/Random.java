package main.java.com.olegsorokin.utils;

import java.lang.Math;

public class Random {
    public static int randomInt(int min, int max) {
        return (int) Math.round(Math.random() * (max - min) + min);
    }

    public static int randomInt(int max) {
        return randomInt(0, max);
    }
}
