package storage.entities;

public class FlightsEntity {
    private int id;
    private String arrivalTime;
    private String departureTime;
    private String flightNumber;
    private String flightStatus;
    private String gate;
    private String terminal;
    private String cityOfDeparture;
    private String cityOfArival;

    public FlightsEntity() {
    }

    public FlightsEntity(int id, String arrivalTime, String departureTime, String flightNumber, String flightStatus, String gate, String terminal, String cityOfDeparture, String cityOfArival) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.flightNumber = flightNumber;
        this.flightStatus = flightStatus;
        this.gate = gate;
        this.terminal = terminal;
        this.cityOfDeparture = cityOfDeparture;
        this.cityOfArival = cityOfArival;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(String flightStatus) {
        this.flightStatus = flightStatus;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getCityOfDeparture() {
        return cityOfDeparture;
    }

    public void setCityOfDeparture(String cityOfDeparture) {
        this.cityOfDeparture = cityOfDeparture;
    }

    public String getCityOfArival() {
        return cityOfArival;
    }

    public void setCityOfArival(String cityOfArival) {
        this.cityOfArival = cityOfArival;
    }
}
