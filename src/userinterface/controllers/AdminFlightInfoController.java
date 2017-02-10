package userinterface.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import storage.daoimpl.RootsDaoImpl;
import storage.entities.FlightsEntity;
import storage.entities.RootsEntity;
import userinterface.MainApp;

import java.io.IOException;

/**
 * Created by Alish on 19.01.2017.
 */
public class AdminFlightInfoController extends UserSceneController {
    private Stage stage;
    private MainApp mainApp;

    private KeyCombination keyCombClose = new KeyCodeCombination(KeyCode.ESCAPE);
    private KeyCombination keyCombOk = new KeyCodeCombination(KeyCode.ENTER);

    public void handleAddFlight(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/AddFlight.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Add New Flight");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(mainApp.getMainAppWindow());
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            FlightAddController flAddController = loader.getController();
            flAddController.setDialogStage(dialogStage);

            scene.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                    if (keyCombClose.match(event)) {
                        dialogStage.close();
                    } else if (keyCombOk.match(event)) {
                        flAddController.handleOk();
                    }
                }
            });

            dialogStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleEditFlight(ActionEvent actionEvent) {
        try {
            FlightsEntity markedFlight = flightsTable.getSelectionModel().getSelectedItem();
            if(markedFlight != null){
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource("view/EditFlight.fxml"));
                AnchorPane page = (AnchorPane) loader.load();

                Stage dialogStage = new Stage();
                dialogStage.setTitle("Edit Flight");
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.initOwner(mainApp.getMainAppWindow());
                Scene scene = new Scene(page);
                dialogStage.setScene(scene);

                // Передаём адресата в контроллер.
                FlightEditController flEditController = loader.getController();
                flEditController.setDialogStage(dialogStage);

                scene.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent event) {
                        if (keyCombClose.match(event)) {
                            dialogStage.close();
                        } else if (keyCombOk.match(event)) {
                            flEditController.handleOkEdit();
                        }
                    }
                });

                flEditController.setCurrentFlight(markedFlight);
                flEditController.setFlight(markedFlight.getFlightNumber());
                flEditController.setDepartureCity(markedFlight.getCityOfDeparture());
                flEditController.setArrivalCity(markedFlight.getCityOfArrival());
                flEditController.setClassFlight(markedFlight.getClassType());
         //       flEditController.setPrice(markedFlight.getClassPrice());
                flEditController.setStatus(markedFlight.getFlightStatus());

                dialogStage.showAndWait();
                showFlightsInfo();
            } else {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource("view/ErrorLayout.fxml"));
                AnchorPane page = (AnchorPane) loader.load();
                Stage dialogStage = new Stage();
                dialogStage.setTitle("ERROR");
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.initOwner(mainApp.getMainAppWindow());
                Scene scene = new Scene(page);
                dialogStage.setScene(scene);
                ErrorController errorController = loader.getController();
                errorController.setDialogStage(dialogStage);
                errorController.setErrorLabel("Please choose flight for editing!");

                scene.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent event) {
                        if (keyCombOk.match(event)) {
                            errorController.handleOkError();
                        }
                    }
                });

                dialogStage.showAndWait();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleDeleteFlight(ActionEvent actionEvent) {
        try {
            FlightsEntity markedEmployee = flightsTable.getSelectionModel().getSelectedItem();
            if (markedEmployee != null) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource("view/DeleteFlight.fxml"));
                AnchorPane page = (AnchorPane) loader.load();

                Stage dialogStage = new Stage();
                dialogStage.setTitle("Delete Flight");
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.initOwner(mainApp.getMainAppWindow());
                Scene scene = new Scene(page);
                dialogStage.setScene(scene);

                // Передаём адресата в контроллер.
                FlightDeleteController flDeleteController = loader.getController();
                flDeleteController.setDialogStage(dialogStage);

                scene.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent event) {
                        if (keyCombClose.match(event)) {
                            dialogStage.close();
                        } else if (keyCombOk.match(event)) {
                            flDeleteController.handleOkDelete();
                        }
                    }
                });

                dialogStage.showAndWait();
                RootsDaoImpl rootsDao = new RootsDaoImpl();
                boolean okClicked = flDeleteController.isOkClicked();
                if(okClicked){
                    rootsDao.deleteRoot(markedEmployee.getId());
                }
                showFlightsInfo();
            } else {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource("view/ErrorLayout.fxml"));
                AnchorPane page = (AnchorPane) loader.load();
                Stage dialogStage = new Stage();
                dialogStage.setTitle("ERROR");
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.initOwner(mainApp.getMainAppWindow());
                Scene scene = new Scene(page);
                dialogStage.setScene(scene);
                ErrorController errorController = loader.getController();
                errorController.setDialogStage(dialogStage);
                errorController.setErrorLabel("Do you want delete this flight?");

                scene.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent event) {
                        if (keyCombOk.match(event)) {
                            errorController.handleOkError();
                        }
                    }
                });

                dialogStage.showAndWait();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setMainApp(MainApp mainApp) {
        this.mainApp = (mainApp);
    }

    @Override
    public MainApp getMainApp() {
        return mainApp;
    }



}
