package practikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import test_helpers.FloatGenerator;
import test_helpers.StringGenerator;


@RunWith(Parameterized.class)
public class BunParameterizedTest {
    private final String errorText;
    private final String name;
    private final float price;


    public BunParameterizedTest(String errorText,
                                String name,
                                float price) {
        this.errorText = errorText;
        this.name = name;
        this.price = price;
    }


    @Parameterized.Parameters(name = "Create Bun with name - {1}, price - {2}")
    public static Object[][] getParameters(){
        return new Object[][]{
                {"Error with creation bun with standard name price", StringGenerator.generateName(), FloatGenerator.generateFloat()},
                {"Error with creation bun with empty name", "", FloatGenerator.generateFloat()},
                {"Error with creation bun with null name", null, FloatGenerator.generateFloat()},
                {"Error with creation bun with digital name", "123456789", FloatGenerator.generateFloat()},
                {"Error with creation bun with long name", StringGenerator.generateName(1000), FloatGenerator.generateFloat()},
                {"Error with creation bun with special symbols in name", StringGenerator.generateName(3) + "!@#$%^&*()", FloatGenerator.generateFloat()},
                {"Error with creation bun with zero price", StringGenerator.generateName(), 0},
                {"Error with creation bun with max float price", StringGenerator.generateName(), Float.MAX_VALUE},
                {"Error with creation bun with negative price", StringGenerator.generateName(), FloatGenerator.generateNegativeNumber()},
                {"Error with creation bun with min float price", StringGenerator.generateName(), -Float.MAX_VALUE}
        };
    }


    @Test
    public void bunObjectCreatedSuccessfullyWithDifferentValidValuesTest(){
        Bun bun = new Bun(name, price);

        Assert.assertNotNull(errorText, bun);
    }
}