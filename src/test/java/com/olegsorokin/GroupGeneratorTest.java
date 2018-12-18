package test.java.com.olegsorokin;

import main.java.com.olegsorokin.GroupGenerator;
import main.java.com.olegsorokin.Matrix;
import main.java.com.olegsorokin.MatrixModulusMultiplicator;
import main.java.com.olegsorokin.groups.Group168;
import main.java.com.olegsorokin.interfaces.IGroup;
import main.java.com.olegsorokin.interfaces.IMultiplicator;
import main.java.com.olegsorokin.utils.Random;

import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;

public class GroupGeneratorTest {
    private static IGroup group = new Group168();
    private static GroupGenerator<Matrix> generator = new GroupGenerator<>();
    private static IMultiplicator<Matrix> multiplicator = new MatrixModulusMultiplicator(group.getModulus());
    private static ArrayList<Matrix> elements = generator.generate(group.getInitials(), multiplicator);

    @Test
    public void Is_Group_Closed_Under_Multiplication() {
        for (int i = 0; i < elements.size(); i++) {
            Matrix m1 = elements.get(Random.randomInt(elements.size() - 1));
            Matrix m2 = elements.get(Random.randomInt(elements.size() - 1));
            Matrix m3 = multiplicator.multiply(m1, m2);
            Assert.assertTrue(elements.contains(m3));
        }
    }
}
