package test.java.com.olegsorokin;

import main.java.com.olegsorokin.utils.Random;
import org.junit.Assert;
import org.junit.Test;

public class RandomTest {
    @Test
    public void Test_Random_Integers_From_5_To_20() {
        int from = 5;
        int to = 20;
        for (int i = 0; i < 10000; i++) {
            int result = Random.randomInt(from, to);
            Assert.assertTrue(result >= from && result <= to);
        }
    }

    @Test
    public void Test_Random_Integers_To_50() {
        int to = 50;
        for (int i = 0; i < 10000; i++) {
            int result = Random.randomInt(to);
            Assert.assertTrue(result >= 0 && result <= to);
        }
    }
}
