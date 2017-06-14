package main.java.ro.sci.carrental.service;

/**
 * Created by Ivett on 13-Jun-17.
 */
public class PricePerDay {
    private double price;
    private String currency;


    public PricePerDay() {
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
