package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import sample.pizza.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    ObservableList<String> toppings = FXCollections.observableArrayList(
            "Beef", "Cheese", "Chicken", "Green Pepper", "Ham",
            "Mushroom", "Onion", "Pepperoni", "Pineapple", "Sausage");
    ObservableList<String> types = FXCollections.observableArrayList("Build your own",
            "Deluxe",
            "Hawaiian");
    ObservableList<String> sizes = FXCollections.observableArrayList("Medium",
            "Small",
            "Large");

    //inject FXML objects
    @FXML
    private ComboBox pizzaComboBox;
    @FXML
    private ComboBox sizeComboBox;
    @FXML
    private ListView<String> toppingsList = new ListView<String>(toppings);
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


    /**
     * initializes values and injects data
     * @param location
     * @param resource
     */
    public void initialize(URL location, ResourceBundle resource){
        pizzaComboBox.setItems(types);
        sizeComboBox.setItems(sizes);
        pizzaComboBox.setValue("Build your own");
        sizeComboBox.setValue("Medium");
        toppingsList.setItems(toppings);
    }


    /**
     * disables boxes
     */
    public void pizzaComBoxselect(){
        String selected = (String) pizzaComboBox.getSelectionModel().getSelectedItem();
        if(selected.equals("Deluxe") || selected.equals("Hawaiian")){
            toppingsList.setDisable(true);
        }
    }
    
    public void addButtonClicked() throws IllegalArgumentException{
        if()
    }
}
