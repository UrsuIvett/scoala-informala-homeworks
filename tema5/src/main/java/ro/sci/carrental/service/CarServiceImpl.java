package ro.sci.carrental.service;

import ro.sci.carrental.repository.CarRepository;
import ro.sci.carrental.domain.car.Car;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivett on 24-May-17.
 */
public class CarServiceImpl implements CarService<Car> {

    private CarRepository<Car> carRepository;

     /* public CarServiceImpl(List<Car> cars) {
        this.cars = cars;
    }*/
    public CarServiceImpl(CarRepository<Car> carRepository) {
         this.carRepository=carRepository;
     }

    @Override
    public void add(Car t) {
    this.carRepository.add(t);
    }

    @Override
    public void delete(Car t) {
    this.carRepository.delete(t);
    }

    @Override
    public void update(Car t) {
    this.carRepository.update(t);
    }

    public List<Car> findCarsByMake(String make) {
        List<Car> foundCars = new ArrayList<Car>();
         for (Car car : carRepository.getAll() ) {
            if (car.getMake().equals(make)) {
            foundCars.add(car);
            }
         }
    return foundCars;
    }

    public List<Car> findCarsByMakeAndModel(String make, String model) {
        List<Car> foundCars = new ArrayList<Car>();

        for (Car car : carRepository.getAll() ) {
            if ((car.getMake().equals(make)) && (car.getModel().equals(model))) {
                foundCars.add(car);
            }
        }
       return foundCars;
    }

    public List<Car> findCarsByMultipleCategories (String make, String model, String color ) {
        List<Car> foundCars = new ArrayList<Car>();

        for (Car car : carRepository.getAll() ) {
            if ((car.getMake().equals(make)) && (car.getModel().equals(model)) && (car.getColor().equals(color))) {
                foundCars.add(car);
            }
        }

    return foundCars;
    }





}
