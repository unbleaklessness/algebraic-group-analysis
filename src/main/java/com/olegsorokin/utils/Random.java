package main.java.com.olegsorokin.utils;

public class Random {
    public static long randomLong(long min, long max) {
        return Math.round(Math.random() * ((max - min) + 1) + min);
    }

    public static int randomInt(int min, int max) {
        return (int) Math.round(Math.random() * ((max - min) + 1) + min);
    }

    public static int randomInt(int max) {
        return randomInt(0, max);
    }
}
