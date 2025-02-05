package test_helpers;

import net.bytebuddy.utility.RandomString;


public class StringGenerator {
    public static String generateName(){
        return RandomString.make(10);
    }


    public static String generateName(int length){
        return RandomString.make(length);
    }
}