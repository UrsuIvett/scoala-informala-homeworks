package ro.sci.carrental;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ro.sci.carrental.domain.car.Car;
import ro.sci.carrental.domain.customer.Address;
import ro.sci.carrental.domain.customer.Customer;
import ro.sci.carrental.reader.*;
import ro.sci.carrental.repository.CarRepository;
import ro.sci.carrental.repository.CarRepositoryImpl;
import ro.sci.carrental.service.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivett on 24-May-17.
 */
public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger("Car");

    public static void main(String[] args) throws InvalidCurrencyException {
        LOGGER.info("START Main");

        /* reads from a text file, and the text is transformed to a Car object
        * */
        final List<Car> carList = new ArrayList<Car>();
        File file = new File("tema5/src/main/java/cars.txt");
        EntityReader entityReader = new EntityReader();
        List<String> lines = entityReader.readLines(file);
        CarConverter carConverter = new CarConverter();
        int i = 0;
        for (String line: lines) {
            i++;
            Car car = null;
            try {
                car = carConverter.convert(line);
                carList.add(car);
            } catch (InvalidEntityException e) {
                System.out.println("Invalid car for: [" +line+ "] at the line: "+i);
            }
        }

        List<Customer> customers = new ArrayList<Customer>();
        File file1 = new File("tema5/src/main/java/customers.txt");
        EntityReader entityReader1 = new EntityReader();
        List<String> lines1 = entityReader1.readLines(file1);
        CustomerConverter customerConverter = new CustomerConverter();
        int ii = 0;
        for (String line1: lines1) {
            ii++;
            Customer customer = null;
            try {
                customer = customerConverter.convert(line1);
                customers.add(customer);
            } catch (InvalidEntityException e) {
                System.out.println("Invalid customer for: [" +line1+ "] at the line: "+ii);
            }
        }

        List<Address> addresses = new ArrayList<>();
        File file2 = new File("tema5/src/main/java/address.txt");
        EntityReader entityReader2 = new EntityReader();
        List<String> lines2 = entityReader2.readLines(file2);
        AddressConverter addressConverter = new AddressConverter();
        int jj = 0;
        for (String line2: lines2) {
            jj++;
            Address address = null;
            try {
                address = addressConverter.convert(line2);
                addresses.add(address);
            } catch (InvalidEntityException e) {
                System.out.println("Invalid customer for: [" +line2+ "] at the line: "+jj);
            }
        }

        System.out.println("Cars: ");
        for (Car car : carList) {
            System.out.println(car);
        }

        System.out.println("Our customers: ");
        int ic=0;
        for (Customer c : customers) {
            ic++;
            int ia=0;
            for (Address a : addresses) {
                ia++;
                if (ic == ia) {
                    c.setAdress(a);
                    System.out.println(c.getFirstName() + " " + c.getLastName() + ", " + "mobile number:" + c.getMobilNumber() + " city: " + c.getAdress().getCity() + ", street: " + c.getAdress().getStreet() + " nr." + c.getAdress().getNumber());
                }
            }
        }
        System.out.println(" ");
        searching(carList);

        /* Car car1 = new Car();
        car1 = carList.get(3);
        CarRepositoryImpl newList = new CarRepositoryImpl(carList);
        newList.delete(car1);
        System.out.println(" ");
        System.out.println("After deleting Skoda Superb ");
        for (Car car : carList) {
            System.out.println(car.getMake()+ " " + car.getModel());
        }*/
        System.out.println(" ");

        Car car2 = new Car();
        car2 = carList.get(1);
        RentingPrice rentingPrice = new RentingPrice();
        int daysNumber = 5;
        Price totalPrice= rentingPrice.calculateRentingPrince(car2,daysNumber);
        System.out.println(car2.getMake()+car2.getModel()+" The renting price for " +daysNumber + " days is: " + totalPrice.getPrice() +" "+totalPrice.getCurrency());
        LOGGER.info("END Main");

        final CarRentalDispatcher carRentalDispatcher = new CarRentalDispatcher();
        final Car currentCar = carList.get(1);

        Thread t1= new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    carRentalDispatcher.produce(carList,currentCar);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    carRentalDispatcher.consume(carList, currentCar);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    carRentalDispatcher.consume(carList, currentCar);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }

    private static void searching(List<Car> carList) {

        System.out.println("Cars from the Repo: ");

       for (Car car : carList) {
            System.out.println(car.getMake()+ " " + car.getModel()+ " renting price/day: "+car.getPricePerDay().getPrice()+" "+car.getPricePerDay().getCurrency());
        }

        File file = new File("tema5/src/main/java/carsout.txt");
        EntityWriter entityWriter = new EntityWriter();
       try {
           ArrayList<String > carsInString = new ArrayList<>();
           CarToString carToString = new CarToString();
           for (Car currentCar: carList) {
               carsInString.add(carToString.convertToString(currentCar));
           }
           entityWriter.readLines(carsInString, file);
       } catch (InvalidEntityException e){
           System.out.println("Invalid entity");
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



