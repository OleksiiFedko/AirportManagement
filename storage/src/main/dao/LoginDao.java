package main.dao;

import main.entities.RootsEntity;

public interface LoginDao {
    boolean checkAppUser(String appUserLogin, String appUserPassword);
    RootsEntity getAppUser();
}
