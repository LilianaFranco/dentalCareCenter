package entity;

import org.apache.log4j.Logger;

public class Dentist {

    //Properties
    private int id;
    private int dentalLicense;
    private String lastName;
    private String name;

    private static final Logger LOGGER = Logger.getLogger(Dentist.class);

    //Constructor
    public Dentist(int id, int dentalLicense, String lastName, String name) {
        this.id = id;
        this.dentalLicense = dentalLicense;
        this.lastName = lastName;
        this.name = name;
    }

    public Dentist() { }

    //Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDentalLicense() {
        return dentalLicense;
    }

    public void setDentalLicense(int dentalLicense) {
        this.dentalLicense = dentalLicense;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Methods
}
