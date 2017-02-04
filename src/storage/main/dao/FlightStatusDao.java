package storage.main.dao;

import storage.main.entities.FlightStatusEntity;
import java.util.List;

public interface FlightStatusDao {
    /**
     * @return list that contains all flight statuses
     */
    List<FlightStatusEntity> getFlightStatus();

    void deleteFlightStatus(String flightStatus);

    void createFlightStatus(FlightStatusEntity flightStatusEntity);

    void updateFlightStatus(FlightStatusEntity flightStatusEntity);
}
