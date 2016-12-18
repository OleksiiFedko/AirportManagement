package storage.dao;

import storage.entities.PassengersEntity;
import java.util.List;

public interface PassengersDao {
    /**
     * @return list of all passengers info
     */
    List<PassengersEntity> getAllPassengersInfo();

    /**
     * @return list of passengers info by flight number
     */
    List<PassengersEntity> getPassengersInfoFlightNum();

    PassengersEntity getPassenger(int id);

    void deletePassenger(int id);

    void createPassenger(PassengersEntity passengerInfo);

    void updatePassenger(PassengersEntity passengerInfo);
}
