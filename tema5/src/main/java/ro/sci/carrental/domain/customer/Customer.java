package main.java.ro.sci.carrental.domain.customer;

/**
 * Created by Ivett on 28-May-17.
 */
public class Customer {
    private String firstName;
    private String lastName;
    private Adress adress;
    private String mobilNumber;

    public Customer() {
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

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public String getMobilNumber() {
        return mobilNumber;
    }

    public void setMobilNumber(String mobilNumber) {
        this.mobilNumber = mobilNumber;
    }
}

