package entity;

public class Patient {
    //Properties
    private Long Id;
    private String Lastname;
    private String name;
    private String address;
    private Long idCard;

    //Constructor
    public Patient(String lastname, String name, String address, Long idCard) {
        Lastname = lastname;
        this.name = name;
        this.address = address;
        this.idCard = idCard;
    }

    //Getters and Setters
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
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

    public Long getIdNumber() {
        return idCard;
    }

    public void setIdNumber(Long idCard) {
        this.idCard = idCard;
    }

    //Methods
}
