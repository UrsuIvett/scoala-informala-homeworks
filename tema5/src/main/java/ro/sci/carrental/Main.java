package ro.sci.carrental;

import ro.sci.carrental.domain.Car;
import ro.sci.carrental.domain.FuelType;
import ro.sci.carrental.domain.GearBoxType;
import ro.sci.carrental.repository.CarRepositoryImpl;
import ro.sci.carrental.service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivett on 24-May-17.
 */
public class Main {

    public static void main(String[] args) {

        List<Car> carList = new ArrayList<Car>();

        Car Ford = new Car("Ford", "Focus", FuelType.DIESEL, 1600, "Black", "Break", 5, 5, GearBoxType.MANUAL, true, true, true, true, 20);
        Car VW = new Car("Volkswagen", "Golf", FuelType.PETROL, 1400, "Silver", "Hatchback", 4, 5, GearBoxType.MANUAL, false, false, true, true, 10);
        Car Skoda = new Car("Skoda", "Octavia", FuelType.DIESEL, 1900, "Green", "Sedan", 5, 4, GearBoxType.AUTO, true, false, true, true, 15);
        Car Opel = new Car("Skoda", "Superb", FuelType.DIESEL, 1700, "Green", "Monovolum", 7, 5, GearBoxType.MANUAL, true, true, true, true, 30);


        carList.add(Ford);
        carList.add(VW);
        carList.add(Skoda);
        carList.add(Opel);

        searching(carList);
    }

    private static void searching(List<Car> carList) {

        System.out.println("Cars from the GARAGE");

       for (Car car : carList) {
            System.out.println(car.getMake()+ " " + car.getModel());
        }
        System.out.println("Cars after search by make");

        CarServiceImpl searchByMake = new CarServiceImpl(carList);
        List<Car> foundCarsByMake = searchByMake.findCarsByMake("Skoda");

        for (Car car : foundCarsByMake) {
            System.out.println(car.getMake()+ " " + car.getModel());
        }
        System.out.println("Cars after the search by make & model");

        CarServiceImpl searchByMakeAndModel = new CarServiceImpl(carList);
        List<Car> foundCarsByMakeAndModel = searchByMakeAndModel.findCarsByMakeAndModel("Skoda", "Octavia");

        for (Car car : foundCarsByMakeAndModel) {
            System.out.println(car.getMake() + " " + car.getModel());
        }
        System.out.println("Cars after the search by make & model & color");

        CarServiceImpl searchMultiple = new CarServiceImpl(carList);
        List<Car> foundCarsByMultipleCategories = searchMultiple.findCarsByMultipleCategories("Skoda", "Octavia", "Green");

        for (Car car : foundCarsByMultipleCategories) {
            System.out.println(car.getMake() + " " + car.getModel() + " " + car.getColor());
        }


    }
}


