package sample.pizza;
/**
 * This class implements the Deluxe pizza type and extends the abstract class Pizza
 * @FaresElkhouli
 * @ZhiyuFeng
 */
public class Deluxe extends Pizza {

    /**
     * constructor for deluxe pizza
     * @param style
     * @param size
     */
    public Deluxe(String style, String size){
        super(style,size);
    }

    /**
     * calculates the price of the pizza
     * @return int price of pizza
     */
    public int pizzaPrice(){
        int mediumFlat = 2;
        int largeFlat = 4;
        int smallCost = 14;
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
     * returns string representation of Deluxe
     * @return string
     */
    @Override
    public String toString(){
        return "This is a " + size+ " deluxe pizza that costs: $" + pizzaPrice();
    }
}
