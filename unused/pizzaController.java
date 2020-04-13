/**
 * @FaresElkhouli
 * @ZhiyuFeng
 */
package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.pizza.*;
import sample.scene2.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;

public class pizzaController implements Initializable{

    ObservableList<String> toppings = FXCollections.observableArrayList(
            "Beef", "Cheese", "Chicken", "Green Pepper", "Ham",
            "Mushroom", "Onion", "Pepperoni", "Pineapple", "Sausage");
    ObservableList<String> types = FXCollections.observableArrayList("Build your own",
            "Deluxe",
            "Hawaiian");
    ObservableList<String> sizes = FXCollections.observableArrayList("medium",
            "small",
            "large");
    Image byoImage = new Image("file:buildyourown.jpg");
    Image hawaiianImage = new Image("file:hawaiian.jpg");
    Image deluxeImage = new Image("file:deluxe.jpg");

    private ArrayList<Pizza> order = new ArrayList<>();

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
        sizeComboBox.setValue("medium");
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
            addToppingButton.setDisable(true);
            removeToppingButton.setDisable(true);
            imageBox.setImage(deluxeImage);
            return;
        }
        if(selected.equals("Hawaiian")){
            toppingsList.setDisable(true);
            addToppingButton.setDisable(true);
            removeToppingButton.setDisable(true);
            imageBox.setImage(hawaiianImage);
            return;
        }
        imageBox.setImage(byoImage);
        toppingsList.setDisable(false);
        addToppingButton.setDisable(false);
        removeToppingButton.setDisable(false);
    }

    /**
     * Adds topping to selected toppings box
     * @throws IllegalArgumentException
     */
    public void addToppingButtonClicked() throws IllegalArgumentException{

        ObservableList<String> selectedToppings;
        selectedToppings = toppingsList.getSelectionModel().getSelectedItems();
        if(selectedToppings.isEmpty()){
            outputArea.appendText("\nMust select at least one topping");
            return;
        }

        String curr = (String) toppingsList.getSelectionModel().getSelectedItem();

        if(selectedToppingBox.getItems().contains(curr)){
            outputArea.appendText("\nNo duplicate toppings allowed");
            return;
        }

        selectedToppingBox.getItems().add(curr);

        if(selectedToppingBox.getItems().size() > 6){
            selectedToppingBox.getItems().clear();
            outputArea.appendText("Can not select more than six toppings");
        }

    }

    /**
     * removes selected topping
     */
    public void RemoveToppingButtonCilcked(){
        if(selectedToppingBox.getSelectionModel().isEmpty()){
            outputArea.appendText("\nPlease select an item to remove");
            return;
        }
        int index = selectedToppingBox.getSelectionModel().getSelectedIndex();
        selectedToppingBox.getItems().remove(index);
    }

    /**
     * clears user selection
     */
    public void ClearSelectedButtonCilcked(){
        pizzaComboBox.setValue("Build your own");
        sizeComboBox.setValue("medium");
        imageBox.setImage(byoImage);
        selectedToppingBox.getItems().clear();
    }

    /**
     * starts the show order screen
     * @throws IOException
     */
    public void showOrderButtonPressed(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/scene2/Scene2.fxml"));
        Parent root = loader.load();
        Controller orderController = loader.getController();


        orderController.onStart(order);
        Stage window = (Stage) showOrderButton.getScene().getWindow();
        window.setScene(new Scene(root));
        window.show();


    }

    /**
     * adds pizza to order
     */
    public void addToOrderButtonPressed(){
        String pType = (String) pizzaComboBox.getValue();
        String pSize = (String) sizeComboBox.getValue();

        if(pType.equals("Build your own")){
            ArrayList<String> toppings= new ArrayList<String>();
            ObservableList<String> selected = selectedToppingBox.getItems();
            if (selected.size() < 1){
                outputArea.appendText("Must choose at least one topping");
                return;
            }
            for (int i = 0; i<selected.size();++i){
                toppings.add(selected.get(i));
            }
            BuildYourOwn curr = new BuildYourOwn(pType,pSize,toppings);
            order.add(curr);
            outputArea.appendText("\nPizza successfully added!" + curr.toString());
            return;
        }
        if(pType.equals("Deluxe")){
            Deluxe curr = new Deluxe(pType,pSize);
            order.add(curr);
            outputArea.appendText("\nPizza successfully added!" + curr.toString());
            return;
        }
        if(pType.equals("Hawaiian")){
            Hawaiian curr = new Hawaiian(pType,pSize);
            order.add(curr);
            outputArea.appendText("\nPizza successfully added!" + curr.toString());
            return;
        }

        outputArea.appendText("\nInvalid input");
    }

}
