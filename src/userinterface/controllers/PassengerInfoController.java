package userinterface.controllers;

import businesslogic.GuiFilter;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import storage.daoimpl.FiltersDaoImpl;
import storage.daoimpl.PassengersDaoImpl;
import storage.entities.PassengersEntity;
import userinterface.MainApp;
import userinterface.utils.SplitPaneDividerSlider;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PassengerInfoController extends Controller implements Initializable{
    private Stage stage;
    private MainApp mainApp;
    private ManagerController managerController;

    @FXML private ChoiceBox flightNumberBox;
    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private TextField passportField;

    @FXML private TableView<PassengersEntity> passengersTable;
    @FXML private TableColumn<ObservableList<PassengersEntity>, String> numberColumn;
    @FXML private TableColumn<PassengersEntity, String> firstNameColumn;
    @FXML private TableColumn<PassengersEntity, String> lastNameColumn;
    @FXML private TableColumn<PassengersEntity, String> nationalityColumn;
    @FXML private TableColumn<PassengersEntity, String> birthdayColumn;
    @FXML private TableColumn<PassengersEntity, String> passportColumn;
    @FXML private TableColumn<PassengersEntity, String> sexColumn;
    @FXML private TableColumn<PassengersEntity, String> classTypeColumn;
    @FXML private TableColumn<PassengersEntity, String> flightNumColumn;

    @FXML private AnchorPane leftFilters;
    @FXML private ToggleButton leftToggleButton;
    @FXML private SplitPane centerSplitPane;
    @FXML private SplitPane mainSplitPane;

    private final int ROWS_PER_PAGE = 15;
    private int currentPage = 1;

    private ObservableList<PassengersEntity> passengersData = FXCollections.observableArrayList();
    private List<GuiFilter> filtersList = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setFiltersPaneAnimation();
        setFiltersItems();
        initTableView();
        showPassengersInfo();
    }

    private void showPassengersInfo() {
        passengersData.clear();
        PassengersDaoImpl passengersDao = new PassengersDaoImpl();
        List<PassengersEntity> passengersListDB = passengersDao.getAllFilteredPassangers(filtersList);
        if (passengersListDB != null) {
            passengersData.addAll(FXCollections.observableList(passengersListDB));
            passengersTable.setItems(passengersData);
        }
    }

    private void initTableView() {
        numberColumn.setCellValueFactory(cellData -> {
            int index = cellData.getTableView().getItems().indexOf(cellData.getValue());
            return new SimpleStringProperty(String.valueOf((index+1)+(currentPage-1)*ROWS_PER_PAGE));
        });
        numberColumn.setSortable(false);

        firstNameColumn.setCellValueFactory(
                cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(
                cellData -> cellData.getValue().lastNameProperty());
        nationalityColumn.setCellValueFactory(
                cellData -> cellData.getValue().nationalityProperty());
        birthdayColumn.setCellValueFactory(
                cellData -> cellData.getValue().birthdayProperty());
        passportColumn.setCellValueFactory(
                cellData -> cellData.getValue().passportProperty());
        sexColumn.setCellValueFactory(
                cellData -> cellData.getValue().sexProperty());
        classTypeColumn.setCellValueFactory(
                cellData -> cellData.getValue().classTypeProperty());
        flightNumColumn.setCellValueFactory(
                cellData -> cellData.getValue().flightNumProperty());
    }

    @FXML
    public void handleAddPassenger() {
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
            dialogStage.initOwner(mainApp.getMainAppWindow());
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            // Передаём адресата в контроллер.
            PassengersAddingController pAController = loader.getController();
            pAController.setDialogStage(dialogStage);
            // Отображаем диалоговое окно и ждём, пока пользователь его не закроет
            dialogStage.showAndWait();
//            return true;
        } catch (IOException e) {
            e.printStackTrace();
//            return false;
        }
    }

    @FXML
    public void handleEditPassenger() {
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
            dialogStage.initOwner(mainApp.getMainAppWindow());
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
    public void handleDeletePassenger() {
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
            dialogStage.initOwner(mainApp.getMainAppWindow());
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
        showPassengersInfo();
    }

    @FXML
    public void handleSearchButton(){
        showPassengersInfo();
    }

    private void setFiltersItems(){
        filtersList.forEach(filter->{
            new FiltersDaoImpl().getFilterItems(filter);
            filter.setFilterGui();
        });
    }
}
