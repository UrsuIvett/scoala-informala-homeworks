package ro.sci.carrental;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ro.sci.carrental.domain.car.Car;
import ro.sci.carrental.domain.car.Category;
import ro.sci.carrental.domain.car.FuelType;
import ro.sci.carrental.domain.car.GearBoxType;
import ro.sci.carrental.domain.customer.Address;
import ro.sci.carrental.domain.customer.Customer;
import ro.sci.carrental.repository.CarRepositoryImpl;
import ro.sci.carrental.service.CarServiceImpl;
import ro.sci.carrental.service.InvalidDaysNumberException;
import ro.sci.carrental.service.Price;
import ro.sci.carrental.service.RentingPrice;

import java.util.ArrayList;
import java.util.List;

import static ro.sci.carrental.service.Currency.*;


/**
 * Created by Ivett on 24-May-17.
 */
public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger("Car");

    public static void main(String[] args) throws InvalidDaysNumberException {
                LOGGER.info("Start Main");

        List<Car> carList = new ArrayList<Car>();

        Car Ford = new Car();
        Ford.setMake("Ford");
        Ford.setModel("Focus");
        Ford.setFuelType(FuelType.DIESEL);
        Ford.setSize(1600);
        Ford.setColor("Black");
        Ford.setCategory(Category.BREAK);
        Ford.setNrSeats(5);
        Ford.setNrDoors(5);
        Ford.setGearBoxType(GearBoxType.MANUAL);
        Ford.setAirCondition(true);
        Ford.setGps(true);
        Ford.setAvailable(true);
        Ford.setWorking(true);
        Ford.setNumber("B-HFT-18");
        Price price1 = new Price(4.5, EURO);
        Ford.setPricePerDay(price1);

        Car VW = new Car();
        VW.setMake("Volkswagen");
        VW.setModel("Golf");
        VW.setFuelType(FuelType.PETROL);
        VW.setSize(1400);
        VW.setColor("Silver");
        VW.setCategory(Category.HATCHBACK);
        VW.setNrSeats(4);
        VW.setNrDoors(5);
        VW.setGearBoxType(GearBoxType.MANUAL);
        VW.setAirCondition(false);
        VW.setGps(false);
        VW.setAvailable(true);
        VW.setWorking(true);
        VW.setNumber("B-TFL-20");
        Price price2 = new Price(3.50, USD);
        VW.setPricePerDay(price2);



        Car Skoda1 = new Car();
        Skoda1.setMake("Skoda");
        Skoda1.setModel("Octavia");
        Skoda1.setFuelType(FuelType.DIESEL);
        Skoda1.setSize(1900);
        Skoda1.setColor("Green");
        Skoda1.setCategory(Category.SEDAN);
        Skoda1.setNrSeats(5);
        Skoda1.setNrDoors(4);
        Skoda1.setGearBoxType(GearBoxType.AUTO);
        Skoda1.setAirCondition(true);
        Skoda1.setGps(false);
        Skoda1.setAvailable(true);
        Skoda1.setWorking(true);
        Skoda1.setNumber("MS-TFL-01");
        Price price3 = new Price(3.00, EURO);
        Skoda1.setPricePerDay(price3);



        Car Skoda2 = new Car();
        Skoda2.setMake("Skoda");
        Skoda2.setModel("Superb");
        Skoda2.setFuelType(FuelType.DIESEL);
        Skoda2.setSize(1700);
        Skoda2.setColor("Green");
        Skoda2.setCategory(Category.MONOVOLUME);
        Skoda2.setNrSeats(7);
        Skoda2.setNrDoors(5);
        Skoda2.setGearBoxType(GearBoxType.MANUAL);
        Skoda2.setAirCondition(true);
        Skoda2.setGps(true);
        Skoda2.setAvailable(true);
        Skoda2.setWorking(true);
        Skoda2.setNumber("MZ-ZZZ-10");
        Price price4 = new Price(10.50, RON);
        Skoda2.setPricePerDay(price4);



        Car Skoda3 = new Car();
        Skoda3.setMake("Skoda");
        Skoda3.setModel("Superb");
        Skoda3.setFuelType(FuelType.DIESEL);
        Skoda3.setSize(1700);
        Skoda3.setColor("Green");
        Skoda3.setCategory(Category.MONOVOLUME);
        Skoda3.setNrSeats(7);
        Skoda3.setNrDoors(5);
        Skoda3.setGearBoxType(GearBoxType.MANUAL);
        Skoda3.setAirCondition(true);
        Skoda3.setGps(true);
        Skoda3.setAvailable(true);
        Skoda3.setWorking(true);
        Skoda3.setNumber("MZ-ZZZ-10");
        Price price5 = new Price(10.50, RON);
        Skoda3.setPricePerDay(price5);

        carList.add(Ford);
        carList.add(VW);
        carList.add(Skoda1);
        carList.add(Skoda2);
        carList.add(Skoda3);

        List<Customer> customers = new ArrayList<Customer>();

        Customer customer1 = new Customer();
        customer1.setFirstName("Captain");
        customer1.setLastName("Hook");
        customer1.setMobilNumber("0264-444555");
        Address address1 = new Address();
        address1.setCountry("Romania");
        address1.setCounty("Cluj");
        address1.setCity("Cluj");
        address1.setStreet("Emil Isac");
        address1.setNumber(15);

        Customer customer2 = new Customer();
        customer2.setFirstName("Charlie");
        customer2.setLastName("Gordon");
        customer2.setMobilNumber("0263-444666");
        Address address2 = new Address();
        address2.setCountry("Romania");
        address2.setCounty("Mures");
        address2.setCity("Targu Mures");
        address2.setStreet("Mihai Eminescu");
        address2.setNumber(3);

        Customer customer3 = new Customer();
        customer3.setFirstName("Louis");
        customer3.setLastName("Griffin");
        customer3.setMobilNumber("0261-124666");
        Address address3 = new Address();
        address3.setCountry("Romania");
        address3.setCounty("Bucuresti");
        address3.setCity("Bucuresti");
        address3.setStreet("Comedy");
        address3.setNumber(10);

        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);

        System.out.println("Our customers: ");

        for (Customer c : customers) {
            System.out.println(c.getFirstName()+ " " + c.getLastName() + ", " + "mobile number:" + c.getMobilNumber());
        }

        System.out.println(" ");


        searching(carList);

        CarRepositoryImpl newList = new CarRepositoryImpl(carList);
        newList.delete(Skoda3);
        System.out.println(" ");
        System.out.println("After deleting Skoda Superb ");


        for (Car car : carList) {
            System.out.println(car.getMake()+ " " + car.getModel());
        }

        System.out.println(" ");

        RentingPrice rentingPrice = new RentingPrice();
        int daysNumber = 5;

        Price totalPrice= rentingPrice.calculateRentingPrince(Ford,daysNumber);
        System.out.println(Ford.getMake()+Ford.getModel()+" The renting price for " +daysNumber + " days is: " + totalPrice.getPrice() +" "+totalPrice.getCurrency());

    }

    private static void searching(List<Car> carList) {

        System.out.println("Cars from the Repo: ");

       for (Car car : carList) {
            System.out.println(car.getMake()+ " " + car.getModel()+ " renting price/day: "+car.getPricePerDay().getPrice()+" "+car.getPricePerDay().getCurrency());
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
        System.out.println("Cars  after the search by make & model & color: ");

        CarServiceImpl searchMultiple = new CarServiceImpl(carList);
        List<Car> foundCarsByMultipleCategories = searchMultiple.findCarsByMultipleCategories("Skoda", "Octavia", "Green");

        for (Car car : foundCarsByMultipleCategories) {
            System.out.println(car.getMake() + " " + car.getModel() + " " + car.getColor());
        }

    }


    }






