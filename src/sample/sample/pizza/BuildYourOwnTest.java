/**
 * @FaresElkhouli
 * @ZhiyuFeng
 */
package sample.pizza;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BuildYourOwnTest {

    @org.junit.jupiter.api.Test
    void pizzaPrice() {

        ArrayList<String> toppings = new ArrayList<String>();
        toppings.add("Cheese");
        toppings.add("Pepperoni");
        toppings.add("Ham");
        BuildYourOwn test = new BuildYourOwn("Build your own","small",toppings);
        assertEquals(11,test.pizzaPrice());

        ArrayList<String> toppings1 = new ArrayList<String>();
        BuildYourOwn test1 = new BuildYourOwn("Build your own","medium",toppings1);
        assertEquals(-1,test1.pizzaPrice());

        ArrayList<String> toppings2 = new ArrayList<String>();
        BuildYourOwn test2 = new BuildYourOwn("Build your own","MDDDD",toppings2);
        assertEquals(-1,test2.pizzaPrice());

        ArrayList<String> toppings3 = new ArrayList<String>();
        toppings3.add("Mushrooms");
        BuildYourOwn test3 = new BuildYourOwn("Build your own","large",toppings3);
        assertEquals(13,test3.pizzaPrice());
    }
}