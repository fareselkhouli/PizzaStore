package sample;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import sample.pizza.*;

public class Controller {
    //inject FXML objects
    @FXML
    private ComboBox pizzaComboBox;
    @FXML
    private ComboBox sizeComboBox;
    @FXML
    private ListView toppingsList;
    @FXML
    private  Button addToppingButton;
    @FXML
    private Button removeToppingButton;
    @FXML
    private Button clearSelectButton;
    @FXML
    private ListView selectedToppingBox;
    @FXML
    private Button addToOrderButton;
    @FXML
    private Button showOrderButton;
    @FXML
    private TextArea outputArea;

    public Pizza cs213 = new Pizza();
    /**
     * Disable all the wrong fields
     */
    pizzaComboBox.getItems().addAll(
            "Build your own",
                    "Deluxe",
                    "Hawaiian"
    );
    sizeComboBox.getItems().addAll(
            "Medium",
            "Small",
            "Large"
    )
    ListView<String> toppingsList = new ListView<String>();
    ObservableList<String> items = FXCollections.observableArrayList(
            "Beef", "Cheese", "Chicken", "Green Pepper", "Ham",
            "Mushroom", "Onion", "Pepperoni", "Pineapple", "Sausage");
    toppingList.setItems(items);
    public void pizzaComBoxselect(){
        if(pizzaComboBox=="Deluxe"){
            toppingsList.setDisable(true);
        } else if (pizzaComboBox=="Hawaiian"){
            toppingsList.setDisable(true);
        }
    }
    public void addButtonClicked() throws IllegalArgumentException{
        if()
    }
}
