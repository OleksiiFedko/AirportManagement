package storage.entities;

public class RootsEntity {
    private int id;
    private String rootName;
    private String login;
    private String password;

    public RootsEntity() {
    }

    public RootsEntity(int id, String rootName, String login, String password) {
        this.id = id;
        this.rootName = rootName;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRootName() {
        return rootName;
    }

    public void setRootName(String rootName) {
        this.rootName = rootName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
