package entity;

import org.apache.log4j.Logger;

public class Dentist {

    //Properties
    private Long id;
    private int dentalLicense;
    private String lastName;
    private String name;
    private static final Logger LOGGER = Logger.getLogger(Dentist.class);

    //Constructor
    public Dentist(int dentalLicense, String lastName, String name) {
        this.dentalLicense = dentalLicense;
        this.lastName = lastName;
        this.name = name;
    }

    //Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
