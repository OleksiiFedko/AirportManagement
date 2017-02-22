package main.daoimpl;

import main.DataBaseUtil;
import main.dao.ClassTypeDao;
import main.entities.ClassTypeEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassTypeDaoImpl extends DataBaseUtil implements ClassTypeDao{
    private Connection con;
    private PreparedStatement prst;
    private ResultSet rs;
    private String query = "SELECT ClassName FROM ClassType";

    private List<String> classTypeList = new ArrayList<>();

    @Override
    public List<String> getClassType() {
        try {
            con = getConnectionDb();
            if (con != null) {
                prst = con.prepareStatement(query);
                rs = prst.executeQuery();
                if (!rs.isBeforeFirst()) {
                    System.out.printf("No data");
                }
                while (rs.next()) {
                    String className = rs.getString(1);
                    classTypeList.add(className);
                }
            }
        } catch (SQLException sqlE) {
            System.out.printf("Connection problem");
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException se) { /*can't do anything */ }
            try {
                if (con != null) {
                    prst.close();
                }
            } catch (SQLException se) { /*can't do anything */ }
            try {
                if (con != null) {
                    rs.close();
                }
            } catch (SQLException se) { /*can't do anything */ }

        }
        return classTypeList;
    }

    @Override
    public void deleteClassType(String className) {

    }

    @Override
    public void createClassType(ClassTypeEntity classTypeEntity) {

    }

    @Override
    public void updateClassType(ClassTypeEntity classTypeEntity) {

    }
}
