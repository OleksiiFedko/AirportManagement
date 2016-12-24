package userinterface.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import userinterface.MainApp;

public class ManagerController extends Controller implements Initializable {
    private MainApp mainApp;
    private Stage mainStage;
    private BorderPane mainRoot;
    private AnchorPane currentRoot;
    private  ManagerController managerController;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

//    public void initLayout(String layout) {
//        mainStage = mainApp.getMainAppWindow();
//        mainRoot = (BorderPane) mainApp.getMainRoot();
//        try {
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(MainApp.class.getResource(layout));
//            currentRoot = (AnchorPane) loader.load();
//            // Show the scene containing the root layout.
//            mainRoot.setCenter(currentRoot);
//            Controller controller = loader.getController();
//            if(controller != null){
//                controller.setMainApp(mainApp);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}
