package ro.sci.carrental.service;

import ro.sci.carrental.domain.car.Car;

/**
 * Created by Ivett on 30-Jun-17.
 */
/*
Calculates the Renting Price of a car by using generic types
T the Type of the value being boxed
the method uses the absolute value of the daysNumber
 */
public class RentingPrice  {

    public <T extends Car> Price calculateRentingPrince(T t, int daysNumber) throws InvalidDaysNumberException {

        if (daysNumber<= 0){
            throw new InvalidDaysNumberException("The number of days must be > 0 !");
        }
         Price price = new Price(t.getPricePerDay().getPrice()*Math.abs(daysNumber), t.getPricePerDay().getCurrency());
        return price;
    }

}
