package userinterface.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import storage.daoimpl.PassengersDaoImpl;
import storage.entities.PassengersEntity;

public class PassengersEditingController {
    @FXML private TextField firstName;
    @FXML private TextField lastName;
    @FXML private TextField nationality;
    @FXML private TextField passport;
    @FXML private TextField birthday;
    @FXML private TextField sex;
    @FXML private TextField classType;
    @FXML private TextField flightNum;

    private Stage dialogStage;
    private PassengersEntity currentPassenger;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    public void handleCancelButton(){
        dialogStage.close();
    }

    @FXML
    public void handleOkEdit(){
        currentPassenger.setFirstName(firstName.getText());
        currentPassenger.setLastName(lastName.getText());
        currentPassenger.setNationality(nationality.getText());
        currentPassenger.setPassport(passport.getText());
        currentPassenger.setBirthday(birthday.getText());
        currentPassenger.setSex(sex.getText());
        currentPassenger.setClassType(classType.getText());
        currentPassenger.setFlightNum(flightNum.getText());

        dialogStage.close();

        PassengersDaoImpl passengersDao = new PassengersDaoImpl();
        passengersDao.updatePassenger(currentPassenger);
    }

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
            errorMessage += "No valid birthday date!\n";
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
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("ERROR. Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        }
    }

    public PassengersEntity getCurrentPassenger() {
        return currentPassenger;
    }

    public void setCurrentPassenger(PassengersEntity currentPassenger) {
        this.currentPassenger = currentPassenger;
    }

    public void setFirstName(String firstName) {
        this.firstName.setText(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName.setText(lastName);
    }

    public void setNationality(String nationality) {
        this.nationality.setText(nationality);
    }

    public void setBirthday(String birthday) {
        this.birthday.setText(birthday);
    }

    public void setPassport(String passport) {
        this.passport.setText(passport);
    }

    public void setSex(String sex) {
        this.sex.setText(sex);
    }

    public void setClassType(String classType) {
        this.classType.setText(classType);
    }

    public void setFlightNum(String flightNum) {
        this.flightNum.setText(flightNum);
    }
}
