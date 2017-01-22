package userinterface.controllers;

import businesslogic.GuiFilter;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import storage.dao.RootsDao;
import storage.daoimpl.FiltersDaoImpl;
import storage.daoimpl.PassengersDaoImpl;
import storage.daoimpl.RootsDaoImpl;
import storage.entities.PassengersEntity;
import storage.entities.RootsEntity;
import userinterface.MainApp;
import userinterface.utils.SplitPaneDividerSlider;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static javafx.application.Application.launch;

/**
 * Created by Alish on 07.12.2016.
 */
public class EmployeeInfoController extends Controller implements Initializable {

    private Stage stage;
    private MainApp mainApp;



    @FXML private TextField rootField;
    @FXML private TextField loginField;


    @FXML private TableView<RootsEntity> employeeTable;
    @FXML private TableColumn<ObservableList<RootsEntity>, String> idRootsColumn;
    @FXML private TableColumn<RootsEntity, String> rootNameColumn;
    @FXML private TableColumn<RootsEntity, String> loginColumn;
    @FXML private TableColumn<RootsEntity, String> passwordColumn;


    @FXML private AnchorPane leftFilters;
    @FXML private ToggleButton leftToggleButton;
    @FXML private SplitPane centerSplitPane;
    @FXML private SplitPane mainSplitPane;

    private final int ROWS_PER_PAGE = 15;
    private int currentPage = 1;

    private ObservableList<RootsEntity> employeeData = FXCollections.observableArrayList();
    private List<GuiFilter> filtersList = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        filtersList.add(new GuiFilter(rootField, "EmployeeInfo", "RootName", true));
        filtersList.add(new GuiFilter(loginField, "EmployeeInfo", "Login"));

        setFiltersPaneAnimation();
        setFiltersItems();
        initTableView();
        showEmployeeInfo();
    }

    private void showEmployeeInfo() {
        employeeData.clear();
        RootsDaoImpl rootsDao = new RootsDaoImpl();
        List<RootsEntity> rootsEntityList = rootsDao.getAllRoots();
        if (rootsEntityList != null) {
            employeeData.addAll(FXCollections.observableList(rootsEntityList));
            employeeTable.setItems(employeeData);
        }
    }

    private void initTableView() {
        idRootsColumn.setCellValueFactory(cellData -> {
            int index = cellData.getTableView().getItems().indexOf(cellData.getValue());
            return new SimpleStringProperty(String.valueOf((index+1)+(currentPage-1)*ROWS_PER_PAGE));
        });
        idRootsColumn.setSortable(false);

        rootNameColumn.setCellValueFactory(
                cellData -> cellData.getValue().rootNameProperty());
        loginColumn.setCellValueFactory(
                cellData -> cellData.getValue().loginProperty());
        passwordColumn.setCellValueFactory(
                cellData -> cellData.getValue().passwordProperty());
    }


    public void handleAddEmployee(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/AddEmployee.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Add Employee");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(mainApp.getMainAppWindow());
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Передаём адресата в контроллер.
            EmployeeAddController eMcontroller = loader.getController();
            eMcontroller.setDialogStage(dialogStage);


            // Отображаем диалоговое окно и ждём, пока пользователь его не закроет
            dialogStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setFiltersPaneAnimation(){
        SplitPaneDividerSlider leftSplitPaneDividerSlider = new SplitPaneDividerSlider(centerSplitPane, 0, userinterface.utils.SplitPaneDividerSlider.Direction.LEFT, leftFilters);
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

    @Override
    public void setMainApp(MainApp mainApp) {
        this.mainApp = (mainApp);
    }

    @Override
    public MainApp getMainApp() {
        return mainApp;
    }


    @FXML
    public void handleResetButton(){
        filtersList.forEach(GuiFilter::resetFilterGui);
        showEmployeeInfo();
    }

    @FXML
    public void handleSearchButton(){
        showEmployeeInfo();
    }

    private void setFiltersItems(){
        filtersList.forEach(filter->{
            new FiltersDaoImpl().getFilterItems(filter);
            filter.setFilterGui();
        });
    }
}
