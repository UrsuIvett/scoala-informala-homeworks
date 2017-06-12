package ro.sci.carrental.service;

import ro.sci.carrental.domain.Car;
import ro.sci.carrental.repository.CarRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivett on 24-May-17.
 */
public class CarServiceImpl implements CarService {

    private CarRepositoryImpl carRepository;
    private List<Car> cars = new ArrayList<Car>();

    public CarServiceImpl(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> findCarsByMake(String make) {
    List<Car> foundCars = new ArrayList<Car>();

         for (Car car : cars ) {
            if (car.getMake().equals(make)) {
            foundCars.add(car);
            }
         }
     return foundCars;
    }

    public List<Car> findCarsByMakeAndModel(String make, String model) {
        List<Car> foundCars = new ArrayList<Car>();

        for (Car car : cars ) {
            if ((car.getMake().equals(make)) && (car.getModel().equals(model))) {
                foundCars.add(car);
            }
        }
        return foundCars;
    }

    public List<Car> findCarsByMultipleCategories (String make, String model, String color ) {
        List<Car> foundCars = new ArrayList<Car>();

        for (Car car : cars ) {
            if ((car.getMake().equals(make)) && (car.getModel().equals(model)) && (car.getColor().equals(color))) {
                foundCars.add(car);
            }
        }
        return foundCars;
    }


}
