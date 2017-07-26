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
        if (tokens.length != 16 ) {
            throw new InvalidEntityException("Invalid Car Description");
        }
        Car car = new Car();
        car.setMake(tokens[0]);
        car.setModel(tokens[1]);
        car.setFuelType(FuelType.valueOf(tokens[2].toUpperCase()));
        car.setSize(Float.valueOf(tokens[3]));
        car.setColor(tokens[4]);
        car.setCategory(Category.valueOf(tokens[5].toUpperCase()));
        car.setNrSeats(Integer.valueOf(tokens[6]));
        car.setNrDoors(Integer.valueOf(tokens[7]));
        car.setGearBoxType(GearBoxType.valueOf(tokens[8].toUpperCase()));
        car.setAirCondition(Boolean.valueOf(tokens[9]));
        car.setGps(Boolean.valueOf(tokens[10]));
        car.setAvailable(Boolean.valueOf(tokens[11]));
        car.setWorking(Boolean.valueOf(tokens[12]));
        car.setNumber(tokens[13]);
        Price price = new Price(Double.valueOf(tokens[14]), Currency.valueOf(tokens[15].toUpperCase()));
        car.setPricePerDay(price);
        return car;

    }
}
