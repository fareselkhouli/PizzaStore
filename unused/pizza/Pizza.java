package sample.pizza;
import java.util.ArrayList;

/**
 * this class implements the Pizza object
 * @FaresElkhouli
 * @ZhiyuFeng
 */
public abstract class Pizza {
    protected String style;
    protected String size;
    protected ArrayList<String> toppings;

    /**
     * constructor for Pizza
     * @param style
     * @param size
     * @param toppings
     */
    public Pizza(String style, String size, ArrayList<String> toppings) {
        this.style = style;
        this.toppings = toppings;
        this.size = size;
    }

    /**
     * constructor 2 for pizza
     * @param style
     * @param size
     */
    public Pizza(String style, String size) {
        this.style = style;
        this.size = size;
    }

    /**
     * abstract method for pizza price
     * @return int price of pizza
     */
    public abstract int pizzaPrice();

    /**
     *string representaiton of Pizza
     * @return string representation of pizza
     */
    @Override
    public String toString() {
        if(style.equals("Build your own")){
            String message = "This is a " + size +  "build your own pizza with toppings: ";
            for (int i = 0; i <= toppings.size() ; ++i){
                message += toppings.get(i);
            }
            return message;
        }
        return "This is a " + size + style + "pizza.";
    }
}
