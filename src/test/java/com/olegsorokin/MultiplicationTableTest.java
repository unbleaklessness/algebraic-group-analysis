package test.java.com.olegsorokin;

import main.java.com.olegsorokin.*;
import main.java.com.olegsorokin.groups.Group168;
import main.java.com.olegsorokin.interfaces.IGroup;
import main.java.com.olegsorokin.interfaces.IMultiplicator;
import main.java.com.olegsorokin.utils.Pair;
import main.java.com.olegsorokin.utils.Random;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class MultiplicationTableTest {
    private static IGroup group = new Group168();
    private static GroupGenerator<Matrix> generator = new GroupGenerator<>();
    private static IMultiplicator<Matrix> multiplicator = new MatrixModulusMultiplicator(group.getModulus());
    private static ArrayList<Matrix> elements = generator.generate(group.getInitials(), multiplicator);
    private static MultiplicationTable<Matrix> table = new MultiplicationTable<>(elements, multiplicator);

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
        int i1 = Random.randomInt(elements.size() - 1);
        int i2 = table.power(i1, 4);
        Matrix m1 =  elements.get(i1);
        Matrix m1p2 = multiplicator.multiply(m1, m1);
        Matrix m1p3 = multiplicator.multiply(m1p2, m1);
        Matrix m1p4 = multiplicator.multiply(m1p3, m1);
        Matrix m2 = elements.get(i2);
        Assert.assertEquals(m1p4, m2);
    }

    @Test
    public void Commutative_Test() {
        ArrayList<Pair<Integer, Integer>> commutative = table.getCommutative();

        for (final Pair<Integer, Integer> i : commutative) {
            int i1 = table.multiply(i.getFirst(), i.getSecond());
            int i2 = table.multiply(i.getSecond(), i.getFirst());
            Assert.assertEquals(i1, i2);

            Matrix m1 = multiplicator.multiply(elements.get(i.getFirst()), elements.get(i.getSecond()));
            Matrix m2 = multiplicator.multiply(elements.get(i.getSecond()), elements.get(i.getFirst()));
            Assert.assertEquals(m1, m2);
        }
    }

    @Test
    public void Neutrals_Test() {
        ArrayList<Integer> neutrals = table.getNeutrals();
        for (final Integer i : neutrals) {
            for (Integer j = 0; j < elements.size(); j++) {
                Assert.assertEquals(j, table.multiply(i, j));

                Matrix m1 = elements.get(j);
                Matrix m2 = elements.get(i);
                Matrix m3 = multiplicator.multiply(m1, m2);
                Assert.assertEquals(m3, m1);
            }
        }
    }

    @Test
    public void Inverses_Test() {
        ArrayList<Integer> neutrals = table.getNeutrals();
        for (final Integer i : neutrals) {
            ArrayList<Pair<Integer, Integer>> inverses = table.getInverses(i);
            for (final Pair<Integer, Integer> j : inverses) {
                Assert.assertEquals(table.multiply(j.getFirst(), j.getSecond()), i);
            }
        }
    }

    // TODO: Add test for orders.

    // TODO: Add test for equivalents.
}
