/**
 * @FaresElkhouli
 * @ZhiyuFeng
 */
package sample.scene2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.pizza.*;
import java.util.ArrayList;

public class Controller {

    //inject FXML objects
    @FXML
    private ListView<String> orderList;
    @FXML
    private Button clearSelectionButton;
    @FXML
    private Button backButton;
    @FXML
    private Button clearOrderButton;
    @FXML
    private TextField totalField;
    @FXML
    private TextArea orderOutputArea;


    public void onStart(ArrayList<Pizza> order){

        int total = 0;
        ArrayList<String> pizzas = new ArrayList<String>();
        for(int i = 0; i < order.size(); ++i){
            pizzas.add(order.get(i).toString());
            total += order.get(i).pizzaPrice();
        }
        ObservableList<String> pizzaList = FXCollections.observableArrayList(pizzas);
        orderList.setItems(pizzaList);
        totalField.setText(Integer.toString(total));
    }

}
