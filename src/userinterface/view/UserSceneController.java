package userinterface.view;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import storage.dao.LoginDaoImpl;
import userinterface.utils.SplitPaneDividerSlider;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UserSceneController extends Controller implements Initializable {


    @FXML private ChoiceBox cityFrom;
    @FXML private ChoiceBox cityTo;
    @FXML private DatePicker datePickerFrom;
    @FXML private AnchorPane leftFilters;
    @FXML private ToggleButton leftToggleButton;
    @FXML private SplitPane centerSplitPane;
    @FXML private SplitPane mainSplitPane;

    private ArrayList<Object> filtersList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setFiltersPaneAnimation();
        LoginDaoImpl test = new LoginDaoImpl();
        //getFilters();
        //setFlightsInfo();
    }

    public void setFiltersPaneAnimation(){

        SplitPaneDividerSlider leftSplitPaneDividerSlider = new SplitPaneDividerSlider(centerSplitPane, 0, SplitPaneDividerSlider.Direction.LEFT, leftFilters);

        leftToggleButton.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) -> {
            leftSplitPaneDividerSlider.setAimContentVisible(t1);
        });

        leftToggleButton.setText("< Hide Filters");
        leftToggleButton.setCursor(Cursor.HAND);

        leftToggleButton.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) -> {
            if (t1) {
                leftToggleButton.setText("< Hide Filters");
            } else {
                leftToggleButton.setText("> Show Filters");
            }
        });
    }

}