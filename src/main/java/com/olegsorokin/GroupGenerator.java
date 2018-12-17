package main.java.com.olegsorokin;

import main.java.com.olegsorokin.interfaces.IMultiplicable;
import main.java.com.olegsorokin.interfaces.IMultiplicator;

import java.util.ArrayList;
import java.util.HashSet;

public class GroupGenerator<T> {
    public ArrayList<T> generate(final ArrayList<T> initials, final IMultiplicator<T> multiplicator) {
        HashSet<T> current = new HashSet<>(initials);

        while (true) {
            HashSet<T> next = new HashSet<>();

            for (final T m1 : current) {
                for (final T m2 : current) {
                    next.add(multiplicator.multiply(m1, m2));
                }
            }

            if (current.equals(next)) {
                return new ArrayList<>(current);
            }

            current = next;
        }
    }
}
