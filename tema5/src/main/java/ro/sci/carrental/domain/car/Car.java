package ro.sci.carrental.domain.car;

import ro.sci.carrental.service.Price;

/**
 * Created by Ivett on 20-May-17.
 */
public class Car {

    private String make;
    private String model;
    private FuelType fuelType;
    private float size;
    private String color;
    private Category category;
    private int nrSeats;
    private int nrDoors;
    private GearBoxType gearBoxType;
    private boolean airCondition;
    private boolean gps;
    private boolean available;
    private boolean working;
    private String  number;
    private Price pricePerDay;
/*
 Car constructor
 */

    public Car() {
    }

    /*
        Gets the make of a car
        @returns String representing the make of a car
        */
    public String getMake() {return make; }

    public void setMake(String make) {
        this.make = make;
    }

    /*
        Gets the model of a car
        @returns String representing the model of a car
         */
    public String getModel() {return model; }

    public void setModel(String model) {
        this.model = model;
    }

    /*
        Gets the FuelType of a car
        @returns FuelType representing the fueltype of a car: petrol or diesel
        */
    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    /*
        Gets the size of the engine
        @returns int representing the size of the engine of the current car
        */
    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    /*
        Gets the color of the car
        @returns String representing the color of the current car
        */
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    /*
        Gets the category of the car, for ex. hatchback, sport, break, etc.
        @returns String representing the category of the current car
        */
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    /*
        Gets the number of the seats in a car
        @returns int representing the number of the seats in the current car
        */
    public int getNrSeats() {
        return nrSeats;
    }

    public void setNrSeats(int nrSeats) {
        this.nrSeats = nrSeats;
    }

    /*
        Gets the number of the doors for a car
        @returns int representing the number of the doors for the current car
        */
    public int getNrDoors() {
        return nrDoors;
    }

    public void setNrDoors(int nrDoors) {
        this.nrDoors = nrDoors;
    }

    /*
        Gets the gearbox type of a cars
        @returns gearbox type of a car: automatic, or manual
        */
    public GearBoxType getGearBoxType() {
        return gearBoxType;
    }

    public void setGearBoxType(GearBoxType gearBoxType) {
        this.gearBoxType = gearBoxType;
    }

    /*
    hasAircondition, hasGps, isAvaible, isWorking are getters, and return boolean type
     */

    public boolean hasAirCondition() {
        return airCondition;
    }

    public void setAirCondition(boolean airCondition) {
        this.airCondition = airCondition;
    }

    public boolean hasGps() {
        return gps;
    }

    public void setGps(boolean gps) {
        this.gps = gps;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Price getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Price pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    /*

         equals method
         */
/** two objects of Car type are equal if their number is equal (if their make or model is equal it doesn't mean that
 * they are equal)
 */


    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (make != car.make) return false;
        if (model != null ? !model.equals(car.model): car.model != null ) return false;

        return number != null ? number.equals(car.number) : car.number ==  null ;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", fuelType=" + fuelType +
                ", size=" + size +
                ", color='" + color + '\'' +
                ", category=" + category +
                ", nrSeats=" + nrSeats +
                ", nrDoors=" + nrDoors +
                ", gearBoxType=" + gearBoxType +
                ", airCondition=" + airCondition +
                ", gps=" + gps +
                ", available=" + available +
                ", working=" + working +
                ", number='" + number + '\'' +
                ", pricePerDay=" + pricePerDay +
                '}';
    }
}

