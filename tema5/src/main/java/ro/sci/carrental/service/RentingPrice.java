package main.java.ro.sci.carrental.service;

import main.java.ro.sci.carrental.domain.car.Car;

/**
 * Created by Ivett on 30-Jun-17.
 */
/*
Calculates the Renting Price of a car by using generic types
T the Type of the value being boxed
 */
public class RentingPrice {

    public <T extends Car> Price calculateRentingPrince(T t, int daysNumber) {

         Price price = new Price(t.getPricePerDay().getPrice()*Math.abs(daysNumber), t.getPricePerDay().getCurrency().toUpperCase());
        return price;
    }

}
