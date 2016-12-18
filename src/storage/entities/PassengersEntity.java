package storage.entities;

public class PassengersEntity {
    private int id;
    private String firstName;
    private String lastName;
    private String nationality;
    private String passport;
    private String birthday;
    private String sex;
    private String classType;
    private String flightNum;

    public PassengersEntity() {
    }

    public PassengersEntity(int id, String firstName, String lastName, String nationality, String passport, String birthday, String sex, String classType, String flightNum) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
        this.passport = passport;
        this.birthday = birthday;
        this.sex = sex;
        this.classType = classType;
        this.flightNum = flightNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }
}
