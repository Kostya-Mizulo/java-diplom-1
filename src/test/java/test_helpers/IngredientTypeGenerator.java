package test_helpers;

import praktikum.IngredientType;
import java.util.Random;


public class IngredientTypeGenerator {
    public static IngredientType returnRandomIngredientType(){
        Random random = new Random();
        boolean choose = random.nextBoolean();

        return choose ? IngredientType.SAUCE : IngredientType.FILLING;
    }
}
