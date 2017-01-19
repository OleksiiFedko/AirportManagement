package userinterface.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import userinterface.MainApp;

import java.io.IOException;

import static javafx.application.Application.launch;

/**
 * Created by Alish on 07.12.2016.
 */
public class EmployeeInfoController extends Controller {

    private MainApp mainApp;

    public ObservableList<EmployeeController> employeeData = FXCollections.observableArrayList();

    @FXML
    private TableView<EmployeeController> tableEmployee;

    @FXML
    private TableColumn<EmployeeController, Integer> idRootsColumn;

    @FXML
    private TableColumn <EmployeeController, String> loginColumn;

    @FXML
    private TableColumn <EmployeeController, String> passwordColumn;

    @FXML
    private TableColumn <EmployeeController, String> rootNameColumn;

    @FXML
    private void initialize(){
        initData();

        idRootsColumn.setCellValueFactory(new PropertyValueFactory<EmployeeController, Integer>("idRoots"));
        loginColumn.setCellValueFactory(new PropertyValueFactory<EmployeeController, String>("login"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<EmployeeController, String>("password"));
        rootNameColumn.setCellValueFactory(new PropertyValueFactory<EmployeeController, String>("rootName"));

        tableEmployee.setItems(employeeData);

    }

    private void initData(){
        employeeData.add(new EmployeeController(1,"alex","xela","Meneger"));
        employeeData.add(new EmployeeController(2,"alish","hsila","Admin"));
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
            EmployeeAddController controller = loader.getController();
            controller.setDialogStage(dialogStage);


            // Отображаем диалоговое окно и ждём, пока пользователь его не закроет
            dialogStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
