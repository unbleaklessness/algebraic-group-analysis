package main.java.com.olegsorokin;

import java.util.ArrayList;
import java.util.Collections;

public class Generator {
    public static ArrayList<Matrix> generate(float modulus, final ArrayList<Matrix> initials) throws Exception {
        ArrayList<Matrix> current = initials;

        while (true) {
            ArrayList<Matrix> next = new ArrayList<>();

            for (Matrix m1 : current) {
                for (Matrix m2 : current) {
                    Matrix m = Matrix.modMultiply(modulus, m1, m2);
                    if (!next.contains(m)) {
                        next.add(m);
                    }
                }
            }

            Collections.sort(current);
            Collections.sort(next);
            if (current.equals(next)) {
                return current;
            }

            current = next;
        }
    }
}
