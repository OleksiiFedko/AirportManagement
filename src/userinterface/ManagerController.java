package userinterface;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ManagerController implements Initializable {
    private MainApp mainApp;
    //private Stage stage;
    private Stage stage;

    public ManagerController() {
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    ObservableList<String> switchSceneList = FXCollections.observableArrayList("Flight information", "Passengers information");
    @FXML
    private ComboBox<String> switchSceneBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        switchSceneBox.setItems(switchSceneList);
    }



    @FXML
    public void handleAddPassenger(ActionEvent actionEvent) {
       //- mainApp.showPassengerAddingDialog();
        try {
            // Загружаем fxml-файл и создаём новую сцену
            // для всплывающего диалогового окна.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/PassengerAdding.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Создаём диалоговое окно Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Passenger adding");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(stage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Передаём адресата в контроллер.
            PassengersAddingController pIController = loader.getController();
            pIController.setDialogStage(dialogStage);

            // Отображаем диалоговое окно и ждём, пока пользователь его не закроет
            dialogStage.showAndWait();

//            return true;
        } catch (IOException e) {
            e.printStackTrace();
//            return false;
        }
    }

    @FXML
    public void handleEditPassenger(ActionEvent actionEvent) {
       // mainApp.showPassengerEditingDialog();
        try {
            // Загружаем fxml-файл и создаём новую сцену
            // для всплывающего диалогового окна.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/PassengerEditing.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Создаём диалоговое окно Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Passenger adding");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(stage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Передаём адресата в контроллер.
            PassengersEditingController pEController = loader.getController();
            pEController.setDialogStage(dialogStage);

            // Отображаем диалоговое окно и ждём, пока пользователь его не закроет
            dialogStage.showAndWait();

//            return true;
        } catch (IOException e) {
            e.printStackTrace();
//            return false;
        }
    }

    @FXML
    public void handleDeletePassenger(ActionEvent actionEvent) {
//        mainApp.showPassengerDeleteDialog();
        try {
            // Загружаем fxml-файл и создаём новую сцену
            // для всплывающего диалогового окна.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/PassengerDeleting.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Создаём диалоговое окно Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Delete passenger");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(stage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Передаём адресата в контроллер.
            PassengersDeletingController pDController = loader.getController();
            pDController.setDialogStage(dialogStage);

            // Отображаем диалоговое окно и ждём, пока пользователь его не закроет
            dialogStage.showAndWait();

//            return true;
        } catch (IOException e) {
            e.printStackTrace();
//            return false;
        }
    }

    public void handleSwitchScene(ActionEvent actionEvent) throws IOException {
        Parent root;
        if(actionEvent.getSource()== switchSceneBox){
//            //get reference to the button's stage
//            stage=(Stage) switchSceneBoxPassenger.getScene().getWindow();
//            //load up OTHER FXML document
//            root = FXMLLoader.load(getClass().getResource("view/PassengerLayout.fxml"));
            if(switchSceneBox.getValue() == "Passengers information"){
                //get reference to the button's stage
                stage=(Stage) switchSceneBox.getScene().getWindow();
                //load up OTHER FXML document
                root = FXMLLoader.load(getClass().getResource("view/PassengerLayout.fxml"));
            } else{
                stage=(Stage) switchSceneBox.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("view/FlightLayout.fxml"));
            }
        } else{
//            stage=(Stage) switchSceneBoxFlight.getScene().getWindow();
//            root = FXMLLoader.load(getClass().getResource("view/FlightLayout.fxml"));
            if(switchSceneBox.getValue() == "Flight information"){
                //get reference to the button's stage
                stage=(Stage) switchSceneBox.getScene().getWindow();
                //load up OTHER FXML document
                root = FXMLLoader.load(getClass().getResource("view/PassengerLayout.fxml"));
            } else{
                stage=(Stage) switchSceneBox.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("view/FlightLayout.fxml"));
            }
        }
        //create a new scene with root and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
