package practikum;

import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;


public class IngredientTypeTest {
    @Test
    public void checkIngredientTypeSauceExistsTest(){
        IngredientType sauce = IngredientType.SAUCE;

        Assert.assertEquals(IngredientType.SAUCE, sauce);
    }


    @Test
    public void checkIngredientTypeFillingExistsTest(){
        IngredientType filling = IngredientType.FILLING;

        Assert.assertEquals(IngredientType.FILLING, filling);
    }
}