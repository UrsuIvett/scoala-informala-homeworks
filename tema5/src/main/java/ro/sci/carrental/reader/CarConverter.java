package ro.sci.carrental.reader;

import ro.sci.carrental.domain.car.Car;
import ro.sci.carrental.domain.car.Category;
import ro.sci.carrental.domain.car.FuelType;
import ro.sci.carrental.domain.car.GearBoxType;
import ro.sci.carrental.service.Currency;
import ro.sci.carrental.service.Price;

public class CarConverter implements Converter<Car> {
    @Override
    public Car convert(String convertedString) throws InvalidEntityException{
        String[] tokens = convertedString.split(", ");
        if (tokens.length != 17 ) {
            throw new InvalidEntityException("Invalid Car Description");
        }
        Car car = new Car();
        car.setId(Integer.valueOf(tokens[0]));
        car.setMake(tokens[1]);
        car.setModel(tokens[2]);
        car.setFuelType(FuelType.valueOf(tokens[3].toUpperCase()));
        car.setSize(Integer.valueOf(tokens[4]));
        car.setColor(tokens[5]);
        car.setCategory(Category.valueOf(tokens[6].toUpperCase()));
        car.setNrSeats(Integer.valueOf(tokens[7]));
        car.setNrDoors(Integer.valueOf(tokens[8]));
        car.setGearBoxType(GearBoxType.valueOf(tokens[9].toUpperCase()));
        car.setAirCondition(Boolean.valueOf(tokens[10]));
        car.setGps(Boolean.valueOf(tokens[11]));
        car.setAvailable(Boolean.valueOf(tokens[12]));
        car.setWorking(Boolean.valueOf(tokens[13]));
        car.setCarNumber(tokens[14]);
        Price price = new Price(Double.valueOf(tokens[15]), Currency.valueOf(tokens[16].toUpperCase()));
        car.setPricePerDay(price);
        return car;

    }
}
