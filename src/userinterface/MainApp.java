package userinterface;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import storage.entities.PassengersEntity;

import java.io.IOException;

/**
 * Created by Алексей on 19.11.2016.
 */
public class MainApp extends Application implements EventHandler<ActionEvent>{

    private Stage primaryStage;

    private BorderPane rootLayout, rootLayout2;

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public BorderPane getRootLayout() {
        return rootLayout;
    }

    public BorderPane getRootLayout2() {
        return rootLayout2;
    }

    public MainApp() {

    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Brain Academy Air-flight management system");
        this.primaryStage.getIcons().add(new Image("file:src/userinterface/resources/images/brain_logo_32.png"));
        initRootLayout();
        //showPersonOverview();

    }

    @Override
    public void handle(ActionEvent event) {

    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
            StaffController staffController = loader.getController();
            staffController.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initFlighrLayout(){
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout2.fxml"));
            rootLayout = (BorderPane) loader.load();
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
            StaffController staffController = loader.getController();
            staffController.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showPassengerAddingDialog() {
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
            dialogStage.initOwner(primaryStage);
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

    public void showPassengerEditingDialog(){
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
            dialogStage.initOwner(primaryStage);
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

    public void showPassengerDeleteDialog(){
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
            dialogStage.initOwner(primaryStage);
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

    public static void main(String[] args) {
        PassengersEntity pe = new PassengersEntity(1, "Mariia", "Petrova", "Ukrainian", "ME832289", "28.06.1991", "Woman", "vip", "A2806");
        launch(args);
    }
}