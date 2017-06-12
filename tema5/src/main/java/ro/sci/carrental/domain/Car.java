package ro.sci.carrental.domain;

import ro.sci.carrental.repository.CarRepositoryImpl;

/**
 * Created by Ivett on 20-May-17.
 */
public class Car {
    private String make;
    private String model;
    private FuelType fuelType;
    private float size;
    private String color;
    private String category;
    private int nrSeats;
    private int nrDoors;
    private GearBoxType gearBoxType;
    private boolean airCondition;
    private boolean gps;
    private boolean available;
    private boolean working;
    private double pricePerDay;  /* in euro/
/*
 Car constructor
 */

    public Car(String make, String model, FuelType fuelType, float size, String color, String category, int nrSeats, int nrDoors, GearBoxType gearBoxType, boolean airCondition, boolean gps, boolean available, boolean working, double pricePerDay) {
        this.make = make;
        this.model = model;
        this.fuelType = fuelType;
        this.size = size;
        this.color = color;
        this.category = category;
        this.nrSeats = nrSeats;
        this.nrDoors = nrDoors;
        this.gearBoxType = gearBoxType;
        this.airCondition = airCondition;
        this.gps = gps;
        this.available = available;
        this.working = working;
        this.pricePerDay = pricePerDay;
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
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
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

    /*
         Gets the price per day of the current car
         @returns price per day of the current car
         */
    public double getPricePerDay(CarRepositoryImpl carRepository) {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
}

