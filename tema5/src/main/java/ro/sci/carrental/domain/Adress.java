package ro.sci.carrental.domain;

/**
 * Created by Ivett on 28-May-17.
 */
public class Adress {
    private String country;
    private String city;
    private String street;
    private int number;

    public Adress(String country, String city, String street, int number) {
    this.country= country;
    this.city=city;
    this.street=street;
    this.number=number;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

