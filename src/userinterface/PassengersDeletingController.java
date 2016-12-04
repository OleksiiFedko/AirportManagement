package userinterface;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class PassengersDeletingController {
    private Stage dialogStage;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public PassengersDeletingController(){
    }

    @FXML
    public void handleCancelButton(){
        dialogStage.close();
    }
}
