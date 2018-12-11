package main.java.com.olegsorokin;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Generator {
    public static Matrix[] generate(float modulus, final Matrix[] initials) throws Exception {
        Set<Matrix> current = new HashSet<>(Arrays.asList(initials));

        while (true) {
            Set<Matrix> next = new HashSet<>();

            for (Matrix m1 : current) {
                for (Matrix m2 : current) {
                    next.add(Matrix.modMultiply(modulus, m1, m2));
                }
            }

            if (current.equals(next)) {
                Matrix[] result = new Matrix[current.size()];
                return current.toArray(result);
            }

            current = next;
        }
    }
}
