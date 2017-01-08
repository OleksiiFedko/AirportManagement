package storage.daoimpl;

import businesslogic.GuiFilter;
import storage.DataBaseUtil;
import storage.dao.PassengersDao;
import storage.entities.PassengersEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PassengersDaoImpl extends DataBaseUtil implements PassengersDao{
    private Connection con;
    private PreparedStatement prst;
    private ResultSet rs;
    private String query = "SELECT idPassenger, " +
            "FirstName, LastName, " +
            "Nationality, Passport, " +
            "Birthday, Sex, " +
            "ClassType, FlightNumber FROM PassengersInfo";

    private List<PassengersEntity> passengersList = new ArrayList<>();

    @Override
    public List<PassengersEntity> getAllPassengersInfo() {
        try{
            con = getConnectionDb();
            if(con != null) {
                prst = con.prepareStatement(query);
                rs = prst.executeQuery();
                if (!rs.isBeforeFirst()) {
                    System.out.printf("No data");
                }
                while (rs.next()) {
                    int passengerId = rs.getInt(1);
                    String firstName = rs.getString(2);
                    String lastName = rs.getString(3);
                    String nationality = rs.getString(4);
                    String passport = rs.getString(5);
                    String birthday = rs.getString(6);
                    String sex = rs.getString(7);
                    String classType = rs.getString(8);
                    String flightNum = rs.getString(9);

                    PassengersEntity currentPassenger = new PassengersEntity(
                            passengerId,
                            firstName,
                            lastName,
                            nationality,
                            passport,
                            birthday,
                            sex,
                            classType,
                            flightNum
                    );
                    passengersList.add(currentPassenger);
                }
            }
        } catch (SQLException sqlE){
            System.out.printf("Connection problem");
        } finally {
            try { if(con!=null){con.close();} } catch(SQLException se) { /*can't do anything */ }
            try { if(con!=null){prst.close();} } catch(SQLException se) { /*can't do anything */ }
            try { if(con!=null){rs.close();} } catch(SQLException se) { /*can't do anything */ }

        }
        return passengersList;
    }

    public List<PassengersEntity> getAllFilteredPassengers(List<GuiFilter> filtersList){
        ArrayList<String> filterValuers = new ArrayList<>();
        filtersList.forEach(filter->{
            if (filter.getSelectedValue()!=null) {
                String filteredString;
                filterValuers.add(filter.getSelectedValue());
//                String tableShortName = "a.";
//                if (filter.getSqlField().equals("ClassType") || filter.getSqlField().equals("Price")){
//                    tableShortName = "b.";
//                }
                if (filterValuers.size() == 1) {
                    filteredString = " WHERE " + filter.getSqlField() + "='"+ filter.getSelectedValue()+"'";
                } else {
                    filteredString = " AND " + filter.getSqlField() + "='"+ filter.getSelectedValue()+"'";
                }
                query = query+filteredString;
                // System.out.println(query)
            }
        });
        return getAllPassengersInfo();
    }

    @Override
    public List<PassengersEntity> getPassengersInfoFlightNum() {
        return null;
    }

    @Override
    public PassengersEntity getPassenger(int id) {
        return null;
    }

    @Override
    public void deletePassenger(int id) {

    }

    @Override
    public void createPassenger(PassengersEntity passengerInfo) {

    }

    @Override
    public void updatePassenger(PassengersEntity passengerInfo) {

    }
}
