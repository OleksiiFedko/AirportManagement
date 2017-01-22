package storage.entities;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class RootsEntity {
    private SimpleIntegerProperty idRoots;
    private SimpleStringProperty login;
    private SimpleStringProperty password;
    private SimpleStringProperty rootName;

    public RootsEntity (int idRoots, String login, String password, String rootName){
        this.idRoots = new SimpleIntegerProperty(idRoots);
        this.login = new SimpleStringProperty(login);
        this.password =new SimpleStringProperty(password);
        this.rootName = new SimpleStringProperty(rootName);
    }

    public int getIdRoots() {
        return idRoots.get();
    }

    public void setIdRoots(int idRoots) {
        this.idRoots.set(idRoots);
    }

    public String getLogin() {
        return login.get();
    }

    public void setLogin(String login) {
        this.login.set(login);
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getRootName() {
        return rootName.get();
    }

    public void setRootName(String rootName) {
        this.rootName.set(rootName);
    }

    public SimpleIntegerProperty idRoots(){
        return idRoots;
    }

    public StringProperty loginProperty(){
        return login;
    }

    public StringProperty passwordProperty(){
        return password;
    }

    public StringProperty rootNameProperty(){
        return rootName;
    }
}
