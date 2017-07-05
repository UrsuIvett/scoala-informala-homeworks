package main.java.ro.sci.carrental.domain;

import java.text.DateFormat;

/**
 * Created by Ivett on 20-May-17.
 */

public class RentalCalendar {
/* pickUpTime represents the start of the rental period, returnTime represents the end of the rental period
    the number of days
    the numberOfDays represents the difference between these two dates
    if we would like, we can offer gracePeriod to the clients,
     */
private DateFormat pickUpTime;
private DateFormat returnTime;
private int numberOfDays;
private int gracePeriod;

    public DateFormat getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(DateFormat pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public DateFormat getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(DateFormat returnTime) {
        this.returnTime = returnTime;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }
}

