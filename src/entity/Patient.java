package entity;

import org.apache.log4j.Logger;

import java.time.LocalDate;

public class Patient {

    //Properties
    private int id;
    private int idCard;
    private String Lastname;
    private String name;
    private String address;
    private LocalDate registrationDate;

    public Patient(){}

    //Constructor
    public Patient(int id, int idCard, String lastname, String name, String address, LocalDate registrationDate) {
        this.id = id;
        this.idCard = idCard;
        Lastname = lastname;
        this.name = name;
        this.address = address;
        this.registrationDate = LocalDate.now();
    }

    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public int getIdCard(){
        return idCard;
    }
    public void setIdCard(int idCard) {
        this.idCard = idCard;
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

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    //Methods

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", idCard=" + idCard +
                ", Lastname='" + Lastname + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
