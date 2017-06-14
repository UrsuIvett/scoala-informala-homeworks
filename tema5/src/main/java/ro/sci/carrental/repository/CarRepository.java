package main.java.ro.sci.carrental.repository;

import main.java.ro.sci.carrental.domain.car.FuelType;
import main.java.ro.sci.carrental.domain.car.Car;

import java.util.List;

public interface CarRepository {

    List<Car> getAll();

    List<Car> getCarsByMake (String make);

    List<Car> getCarsByFuel (FuelType fuelType);

    void add(Car car);
    void delete(Car car);
    void update (Car car);

}
