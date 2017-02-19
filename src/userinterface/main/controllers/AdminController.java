package userinterface.main.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import userinterface.main.MainApp;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Alish on 22.01.2017.
 */
public class AdminController extends Controller implements Initializable {
    private MainApp mainApp;
    private Stage mainStage;
    private BorderPane mainRoot;
    private AnchorPane currentRoot;

    @FXML
    private AnchorPane passengersLayout;
    @FXML
    private PassengerInfoController passengersLayoutController;
    @FXML
    private AnchorPane adminFlightLayout;
    @FXML
    private AdminFlightInfoController adminFlightLayoutController;
    @FXML
    private AnchorPane employeeLayout;
    @FXML
    private EmployeeInfoController employeeLayoutController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @Override
    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;
        passengersLayoutController.setMainApp(mainApp);
        adminFlightLayoutController.setMainApp(mainApp);
        employeeLayoutController.setMainApp(mainApp);

    }

    @Override
    public MainApp getMainApp(){
        return mainApp;
    }

}
