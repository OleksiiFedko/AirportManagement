package userinterface.controllers;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import storage.daoimpl.PassengersDaoImpl;
import storage.entities.PassengersEntity;

public class PassengersAddingController {
    @FXML private TextField firstName;
    @FXML private TextField lastName;
    @FXML private TextField nationality;
    @FXML private TextField birthday;
    @FXML private TextField passport;
    @FXML private TextField sex;
    @FXML private TextField classType;
    @FXML private TextField flightNum;

    private Stage dialogStage;
    private boolean okClicked = false;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
      }


    @FXML
    public void handleCancelButton() {
        dialogStage.close();
    }

    /**
     * * Вызывается, когда пользователь кликнул по кнопке OK.
     * */
    @FXML
    public void handleOkAdd() {
        if(isInputValid()) {
            PassengersEntity currentPassenger = new PassengersEntity(firstName.getText(), lastName.getText(), nationality.getText(), birthday.getText(),
                    passport.getText(), sex.getText(), classType.getText(), flightNum.getText());
            dialogStage.close();
            PassengersDaoImpl passengersDao = new PassengersDaoImpl();
            passengersDao.addPassenger(currentPassenger);
            okClicked = true;
        }
//        if(isInputValid()){
        PassengersEntity currentPassenger = new PassengersEntity(firstName.getText(), lastName.getText(), nationality.getText(), birthday.getText(),
                passport.getText(), sex.getText(), classType.getText(), flightNum.getText());
//        }
        dialogStage.close();
        PassengersDaoImpl passengersDao = new PassengersDaoImpl();
        passengersDao.addPassenger(currentPassenger);
        okClicked = true;
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Проверяет пользовательский ввод в текстовых полях.
     *
     * @return true, если пользовательский ввод корректен
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (firstName.getText() == null || firstName.getText().length() == 0) {
            errorMessage += "No valid first name!\n";
        }
        if (lastName.getText() == null || lastName.getText().length() == 0) {
            errorMessage += "No valid last name!\n";
        }
        if (nationality.getText() == null || nationality.getText().length() == 0) {
            errorMessage += "No valid nationality!\n";
        }
        if (birthday.getText() == null || birthday.getText().length() == 0) {
            errorMessage += "No valid birthday!\n";
        }
        if (passport.getText() == null || passport.getText().length() == 0) {
            errorMessage += "No valid passport!\n";
        }
        if (sex.getText() == null || sex.getText().length() == 0) {
            errorMessage += "No valid sex!\n";
        }
        if (classType.getText() == null || sex.getText().length() == 0) {
            errorMessage += "No valid class type!\n";
        }
        if (flightNum.getText() == null || flightNum.getText().length() == 0) {
            errorMessage += "No valid flight number!\n";
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
