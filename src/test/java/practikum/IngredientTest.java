package practikum;

import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;
import test_helpers.FloatGenerator;
import test_helpers.IngredientTypeGenerator;
import test_helpers.StringGenerator;


public class IngredientTest {
    @Test
    public void checkIngredientObjectcreatedNormallyTest(){
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,
                StringGenerator.generateName(),
                FloatGenerator.generateFloat());

        Assert.assertNotNull(ingredient);
    }


    @Test
    public void getPriceReturnsValidValueTest(){
        float price = FloatGenerator.generateFloat();

        Ingredient ingredient = new Ingredient(
                IngredientTypeGenerator.returnRandomIngredientType(),
                StringGenerator.generateName(),
                price);

        Assert.assertEquals(price, ingredient.getPrice(), 0.00001);
    }


    @Test
    public void getNameReturnsValidValueTest(){
        String name = StringGenerator.generateName();

        Ingredient ingredient = new Ingredient(
                IngredientTypeGenerator.returnRandomIngredientType(),
                name,
                FloatGenerator.generateFloat());

        Assert.assertEquals(name, ingredient.getName());
    }


    @Test
    public void getIngredientTypeReturnsValidValueTest(){
        IngredientType ingredientType = IngredientTypeGenerator.returnRandomIngredientType();

        Ingredient ingredient = new Ingredient(
                ingredientType,
                StringGenerator.generateName(),
                FloatGenerator.generateFloat());

        Assert.assertEquals(ingredientType, ingredient.getType());
    }
}