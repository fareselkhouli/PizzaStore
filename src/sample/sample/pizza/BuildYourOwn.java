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
     * @return int price of pizza. returns -1 on error case
     */
    public int pizzaPrice(){
        int minTopping = 1;
        int numberToppings = toppings.size();
        if (numberToppings < minTopping) {
            return -1;
        }
        int smallFlat = 5;
        int mediumFlat = 2;
        int largeFlat = 4;
        int perToppingPrice = 2;
        int smallCost = smallFlat + perToppingPrice*numberToppings;
        int mediumCost = smallCost + mediumFlat + perToppingPrice*numberToppings;
        int largeCost = smallCost + largeFlat + perToppingPrice*numberToppings;

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
        String topping = "";
        for (int i = 0;i < toppings.size(); i++){
            topping += toppings.get(i) + ", ";
        }
        return "This is a " + size+ " build your own pizza with toppings: " + topping +" that costs: $" + pizzaPrice();
    }
}
