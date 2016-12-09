package userinterface;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import storage.entities.PassengersEntity;

public class PassengersAddingController {
      @FXML
      private TextField firstName;
      @FXML
      private TextField lastName;
      @FXML
      private TextField nationality;
      @FXML
      private TextField birthday;
      @FXML
      private TextField passport;
      @FXML
      private TextField sex;
      @FXML
      private TextField classType;
      @FXML
      private TextField flightNum;

      private Stage dialogStage;
//    private PassengersEntity passengersEntity;

      public void setDialogStage(Stage dialogStage) {
            this.dialogStage = dialogStage;
      }

      public PassengersAddingController(){

      }

      @FXML
      public void handleCancelButton(){
            dialogStage.close();
      }

      @FXML
      private void initialize() {
      }

//    /**
//     * Вызывается, когда пользователь кликнул по кнопке OK.
//     */
//    @FXML
//    private void handleOk() {
//
//    }
//
//    /**
//     * Проверяет пользовательский ввод в текстовых полях.
//     *
//     * @return true, если пользовательский ввод корректен
//     */
    /*private boolean isInputValid() {
        String errorMessage = "";

        if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
            errorMessage += "No valid first name!\n";
        }
        if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
            errorMessage += "No valid last name!\n";
        }
        if (streetField.getText() == null || streetField.getText().length() == 0) {
            errorMessage += "No valid street!\n";
        }

        if (postalCodeField.getText() == null || postalCodeField.getText().length() == 0) {
            errorMessage += "No valid postal code!\n";
        } else {
            // пытаемся преобразовать почтовый код в int.
            try {
                Integer.parseInt(postalCodeField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid postal code (must be an integer)!\n";
            }
        }

        if (cityField.getText() == null || cityField.getText().length() == 0) {
            errorMessage += "No valid city!\n";
        }

        if (birthdayField.getText() == null || birthdayField.getText().length() == 0) {
            errorMessage += "No valid birthday!\n";
        } else {
            if (!DateUtil.validDate(birthdayField.getText())) {
                errorMessage += "No valid birthday. Use the format dd.mm.yyyy!\n";
            }
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
    }*/
 }
