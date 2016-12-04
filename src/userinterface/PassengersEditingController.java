package userinterface;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PassengersEditingController {
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

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public PassengersEditingController(){

    }

    @FXML
    public void handleCancelButton(){
        dialogStage.close();
    }

//    @FXML
//    private void initialize() {
//    }
}
