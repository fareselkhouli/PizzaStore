package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    Image byoImage = new Image("file:buildyourown.jpg");
    Image hawaiianImage = new Image("file:hawaiian.jpg");
    Image deluxeImage = new Image("file:deluxe.jpg");

    //inject FXML objects
    @FXML
    private ComboBox pizzaComboBox;
    @FXML
    private ImageView imageBox;
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
        imageBox.setImage(byoImage);
    }


    /**
     * disables boxes
     */
    public void pizzaComBoxselect(){

        String selected = (String) pizzaComboBox.getSelectionModel().getSelectedItem();
        if(selected.equals("Deluxe") ){
            toppingsList.setDisable(true);
            imageBox.setImage(deluxeImage);
            return;
        }
        if(selected.equals("Hawaiian")){
            toppingsList.setDisable(true);
            imageBox.setImage(hawaiianImage);
            return;
        }
        imageBox.setImage(byoImage);
        toppingsList.setDisable(false);
    }

    public void addButtonClicked() throws IllegalArgumentException{

    }
}
    public void RemoveToppingButtonCilcked(){
        toppingsList.myListView.SelectedItems.Clear();
    }

    public void ClearSelectedButtonCilcked(){
    Reset(pizzaComboBox);
    Reset(sizeComboBox);
    Reset(imageBox);
    toppingsList.myListView.SelectedItems.Clear();
    }

    public void ShowOrderButtonClicked(){
    showOrderButton.setOnAction(e -> primaryStage.setScene(scene2));
    }