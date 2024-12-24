package test_helpers;

import java.util.Random;

public class FloatGenerator {
    public static float generateFloat(){
        Random random = new Random();
        int intNumber = random.nextInt(1000);
        return intNumber+random.nextFloat();
    }

    public static float generateNegativeNumber(){
        Random random = new Random();
        int intNumber = random.nextInt(1000);
        return -random.nextFloat();
    }
}