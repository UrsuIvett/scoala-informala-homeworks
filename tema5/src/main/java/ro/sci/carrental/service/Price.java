package ro.sci.carrental.service;

/**
 * Created by Ivett on 13-Jun-17.
 */

/** The Price class contains the value and the currency
 * the currency should be: EUR, USD, RON,
 * it doesn't count the exchange value
 */

public class Price {


    private double price;
    private Currency currency;

    public Price(double price, Currency currency) {
        this.price = price;
        this.currency = currency;

    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Price price1 = (Price) o;

        if (Double.compare(price1.price, price) != 0) return false;
        return currency.equals(price1.currency);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(price);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + currency.hashCode();
        return result;
    }



}
