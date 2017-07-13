package ro.sci.carrental;

import ro.sci.carrental.domain.car.Car;
import ro.sci.carrental.service.Currency;
import ro.sci.carrental.service.InvalidDaysNumberException;
import ro.sci.carrental.service.Price;
import ro.sci.carrental.service.RentingPrice;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertEquals;
import static ro.sci.carrental.service.Currency.EURO;

/**
 * Created by Ivett on 01-Jul-17.
 */
public class TestingRentingPrice {


    @Test
    public void testZeroDays()  {
       try {
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
       catch (InvalidDaysNumberException e) {
           System.out.println(e.getMessage());
       }
    }

    @Test
    public void testNegativeDays() {
        try {
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
        catch (InvalidDaysNumberException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testCreateInvalidCurrency() throws IllegalArgumentException{
        //given
        try {
        RentingPrice r1 = new RentingPrice();
        Car c1 = new Car();
        Currency cc = Currency.valueOf("rhLT");
        Price pricePerDay1 = new Price(2.5, cc);

        c1.setPricePerDay(pricePerDay1);
        int days = 1; }
        catch (IllegalArgumentException e) {
        System.out.println("Illegal currency! Please change it into: EURO/RON/USD/GBP. Please use UPPERCASE!");
        }
    }

}

