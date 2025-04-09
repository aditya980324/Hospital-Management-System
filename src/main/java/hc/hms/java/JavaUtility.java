package hc.hms.java;

import java.util.Random;

public class JavaUtility {
    public int getRandomNum() {
        Random random = new Random();
        return random.nextInt(5555);
    }
}
