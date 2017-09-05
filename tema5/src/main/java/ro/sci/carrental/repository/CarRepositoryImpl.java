package ro.sci.carrental.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ro.sci.carrental.domain.car.Car;
import ro.sci.carrental.domain.car.Category;
import ro.sci.carrental.domain.car.FuelType;
import ro.sci.carrental.domain.car.GearBoxType;
import ro.sci.carrental.service.Currency;
import ro.sci.carrental.service.Price;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Ivett on 24-May-17.
 */
public class CarRepositoryImpl extends BaseRepository implements CarRepository<Car> {

    private static final Logger LOGGER = LoggerFactory.getLogger("CarDB");
    private static final String SELECT_FROM_CAR_AND_PRICE = "SELECT * FROM car, price where car.id=price.id";
    private static final String INSERT_INTO_CAR = "INSERT INTO car, price(make,model,fueltype,size,color,category,nrseats,nrdoors,gearboxtype,aircondition,gps,available,working,carnumber,price,currency)" +
            "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String DELETE_FROM_CAR_WHERE_ID = "DELETE FROM car, price WHERE make=?";
    private static final String UPDATE_CAR_WHERE_ID = "UPDATE car, price " + "SET make=?, model=?, fueltype=?, size=?, color=?, category=?, nrseats=?, nrdoors=?, gearboxtype=?, aircondition=?, gps=?, available=?, working=?, "
            + "carnumber=?, price=?, currency=? " + "WHERE id = ?";
    private static final String SELECT_FROM_CAR_WHERE_MAKE = "SELECT * from car, price WHERE car.id=price.id and make=?";
    private static final String SELECT_FROM_CAR_WHERE_MAKE_MODEL = "SELECT * from car, price WHERE make=? and model=?";

    @Override
    public List<Car> getAll() {
        List<Car> cars = new ArrayList<>();
        try (Connection conn = newConnection();
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery(SELECT_FROM_CAR_AND_PRICE)){
        while (rs.next()) {
            Car car = new Car();
            car.setId(rs.getInt("id"));
            car.setMake(rs.getString("make"));
            car.setModel(rs.getString("model"));
            car.setFuelType(FuelType.valueOf(rs.getString("fueltype")));
            car.setSize(rs.getInt("size"));
            car.setColor(rs.getString("color"));
            car.setCategory(Category.valueOf(rs.getString("category")));
            car.setNrSeats(rs.getInt("nrseats"));
            car.setNrDoors(rs.getInt("nrdoors"));
            car.setGearBoxType(GearBoxType.valueOf(rs.getString("gearboxtype")));
            car.setAirCondition(rs.getBoolean("aircondition"));
            car.setGps(rs.getBoolean("gps"));
            car.setAvailable(rs.getBoolean("available"));
            car.setWorking(rs.getBoolean("working"));
            car.setCarNumber(rs.getString("color"));
            car.setCarNumber(rs.getString("carnumber"));
            Price price = new Price(rs.getDouble("val"),Currency.valueOf(rs.getString("currency")));
            car.setPricePerDay(price);
            cars.add(car);
        }
    } catch (SQLException ex) {
                 LOGGER.warn("DATABASE ERROR");
        ex.printStackTrace();
    }
        return cars;
    }

    @Override
    public List<Car> getCarsByMake(String make) {
        List<Car> carList = new ArrayList<>();
        try (Connection conn = newConnection();
             PreparedStatement stm = conn.prepareStatement(SELECT_FROM_CAR_WHERE_MAKE)) {
            stm.setString(1,make);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Car car = new Car();
                car.setId(rs.getInt("id"));
                car.setMake(rs.getString("make"));
                car.setModel(rs.getString("model"));
                car.setFuelType(FuelType.valueOf(rs.getString("fueltype")));
                car.setSize(rs.getInt("size"));
                car.setColor(rs.getString("color"));
                car.setCategory(Category.valueOf(rs.getString("category")));
                car.setNrSeats(rs.getInt("nrseats"));
                car.setNrDoors(rs.getInt("nrdoors"));
                car.setGearBoxType(GearBoxType.valueOf(rs.getString("gearboxtype")));
                car.setAirCondition(rs.getBoolean("aircondition"));
                car.setGps(rs.getBoolean("gps"));
                car.setAvailable(rs.getBoolean("available"));
                car.setWorking(rs.getBoolean("working"));
                car.setCarNumber(rs.getString("color"));
                car.setCarNumber(rs.getString("carnumber"));
                int id = rs.getInt("id");
                double value = rs.getDouble("val");
                Currency currency = Currency.valueOf(rs.getString("currency"));
                Price price = new Price(value, currency);
                car.setPricePerDay(price);
                carList.add(car);
            }
        } catch (SQLException ex) {
            LOGGER.warn("DATABASE ERROR");
            ex.printStackTrace();
        }

        return carList;
    }

    @Override
    public List<Car> getCarsByMakeAndModel (String make, String model) {
        List<Car> carList = new ArrayList<>();
        try (Connection conn = newConnection();
             PreparedStatement stm = conn.prepareStatement(SELECT_FROM_CAR_WHERE_MAKE_MODEL)) {
            stm.setString(1,make);
            stm.setString(2,model);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Car car = new Car();
                car.setId(rs.getInt("id"));
                car.setMake(rs.getString("make"));
                car.setModel(rs.getString("model"));
                car.setFuelType(FuelType.valueOf(rs.getString("fueltype")));
                car.setSize(rs.getInt("size"));
                car.setColor(rs.getString("color"));
                car.setCategory(Category.valueOf(rs.getString("category")));
                car.setNrSeats(rs.getInt("nrseats"));
                car.setNrDoors(rs.getInt("nrdoors"));
                car.setGearBoxType(GearBoxType.valueOf(rs.getString("gearboxtype")));
                car.setAirCondition(rs.getBoolean("aircondition"));
                car.setGps(rs.getBoolean("gps"));
                car.setAvailable(rs.getBoolean("available"));
                car.setWorking(rs.getBoolean("working"));
                car.setCarNumber(rs.getString("color"));
                car.setCarNumber(rs.getString("carnumber"));
                Price price = new Price(rs.getDouble("val"), Currency.valueOf(rs.getString("currency")));
                car.setPricePerDay(price);
                carList.add(car);
            }
        } catch (SQLException ex) {
            LOGGER.warn("DATABASE ERROR");
            ex.printStackTrace();
        }
        return carList;
    }


    @Override
    public void add(Car car) {
        try (Connection conn = newConnection();
             PreparedStatement stm = conn.prepareStatement(INSERT_INTO_CAR)) {

        stm.setString(1,car.getMake());
        stm.setString(2,car.getModel());
        stm.setString(3, String.valueOf(car.getFuelType()));
        stm.setInt(4,car.getSize());
        stm.setString(5,car.getColor());
        stm.setString(6, String.valueOf(car.getCategory()));
        stm.setInt(7,car.getNrSeats());
        stm.setInt(8,car.getNrDoors());
        stm.setString(9, String.valueOf(car.getGearBoxType()));
        stm.setBoolean(10,car.hasAirCondition());
        stm.setBoolean(11,car.hasGps());
        stm.setBoolean(12,car.isAvailable());
        stm.setBoolean(13,car.isWorking());
        stm.setString(14,car.getCarNumber());
        stm.setDouble(15,car.getPricePerDay().getPrice());
        stm.setString(16,String.valueOf(car.getPricePerDay().getCurrency()));
        stm.execute();
        LOGGER.info("New car was added in the table");

    } catch (SQLException ex) {
        LOGGER.warn("DATABASE ERROR");
        ex.printStackTrace();
    }
    }

    @Override
    public void delete(Car car) {
        try (Connection conn = newConnection();
             PreparedStatement stm = conn.prepareStatement(DELETE_FROM_CAR_WHERE_ID);) {
            stm.setInt(1, car.getId());
            stm.executeUpdate();
            LOGGER.info("This car was deleted from the table: ", car.getMake()+" "+car.getModel());

        } catch (SQLException ex) {
            LOGGER.warn("DATABASE ERROR");
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Car car) {
        try (Connection conn = newConnection();
             PreparedStatement stm = conn.prepareStatement(UPDATE_CAR_WHERE_ID)) {

        stm.setString(1,car.getMake());
        stm.setString(2,car.getModel());
        stm.setString(3, String.valueOf(car.getFuelType()));
        stm.setInt(4,car.getSize());
        stm.setString(5,car.getColor());
        stm.setString(6, String.valueOf(car.getCategory()));
        stm.setInt(7,car.getNrSeats());
        stm.setInt(8,car.getNrDoors());
        stm.setString(9, String.valueOf(car.getGearBoxType()));
        stm.setBoolean(10,car.hasAirCondition());
        stm.setBoolean(11,car.hasGps());
        stm.setBoolean(12,car.isAvailable());
        stm.setBoolean(13,car.isWorking());
        stm.setString(14,car.getCarNumber());
        stm.setDouble(15,car.getPricePerDay().getPrice());
        stm.setString(16,String.valueOf(car.getPricePerDay().getCurrency()));
        stm.setInt(17, car.getId());
        stm.executeUpdate();
        LOGGER.info("A car was updated");

    } catch (SQLException ex) {
        LOGGER.warn("DATABASE ERROR");
        ex.printStackTrace();
    }
    }

}
