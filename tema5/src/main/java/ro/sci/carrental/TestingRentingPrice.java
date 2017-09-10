package ro.sci.carrental;

import ro.sci.carrental.domain.car.Car;
import ro.sci.carrental.service.Currency;
import ro.sci.carrental.service.InvalidCurrencyException;
import ro.sci.carrental.service.Price;
import ro.sci.carrental.service.RentingPrice;
import org.junit.Test;
import static org.junit.Assert.*;
import static ro.sci.carrental.service.Currency.EURO;

/**
 * Created by Ivett on 01-Jul-17.
 */
public class TestingRentingPrice {


    @Test
    public void testZeroDays() throws InvalidCurrencyException {

           //given
           RentingPrice r1 = new RentingPrice();
           Car c1 = new Car();
           Price pricePerDay1 = new Price(2.5, EURO);
           c1.setPricePerDay(pricePerDay1);
           int days = 0;
           //then
           Price result = r1.calculateRentingPrince(c1, days);

           //evaluate
           Price expected = new Price(0, EURO);
           assertEquals(expected, result);
    }

    @Test
    public void testNegativeDays() throws InvalidCurrencyException {

        //given
        RentingPrice r1 = new RentingPrice();
        Car c1 = new Car();
        Price pricePerDay1 = new Price(2.5, EURO);
        c1.setPricePerDay(pricePerDay1);
        int days = -2;

        //then
        Price result = r1.calculateRentingPrince(c1, days);

        //evaluate
        Price expected = new Price(5, EURO);
        assertEquals(expected, result);


    }

    @Test (expected=IllegalArgumentException.class)
    public void testCreateInvalidCurrency() throws InvalidCurrencyException{
        //given
        RentingPrice r1 = new RentingPrice();
        Car c1 = new Car();
        Currency cc = Currency.valueOf("KLT");
        Price pricePerDay1 = new Price(2.5, cc);

    }

}

