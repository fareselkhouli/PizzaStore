package sample.pizza;

/**
 * This class implements the Hawaiian pizza type and extends the abstract class Pizza
 * @FaresElkhouli
 * @ZhiyuFeng
 */
public class Hawaiian extends Pizza {
    public Hawaiian(String style, String size){
        super(style,size);
    }

    /**
     * calculates the price of the pizza
     * @return int price of pizza
     */
    public int pizzaPrice(){
        int mediumFlat = 2;
        int largeFlat = 4;
        int smallCost = 8;
        int mediumCost = smallCost+mediumFlat;
        int largeCost = smallCost+largeFlat;

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
        return "This is a " + size+ " hawaiian pizza that costs: $" + pizzaPrice();
    }
}
