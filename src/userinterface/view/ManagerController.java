package userinterface.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import userinterface.MainApp;
import userinterface.utils.SplitPaneDividerSlider;

public class ManagerController extends Controller implements Initializable {
    private MainApp mainApp;
    private Stage mainStage;
    private BorderPane mainRoot;
    private AnchorPane currentRoot;

    public Stage getMainStage(){
        return mainStage;
    }

    public ManagerController() {
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

//    @FXML private DatePicker datePickerFrom;
//    @FXML private ToggleButton leftToggleButton;
//    @FXML private SplitPane centerSplitPane;
//    @FXML private SplitPane mainSplitPane;
    @FXML
    private ObservableList<String> switchSceneList = FXCollections.observableArrayList("Flight information", "Passengers information");
    @FXML
    private ComboBox<String> switchSceneBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        switchSceneBox.setItems(switchSceneList);
        switchSceneBox.setValue("Flight information");
    }

    public void initLayout(String layout) {
        mainStage = mainApp.getMainAppWindow();
        mainRoot = (BorderPane) mainApp.getMainRoot();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(layout));
            currentRoot = (AnchorPane) loader.load();
            // Show the scene containing the root layout.
            mainRoot.setCenter(currentRoot);
            Controller controller = loader.getController();
            if(controller != null){
                controller.setMainApp(mainApp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleSwitchScene(){
        String layout;
        switch (switchSceneBox.getValue()){
            case "Flight information":
                layout = "view/FlightLayout.fxml";
                break;
            case "Passengers information":
                layout = "view/PassengerLayout.fxml";
                break;
            default:
                layout = "view/FlightLayout.fxml";
        }
        initLayout(layout);
    }

//    public void setFiltersPaneAnimation(){
//        SplitPaneDividerSlider leftSplitPaneDividerSlider = new SplitPaneDividerSlider(centerSplitPane, 0, userinterface.utils.SplitPaneDividerSlider.Direction.LEFT, leftFilters);
//        leftToggleButton.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) -> {
//            leftSplitPaneDividerSlider.setAimContentVisible(t1);
//        });
//
//        leftToggleButton.setText("< Hide Filters");
//        leftToggleButton.setCursor(Cursor.HAND);
//
//        leftToggleButton.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) -> {
//            if (t1) {
//                leftToggleButton.setText("< Hide Filters");
//            } else {
//                leftToggleButton.setText("> Show Filters");
//            }
//        });
//    }
}
