package userinterface.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import storage.daoimpl.PassengersDaoImpl;
import storage.entities.PassengersEntity;

public class PassengersDeletingController {
    private Stage dialogStage;
    private boolean okClicked = false;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    public void handleCancelButton(){
        dialogStage.close();
    }

    @FXML
    public void handleOk() {

    }

    public boolean isOkClicked() {
        return okClicked;
    }
}
