package ro.sci.carrental.repository;

import ro.sci.carrental.domain.Car;
import ro.sci.carrental.domain.FuelType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivett on 24-May-17.
 */
public class CarRepositoryImpl implements CarRepository {
    private CarRepository carRepository;

    public List<Car> cars = new ArrayList<Car>();

    public List<Car> getAll() { return null; }

    public List<Car> getCarsByMake(String make) { return null; }

    public List<Car> getCarsByFuel(FuelType fuelType) { return null; }


    public void add (Car car) {
        cars.add(car);
    }

    public void delete (Car car) {

    }

    public void update (Car car) {

    }
}
