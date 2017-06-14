package main.java.ro.sci.carrental;

import main.java.ro.sci.carrental.domain.car.Car;
import main.java.ro.sci.carrental.domain.car.FuelType;
import main.java.ro.sci.carrental.domain.car.GearBoxType;
import main.java.ro.sci.carrental.domain.customer.Customer;
import main.java.ro.sci.carrental.service.CarServiceImpl;
import main.java.ro.sci.carrental.domain.customer.Adress;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivett on 24-May-17.
 */
public class Main {

    public static void main(String[] args) {

        List<Car> carList = new ArrayList<Car>();

        Car Ford = new Car();
        Ford.setMake("Ford");
        Ford.setModel("Focus");
        Ford.setFuelType(FuelType.DIESEL);
        Ford.setSize(1600);
        Ford.setColor("Black");
        Ford.setCategory("Break");
        Ford.setNrSeats(5);
        Ford.setNrDoors(5);
        Ford.setGearBoxType(GearBoxType.MANUAL);
        Ford.setAirCondition(true);
        Ford.setGps(true);
        Ford.setAvailable(true);
        Ford.setWorking(true);

        Car VW = new Car();
        VW.setMake("Volkswagen");
        VW.setModel("Golf");
        VW.setFuelType(FuelType.PETROL);
        VW.setSize(1400);
        VW.setColor("Silver");
        VW.setCategory("Hatchback");
        VW.setNrSeats(4);
        VW.setNrDoors(5);
        VW.setGearBoxType(GearBoxType.MANUAL);
        VW.setAirCondition(false);
        VW.setGps(false);
        VW.setAvailable(true);
        VW.setWorking(true);

        Car Skoda1 = new Car();
        Skoda1.setMake("Skoda");
        Skoda1.setModel("Octavia");
        Skoda1.setFuelType(FuelType.DIESEL);
        Skoda1.setSize(1900);
        Skoda1.setColor("Green");
        Skoda1.setCategory("Sedan");
        Skoda1.setNrSeats(5);
        Skoda1.setNrDoors(4);
        Skoda1.setGearBoxType(GearBoxType.AUTO);
        Skoda1.setAirCondition(true);
        Skoda1.setGps(false);
        Skoda1.setAvailable(true);
        Skoda1.setWorking(true);

        Car Skoda2 = new Car();
        Skoda2.setMake("Skoda");
        Skoda2.setModel("Superb");
        Skoda2.setFuelType(FuelType.DIESEL);
        Skoda2.setSize(1700);
        Skoda2.setColor("Green");
        Skoda2.setCategory("Monovolum");
        Skoda2.setNrSeats(7);
        Skoda2.setNrDoors(5);
        Skoda2.setGearBoxType(GearBoxType.MANUAL);
        Skoda2.setAirCondition(true);
        Skoda2.setGps(true);
        Skoda2.setAvailable(true);
        Skoda2.setWorking(true);

        carList.add(Ford);
        carList.add(VW);
        carList.add(Skoda1);
        carList.add(Skoda2);

        List<Customer> customers = new ArrayList<Customer>();

        Customer customer1 = new Customer();
        customer1.setFirstName("Captain");
        customer1.setLastName("Hook");
        customer1.setMobilNumber("0264-444555");
        Adress adress1 = new Adress();
        adress1.setCountry("Romania");
        adress1.setCounty("Cluj");
        adress1.setCity("Cluj");
        adress1.setStreet("Emil Isac");
        adress1.setNumber(15);

        Customer customer2 = new Customer();
        customer2.setFirstName("Charlie");
        customer2.setLastName("Gordon");
        customer2.setMobilNumber("0263-444666");
        Adress adress2 = new Adress();
        adress2.setCountry("Romania");
        adress2.setCounty("Mures");
        adress2.setCity("Targu Mures");
        adress2.setStreet("Mihai Eminescu");
        adress2.setNumber(3);

        Customer customer3 = new Customer();
        customer3.setFirstName("Louis");
        customer3.setLastName("Griffin");
        customer3.setMobilNumber("0261-124666");
        Adress adress3 = new Adress();
        adress3.setCountry("Romania");
        adress3.setCounty("Bucuresti");
        adress3.setCity("Bucuresti");
        adress3.setStreet("Comedy");
        adress3.setNumber(10);

        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);

        System.out.println("Our customers: ");

        for (Customer c : customers) {
            System.out.println(c.getFirstName()+ " " + c.getLastName() + ", " + "mobile number:" + c.getMobilNumber());
        }

        System.out.println(" ");

        searching(carList);
    }

    private static void searching(List<Car> carList) {

        System.out.println("Cars from the GARAGE");

       for (Car car : carList) {
            System.out.println(car.getMake()+ " " + car.getModel());
        }

        System.out.println(" ");
        System.out.println("Cars after search by make: ");

        CarServiceImpl searchByMake = new CarServiceImpl(carList);
        List<Car> foundCarsByMake = searchByMake.findCarsByMake("Skoda");

        for (Car car : foundCarsByMake) {
            System.out.println(car.getMake()+ " " + car.getModel());
        }
        System.out.println(" ");
        System.out.println("Cars after the search by make & model: ");

        CarServiceImpl searchByMakeAndModel = new CarServiceImpl(carList);
        List<Car> foundCarsByMakeAndModel = searchByMakeAndModel.findCarsByMakeAndModel("Skoda", "Octavia");

        for (Car car : foundCarsByMakeAndModel) {
            System.out.println(car.getMake() + " " + car.getModel());
        }

        System.out.println(" ");
        System.out.println("Cars after the search by make & model & color: ");

        CarServiceImpl searchMultiple = new CarServiceImpl(carList);
        List<Car> foundCarsByMultipleCategories = searchMultiple.findCarsByMultipleCategories("Skoda", "Octavia", "Green");

        for (Car car : foundCarsByMultipleCategories) {
            System.out.println(car.getMake() + " " + car.getModel() + " " + car.getColor());
        }




    }
}


