package userinterface.main.controllers;

import userinterface.main.MainApp;

public class Controller {
    private MainApp mainApp;
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    public MainApp getMainApp(){
        return this.mainApp;
    }
    public void logoutAction(){
        mainApp.setDefaultAppUser();
        mainApp.loadAppUserScene();
    }
}
