package userinterface;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import storage.entities.PassengersEntity;

public class StaffController implements Initializable {
    private MainApp mainApp;
    //private Stage stage;
    private BorderPane rootLayout, rootLayout2;

    public StaffController() {
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        switchSceneBox.setItems(switchSceneList);
        switchSceneBox.setValue("Passengers information");
    }

    @FXML
    ObservableList<String> switchSceneList = FXCollections.observableArrayList("Passengers information", "Flight information");

    @FXML
    private ComboBox<String> switchSceneBox;

    @FXML
    public void handleAddPassenger(ActionEvent actionEvent) {
        mainApp.showPassengerAddingDialog();
    }

    @FXML
    public void handleEditPassenger(ActionEvent actionEvent) {
        mainApp.showPassengerEditingDialog();
    }

    @FXML
    public void handleDeletePassenger(ActionEvent actionEvent) {
        mainApp.showPassengerDeleteDialog();
    }

    public void handleSwitchScene() {
        if(switchSceneBox.getValue() == "Passengers information"){

        } else if(switchSceneBox.getValue() == "Flight information"){

        }
    }
}
