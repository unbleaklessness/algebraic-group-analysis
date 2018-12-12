package main.java.com.olegsorokin;

import java.util.ArrayList;
import java.util.HashSet;

public class GroupGenerator {
    public static HashSet<Matrix> generate(float modulus, final ArrayList<Matrix> initials) throws Exception {
        HashSet<Matrix> current = new HashSet<>(initials);

        while (true) {
            HashSet<Matrix> next = new HashSet<>();

            for (Matrix m1 : current) {
                for (Matrix m2 : current) {
                    next.add(Matrix.modMultiply(modulus, m1, m2));
                }
            }

            if (current.equals(next)) {
                return current;
            }

            current = next;
        }
    }
}
