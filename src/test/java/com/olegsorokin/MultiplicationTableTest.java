package test.java.com.olegsorokin;

import main.java.com.olegsorokin.*;
import main.java.com.olegsorokin.groups.Group1092;
import main.java.com.olegsorokin.interfaces.IGroup;
import main.java.com.olegsorokin.interfaces.IMultiplicator;
import main.java.com.olegsorokin.utils.Pair;
import main.java.com.olegsorokin.utils.Random;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class MultiplicationTableTest {
    private static IGroup group = new Group1092();
    private static GroupGenerator<Matrix> generator = new GroupGenerator<>();
    private static IMultiplicator<Matrix> multiplicator = new MatrixModulusMultiplicator(group.getModulus());
    private static ArrayList<Matrix> elements = generator.generate(group.getInitials(), multiplicator);
    private static MultiplicationTable table = new MultiplicationTable(elements, multiplicator);

    @Test
    public void Table_Multiplication_VS_Matrix_Multiplication() {
        for (int i = 0; i < elements.size(); i++) {
            int i1 = Random.randomInt(elements.size() - 1);
            int i2 = Random.randomInt(elements.size() - 1);
            int i3 = table.multiply(i1, i2);
            Matrix r1 = multiplicator.multiply(elements.get(i1), elements.get(i2));
            Matrix r2 = elements.get(i3);
            Assert.assertEquals(r1, r2);
        }
    }

    @Test
    public void Table_Power_VS_Matrix_Power() {
        for (int i = 0; i < elements.size(); i++) {
            int power = Random.randomInt(3, 7);
            Matrix actual = elements.get(table.power(i, power));
            Matrix original = elements.get(i);
            Matrix expected = original;
            for (int j = 1; j < power; j++) {
                expected = multiplicator.multiply(expected, original);
            }
            Assert.assertEquals(actual, expected);
        }
    }

    @Test
    public void Commutative_Test() {
        ArrayList<Pair<Integer, Integer>> commutative = table.getCommutative();
        for (final Pair<Integer, Integer> i : commutative) {
            Matrix m1 = elements.get(i.getFirst());
            Matrix m2 = elements.get(i.getSecond());
            Matrix first = multiplicator.multiply(m1, m2);
            Matrix second = multiplicator.multiply(m2, m1);
            Assert.assertEquals(first, second);
        }
    }

    @Test
    public void Neutrals_Test() {
        ArrayList<Integer> neutrals = table.getNeutrals();
        for (final Integer i : neutrals) {
            for (final Matrix expected : elements) {
                Matrix neutral = elements.get(i);
                Matrix actual = multiplicator.multiply(expected, neutral);
                Assert.assertEquals(actual, expected);
            }
        }
    }

    @Test
    public void Inverses_Test() {
        ArrayList<Integer> neutrals = table.getNeutrals();
        for (final Integer i : neutrals) {
            ArrayList<Pair<Integer, Integer>> inverses = table.getInverses(i);
            for (final Pair<Integer, Integer> j : inverses) {
                Matrix m1 = elements.get(j.getFirst());
                Matrix m2 = elements.get(j.getSecond());
                Matrix actual = multiplicator.multiply(m1, m2);
                Matrix expected = elements.get(i);
                Assert.assertEquals(actual, expected);
            }
        }
    }

    @Test
    public void Orders_Test() {
        ArrayList<Integer> neutrals = table.getNeutrals();
        for (final Integer i : neutrals) {
            ArrayList<Pair<Integer, Integer>> orders = table.getOrders(i);
            for (final Pair<Integer, Integer> j : orders) {
                Matrix m = elements.get(j.getFirst());
                Matrix actual = m;
                for (int k = 1; k < j.getSecond(); k++) {
                    actual = multiplicator.multiply(actual, m);
                }
                Matrix expected = elements.get(i);
                Assert.assertEquals(actual, expected);
            }
        }
    }

    // TODO: Add test for equivalents.
}
