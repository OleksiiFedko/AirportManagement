package storage.dao;

import storage.entities.RootsEntity;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class LoginDaoImpl implements LoginDao{

    private String url;
    private String user;
    private String password;
    private RootsEntity appUser;
    private Connection con;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public LoginDaoImpl(){
        setDataBaseProperties();
    }

    private Connection getConnection(){
        try {
            return DriverManager.getConnection(this.url, this.user, this.password);
        } catch(SQLException sqlEx){
            System.out.println("Can't connect to the DataBase");
            return null;
        }
    }

    @Override
    public void setDataBaseProperties() {

        Properties prop = new Properties();
        InputStream input = null;

        try {
            input = new FileInputStream("src/mysql.properties");
            prop.load(input);

            this.url = prop.getProperty("database");
            this.user = prop.getProperty("dbuser");
            this.password = prop.getProperty("dbpassword");

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Override
    public boolean checkAppUser(String appUserLogin, String appUserPassword) {

        String query = "SELECT idRoots, RootName, Login, Password FROM Roots WHERE Login=? AND Password=?";

        try {

            con = getConnection();

            if (con != null){

                pstmt = con.prepareStatement(query);
                pstmt.setString(1, appUserLogin);
                pstmt.setString(2, appUserPassword);

                rs = pstmt.executeQuery();

                if (!rs.isBeforeFirst() ) {
                    System.out.println("No data");
                    return false;
                }


                while (rs.next()) {
                    int userId = rs.getInt(1);
                    String userName = rs.getString(2);
                    String userLogin = rs.getString(3);
                    String userPassword = rs.getString(4);
                    if (appUserLogin.equals(userLogin) && appUserPassword.equals(userPassword)) {
                        appUser = new RootsEntity(userId ,userName, userLogin, userPassword);
                        return true;
                    }
                }
            }

        } catch (SQLException sqlEx) {
            //sqlEx.printStackTrace();
            System.out.println("Problems with connection");
            return false;
        } finally {
            try { if(con!=null){con.close();} } catch(SQLException se) { /*can't do anything */ }
            try { if(con!=null){pstmt.close();} } catch(SQLException se) { /*can't do anything */ }
            try { if(con!=null){rs.close();} } catch(SQLException se) { /*can't do anything */ }
        }
        return false;
    }

    @Override
    public RootsEntity getAppUser() {
        return this.appUser;
    }
}
