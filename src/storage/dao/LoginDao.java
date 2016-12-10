package storage.dao;

import storage.entities.RootsEntity;

public interface LoginDao {
    boolean checkAppUser(String appUserLogin, String appUserPassword);
    RootsEntity getAppUser();
    void setDataBaseProperties();
}
