package practikum;

import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

public class DatabaseTest {
    @Test
    public void availableBunsReturnsListFromConstructorTest(){
        Database db = new Database();
        List<Bun> expectedList = List.of(
                new Bun("black bun", 100),
                new Bun("white bun", 200),
                new Bun("red bun", 300)
        );

        Assert.assertEquals(
                returnlistOfBunsAsString(expectedList),
                returnlistOfBunsAsString(db.availableBuns()));
    }

    @Test
    public void availableIngredientsReturnsListFromConstructorTest(){
        Database db = new Database();
        List<Ingredient> expectedList = List.of(
                new Ingredient(IngredientType.SAUCE, "hot sauce", 100),
                new Ingredient(IngredientType.SAUCE, "sour cream", 200),
                new Ingredient(IngredientType.SAUCE, "chili sauce", 300),
                new Ingredient(IngredientType.FILLING, "cutlet", 100),
                new Ingredient(IngredientType.FILLING, "dinosaur", 200),
                new Ingredient(IngredientType.FILLING, "sausage", 300)
        );

        Assert.assertEquals(
                returnlistOfIngredientsAsString(expectedList),
                returnlistOfIngredientsAsString(db.availableIngredients()));
    }


    private static String returnlistOfBunsAsString(List<Bun> buns){
        String listOfBunsAsString = "";
        for (Bun bun : buns){
            listOfBunsAsString += bun.getName() + bun.getPrice();
        }
        return listOfBunsAsString;
    }

    private static String returnlistOfIngredientsAsString(List<Ingredient> ingredients){
        String listOfIngredientsAsString = "";
        for (Ingredient ingredient : ingredients){
            listOfIngredientsAsString += ingredient.getType() + ingredient.getName() + ingredient.getPrice();
        }
        return listOfIngredientsAsString;
    }
}
