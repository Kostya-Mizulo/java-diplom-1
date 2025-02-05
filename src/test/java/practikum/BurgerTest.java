package practikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import test_helpers.FloatGenerator;
import test_helpers.StringGenerator;

import static org.junit.Assert.fail;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    public Burger burger;
    @Mock
    public Bun bunMock;
    @Mock
    public Ingredient ingredient1Mock;
    @Mock
    public Ingredient ingredient2Mock;
    @Mock
    public Ingredient ingredient3Mock;


    @Before
    public void createBurger(){
        burger = new Burger();
        burger.setBuns(bunMock);
        burger.addIngredient(ingredient1Mock);
        burger.addIngredient(ingredient2Mock);
        burger.addIngredient(ingredient2Mock);

        Mockito.when(ingredient1Mock.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient2Mock.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient1Mock.getName()).thenReturn(StringGenerator.generateName());
    }


    @Test
    public void setBunsMethodSetsBunIntoBurgerTest(){
        Assert.assertNotNull(burger.bun);
    }


    @Test
    public void addIngredientInsertsOneIngredientIntoList(){
        burger.addIngredient(ingredient3Mock);

        Assert.assertTrue(burger.ingredients.contains(ingredient3Mock));
    }


    @Test
    public void addIngredientMethodCanBeCalledMultipleTimesAndSaveIngredientToListMethod(){
        burger.addIngredient(ingredient3Mock);

        Assert.assertTrue(burger.ingredients.size() == 4);
    }


    @Test
    public void removeIngredientDeletesIngredientFromListByIndexTest(){
        if (!burger.ingredients.contains(ingredient1Mock)) fail("burger does not contains test ingredient");

        burger.removeIngredient(0);

        Assert.assertFalse(burger.ingredients.contains(ingredient1Mock));
    }


    @Test
    public void moveIngredientMovesIngredientIntoNewPositionTest(){
        burger.moveIngredient(0, 1);

        Assert.assertEquals(ingredient1Mock, burger.ingredients.get(1));
    }


    @Test
    public void getPriceCountsAndReturnsPriceOfBurgerTest(){
        float bunPrice = FloatGenerator.generateFloat();
        float ingredient1Price = FloatGenerator.generateFloat();
        float ingredient2Price = FloatGenerator.generateFloat();
        float expectedPrice = bunPrice*2 + ingredient1Price + ingredient2Price + ingredient2Price;

        Mockito.when(bunMock.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient1Mock.getPrice()).thenReturn(ingredient1Price);
        Mockito.when(ingredient2Mock.getPrice()).thenReturn(ingredient2Price);

        Assert.assertEquals(expectedPrice, burger.getPrice(), 0.00001);
    }


    @Test
    public void getReceiptCallsGetNameOfBunTwiceTest(){
        burger.getReceipt();

        Mockito.verify(bunMock, Mockito.times(2)).getName();
    }


    @Test
    public void getReceiptCallsGetTypeOfIngredientForEachIngredientTest(){
        burger.getReceipt();

        Mockito.verify(ingredient2Mock, Mockito.times(2)).getType();
    }


    @Test
    public void getReceiptTransformsIngredientTypeToStringAndAddInReceiptInLowerCase(){
        String receipt = burger.getReceipt();

        Assert.assertTrue(receipt.contains("sauce"));
    }


    @Test
    public void getReceiptCallsGetNameOfIngredientForEachIngredient(){
        burger.getReceipt();

        Mockito.verify(ingredient1Mock, Mockito.times(1)).getName();
        Mockito.verify(ingredient2Mock, Mockito.times(2)).getName();
    }
}