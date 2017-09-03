package ro.sci.carrental.service;

import ro.sci.carrental.domain.car.Car;
import ro.sci.carrental.repository.CarRepository;

import java.util.List;

/**
 * Created by Ivett on 26-May-17.
 */
public interface CarService<T extends Car> {
    void setCarRepository(CarRepository<Car> carRepository);
    List<T> getAll();
    void add (T t);
    void delete (T t);
    void update (T t);
    List<T> findCarsByMake (String make);
    List<T> findCarsByMakeAndModel (String make, String model);

}
