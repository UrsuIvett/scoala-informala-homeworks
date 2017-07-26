package ro.sci.carrental.reader;

import ro.sci.carrental.domain.car.Car;

import java.util.ArrayList;

/**
 * Created by Ivett on 26-Jul-17.
 */
public class CarToString {
    public String convertToString(Car car) throws InvalidEntityException {
        String current;
        current=car.getMake()+" ";
        current=current+car.getModel()+" ";
        current=current+String.valueOf(car.getFuelType())+" ";
        current=current+String.valueOf(car.getSize())+" ";
        current=current+car.getColor()+" ";
        current=current+String.valueOf(car.getCategory())+" ";
        current=current+String.valueOf(car.getNrSeats())+" ";
        current=current+String.valueOf(car.getNrDoors())+" ";
        current=current+String.valueOf(car.getGearBoxType())+" ";
        current=current+String.valueOf(car.hasAirCondition())+" ";
        current=current+String.valueOf(car.hasGps())+" ";
        current=current+String.valueOf(car.isAvailable())+" ";
        current=current+String.valueOf(car.isWorking())+" ";
        current=current+car.getNumber()+" ";
        current=current+String.valueOf(car.getPricePerDay().getPrice())+" ";
        current=current+String.valueOf(car.getPricePerDay().getCurrency())+" ";
        return current;
    }
}
