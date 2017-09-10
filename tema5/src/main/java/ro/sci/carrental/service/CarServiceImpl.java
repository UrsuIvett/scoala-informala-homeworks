package ro.sci.carrental.service;

import ro.sci.carrental.repository.CarRepository;
import ro.sci.carrental.domain.car.Car;
import ro.sci.carrental.repository.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivett on 24-May-17.
 */
public class CarServiceImpl implements CarService<Car> {

    private CarRepository<Car> carRepository;

    @Override
    public void setCarRepository(CarRepository<Car> carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getAll() {
       return this.carRepository.getAll();
    }

    @Override
    public void add(Car car) {
    this.carRepository.add(car);
    }

    @Override
    public void delete(Car car) {
    this.carRepository.delete(car);
    }

    @Override
    public void update(Car car) {
    this.carRepository.update(car);
    }

    @Override
    public List<Car> findCarsByMake(String make) {
        return this.carRepository.getCarsByMake(make);
    }

    @Override
    public List<Car> findCarsByMakeAndModel(String make, String model) {
        return this.carRepository.getCarsByMakeAndModel(make,model);
    }

}
