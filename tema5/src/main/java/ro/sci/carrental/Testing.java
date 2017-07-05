package main.java.ro.sci.carrental;

import main.java.ro.sci.carrental.domain.car.Car;
import main.java.ro.sci.carrental.service.Price;
import main.java.ro.sci.carrental.service.RentingPrice;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Ivett on 01-Jul-17.
 */
public class Testing {

    /*
    / this should throw back an exception, the number of days should be a whole number >=1
     */
  @Test
  public void testZeroDays() {
      //given
      RentingPrice r1 = new RentingPrice();
      Car c1 = new Car();
      Price pricePerDay1 = new Price(2.5,"EURO");
      c1.setPricePerDay(pricePerDay1);
      int days=0;

      //then
      Price result = r1.calculateRentingPrince(c1,days);

      //evaluate
       Price expected = new Price(0,"EURO");
       assertEquals(expected,result);
  }

    @Test
    public void testNegativeDays() {
        //given
        RentingPrice r1 = new RentingPrice();
        Car c1 = new Car();
        Price pricePerDay1 = new Price(2.5,"EURO");
        c1.setPricePerDay(pricePerDay1);
        int days=-2;

        //then
        Price result = r1.calculateRentingPrince(c1,days);

        //evaluate
        Price expected = new Price(5,"EURO");
        assertEquals(expected,result);
    }

    @Test
    public void testDifferentCasesInCurrency() {
        //given
        RentingPrice r1 = new RentingPrice();
        Car c1 = new Car();
        Price pricePerDay1 = new Price(2.5,"eUro");
        c1.setPricePerDay(pricePerDay1);
        int days=10;

        //then
        Price result = r1.calculateRentingPrince(c1,days);

        //evaluate
        Price expected = new Price(25,"EURO");
        assertEquals(expected,result);
    }

    /* next test will be an exception,
    /
     */

    @Test
    public void testCreateInvalidCurrency() throws IllegalArgumentException {
        //given
        try {
            RentingPrice r1 = new RentingPrice();
            Car c1 = new Car();
            Price pricePerDay1 = new Price(2.5,"RKTL");
        }
        catch (IllegalArgumentException ex) {
        System.out.println("illegal argument");
        }

        }
       //c1.setPricePerDay(pricePerDay1);
       // int days=1;

        //then
        //Price result = r1.calculateRentingPrince(c1,days);

        //evaluate
       // Price expected = new Price(2.5,"EURO");
        //assertEquals(expected,result);
    }

