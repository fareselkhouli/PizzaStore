package sample.pizza;
import java.util.ArrayList;

/**
 * This class implements the BuildYourOwn pizza type and extends the abstract class Pizza
 * @FaresElkhouli
 * @ZhiyuFeng
 */
public class BuildYourOwn extends Pizza {

    public BuildYourOwn(String style, String size, ArrayList<String> toppings){
        super(style,size,toppings);
    }

    /**
     * calculates the price of the pizza
     * @return int price of pizza
     */
    public int pizzaPrice(){
        int numberToppings = toppings.size();
        int smallCost = 5 + 2*numberToppings;
        int mediumCost = smallCost + 2 + 2*numberToppings;
        int largeCost = smallCost + 4 + 2*numberToppings;

        if (size.equals("small")){
            return smallCost;
        }
        if (size.equals("medium")){
            return mediumCost;
        }
        if (size.equals("large")){
            return largeCost;
        }

        //error case
        return -1;
    }

    /**
     * returns string representation of Hawaiian
     * @return string
     */
    @Override
    public String toString(){
        return "This is a " + size+ " build your own pizza that costs: $" + pizzaPrice();
    }
}
