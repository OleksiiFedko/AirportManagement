package userinterface.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import storage.daoimpl.RootsDaoImpl;

/**
 * Created by Alish on 19.01.2017.
 */
public class EmployeeAddController {
    @FXML
    private TextField login;
    @FXML
    private TextField password;
    @FXML
    private MenuButton roots;


    private Stage dialogStage;
    private RootsDaoImpl employee;
    private boolean okClicked = false;

    @FXML
    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }



    public boolean isOkClicked() {
        return okClicked;
    }


    @FXML
    private void handleOk() {


            okClicked = true;
            dialogStage.close();
    }



    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (login.getText() == null || login.getText().length() == 0) {
            errorMessage += "No valid login!\n";
        }
        if (password.getText() == null || password.getText().length() == 0) {
            errorMessage += "No valid password!\n";
        }
        if (roots.getText() == null || roots.getText().length() == 0) {
            errorMessage += "No valid roots!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Показываем сообщение об ошибке.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}
