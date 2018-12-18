package main.java.com.olegsorokin.utils;

public class Math {
    public static float mod(float value, float modulus) {
        return (((value % modulus) + modulus) % modulus);
    }
}
