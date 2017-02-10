package storage.dao;

import storage.entities.FlightsEntity;
import java.util.List;

public interface FlightsDao {
    /**
     * @return list that contains all flights
     */
    List<FlightsEntity> getAllFlights();

    /**
     * @param number
     * @return list that contains flights with selected number
     */
    List<FlightsEntity> getFlightByNumber(String number);

    /**
     * @param cityOfDeparture
     * @return list that contains flight with selected city of departure
     */
    List<FlightsEntity> getFlightByCityDeparture(String cityOfDeparture);

    /**
     * @param cityOfArrival
     * @return list that contains flight with selected city of arrival
     */
    List<FlightsEntity> getFlightByCityArival(String cityOfArrival);

    /**
     *
     * @param cityOfArrival
     * @param cityOfDeparture
     * @return list that contains flight with selected city of departure and arrival
     */
    List<FlightsEntity> getFlightByDepartureArival(String cityOfArrival, String cityOfDeparture);

    void deleteFLight(FlightsEntity flightsEntity);

    void createFlight(FlightsEntity flightsEntity);

    void updateFlight(FlightsEntity id);
}
