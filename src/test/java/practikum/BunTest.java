package practikum;

import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;
import test_helpers.FloatGenerator;
import test_helpers.StringGenerator;


public class BunTest {
    @Test
    public void getNameReturnsValidValueTest(){
        String name = StringGenerator.generateName();
        Bun bun = new Bun(name, FloatGenerator.generateFloat());

        Assert.assertEquals(name, bun.getName());
    }


    @Test
    public void getPriceCheckReturnsValidValueTest() {
        float price = FloatGenerator.generateFloat();
        Bun bun = new Bun(StringGenerator.generateName(), price);

        Assert.assertEquals(price, bun.getPrice(), 0.00001);
    }
}