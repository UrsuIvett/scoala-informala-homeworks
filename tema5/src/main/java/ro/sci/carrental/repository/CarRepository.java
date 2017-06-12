package ro.sci.carrental.repository;

import ro.sci.carrental.domain.Car;
import ro.sci.carrental.domain.FuelType;

import java.util.List;

public interface CarRepository {

    List<Car> getAll();

    List<Car> getCarsByMake (String make);

    List<Car> getCarsByFuel (FuelType fuelType);

    void add(Car car);
    void delete(Car car);
    void update (Car car);

}
