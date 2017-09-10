package ro.sci.carrental.repository;



import ro.sci.carrental.domain.car.Car;
import ro.sci.carrental.domain.car.FuelType;

import java.util.List;

public interface CarRepository<T extends Car> extends Repository<T>{

    List<T> getAll();
    List<T> getCarsByMake (String make);
    List<T> getCarsByMakeAndModel (String make, String model);
    void add(T t);
    void delete(T t);
    void update(T t);

}
