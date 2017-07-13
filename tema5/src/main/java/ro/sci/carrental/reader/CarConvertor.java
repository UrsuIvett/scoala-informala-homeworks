package ro.sci.carrental.reader;

import ro.sci.carrental.domain.car.Car;
import ro.sci.carrental.domain.car.FuelType;

public class CarConvertor implements Convertor<Car> {
    public Car convert(String convertedString) {
        String[] tokens = convertedString.split(",");
        Car car = new Car();
        car.setMake(tokens[0]);
        car.setModel(tokens[1]);
        car.setFuelType(FuelType.valueOf(tokens[2].toUpperCase()));
        car.setSize(Float.valueOf(tokens[3]));






        return car;

    }
}
