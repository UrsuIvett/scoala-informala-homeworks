package ro.sci.carrental.repository;

import ro.sci.carrental.domain.car.Car;
import ro.sci.carrental.domain.car.FuelType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Ivett on 24-May-17.
 */
public class CarRepositoryImpl implements CarRepository {
    private CarRepository carRepository;

    private List<Car> cars = new ArrayList<Car>();

    public CarRepositoryImpl(List<Car> cars) { this.cars=cars; }

    public List<Car> getAll() { return null; }

    public List<Car> getCarsByMake(String make) { return null; }

    public List<Car> getCarsByFuel(FuelType fuelType) { return null; }


    public void add (Car car) {
        cars.add(car);
    }

    public void delete (Car car) {

        Iterator<Car> iterator = cars.iterator();
        while (iterator.hasNext()) {
            Car currentCar = iterator.next();
            if (currentCar.equals(car)) {
                iterator.remove();
            }
        }


    }

    public void update (Car car) {

    }
}
