package entity;

import org.apache.log4j.Logger;

import java.time.LocalDate;

public class Patient {

    //Properties
    private int Id;
    private int idCard;
    private String Lastname;
    private String name;
    private String address;
    private LocalDate registrationDate;

    private static final Logger LOGGER = Logger.getLogger(Patient.class);

    //Constructor
    public Patient(String lastname, String name, String address, int idCard) {
        Lastname = lastname;
        this.name = name;
        this.address = address;
        this.idCard = idCard;
        this.registrationDate = LocalDate.now();
        LOGGER.info("El paciente fue creado");
    }

    //Getters and Setters
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIdNumber() {
        return idCard;
    }

    public void setIdNumber(int idCard) {
        this.idCard = idCard;
    }

    //Methods
}
