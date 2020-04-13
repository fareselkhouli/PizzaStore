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
    private  int total = 0;
    private ArrayList<Pizza> order = new ArrayList<Pizza>();

    public void onStart(ArrayList<Pizza> order){

        this.order = order;
        ArrayList<String> pizzas = new ArrayList<String>();
        for(int i = 0; i < order.size(); ++i){
            pizzas.add(order.get(i).toString());
            total += order.get(i).pizzaPrice();
        }
        ObservableList<String> pizzaList = FXCollections.observableArrayList(pizzas);
        orderList.setItems(pizzaList);
        totalField.setText(Integer.toString(total));
    }

    public void clearSelectionPressed(){
        if(orderList.getSelectionModel().isEmpty()){
            orderOutputArea.appendText("\nPlease select an item to remove");
            return;
        }
        int index = orderList.getSelectionModel().getSelectedIndex();
        String orderToBeRemoved = orderList.getItems().get(index);
        orderList.getItems().remove(index);
        int priceToBeDeducted = order.get(index).pizzaPrice();
        //int priceToBeDeducted = Integer.parseInt(orderToBeRemoved.substring(orderToBeRemoved.length() - 2));
        total -= priceToBeDeducted;
        totalField.setText(Integer.toString(total));
        order.remove(index);
}
    public void clearOrderPressed(){
        if (orderList.getItems().isEmpty()){
            orderOutputArea.appendText("\nOrder is already empty");
            return;
        }
        orderList.getItems().clear();
        totalField.setText(Integer.toString(0));
        total = 0;
        order.clear();
    }

    public void backPressed(){

    }

}
