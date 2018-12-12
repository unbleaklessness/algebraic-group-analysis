package main.java.com.olegsorokin;

import java.util.ArrayList;
import java.util.HashSet;

public class GroupGenerator {
    public static ArrayList<Matrix> generate(float modulus, final ArrayList<Matrix> initials) throws Exception {
        HashSet<Matrix> current = new HashSet<>(initials);

        while (true) {
            HashSet<Matrix> next = new HashSet<>();

            for (final Matrix m1 : current) {
                for (final Matrix m2 : current) {
                    next.add(Matrix.modMultiply(modulus, m1, m2));
                }
            }

            if (current.equals(next)) {
                return new ArrayList<>(current);
            }

            current = next;
        }
    }
}
