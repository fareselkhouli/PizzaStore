package sample.scene2;

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

public class Controller {
    @FXML
    private TextArea outputArea;
    @FXML
    private Button clearOrderButton;
    @FXML
    private Button codeButton;

    public Button ClearOrderButtonClicked() {
        outputArea.setText(null);
        return;
    }

    public Button CodeButtonClicked() {
        showOrderButton.setOnAction(e -> primaryStage.setScene(sample));
        return;
    }

    String pType = (String) pizzaComboBox.getValue();
    String jointoppings;
    if(pType.equals("Build your own")){
        jointoppings = String.join(",",toppings)
        outputArea.appendText("\nThe pizza is:" + curr.toString + "including toppings:"+jointoppings);
    }else {
        outputArea.appendText("\nThe pizza is:" + curr.toString);
    }
    }
