package ro.sci.carrental.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ro.sci.carrental.domain.car.Car;
import ro.sci.carrental.domain.car.Category;
import ro.sci.carrental.domain.car.GearBoxType;
import ro.sci.carrental.service.CarService;
import ro.sci.carrental.service.CarServiceImpl;
import ro.sci.carrental.service.Currency;
import ro.sci.carrental.service.Price;

import java.sql.*;

/**
 * Created by Ivett on 09-Aug-17.
 */
public class CarDAO {
    CarRepository<Car> carRepository = new CarRepositoryImpl();
    CarService<Car> carService =  new CarServiceImpl(carRepository);
    private static final Logger LOGGER = LoggerFactory.getLogger("CarDB");

    public void printAllCars() {
        try (Connection conn = newConnection("postgresql",
                        "localhost", "5432", "grp7",
                        "postgres", "admin");
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("select * from car");){
            while (rs.next()) {
                Car car = new Car();

                LOGGER.info(rs.getString("make") + ", "  +
                        rs.getString("model") + ", " +
                        rs.getString("fueltype") + ", " +
                        rs.getInt("size") + ", " +
                        rs.getString("color") + ", " +
                        rs.getString("category") + ", " +
                        rs.getInt("nrseats") + ", " +
                        rs.getInt("nrdoors") + ", " +
                        rs.getString("gearboxtype") + ", " +
                        rs.getBoolean("aircondition") + ", " +
                        rs.getBoolean("gps") + ", " +
                        rs.getBoolean("available") + ", " +
                        rs.getBoolean("working") + ", " +
                        rs.getString("carnumber") + ", " +
                        rs.getDouble("price") + ", " +
                        rs.getString("currency"));
                car.setMake(rs.getString("make"));
                car.setModel(rs.getString("model"));
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
                Price price = new Price(rs.getDouble("price"), Currency.valueOf(rs.getString("currency")));
                car.setPricePerDay(price);
                carService.add(car);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        //return result;
    }

    private static void loadDriver() {
        try {
            Class.forName("org.postgresql.Driver").newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            System.err.println("Can’t load driver. Verify CLASSPATH");
            System.err.println(e.getMessage());
        }

    }

    private static Connection newConnection(String type, String host, String port, String dbName, String user,
                                            String pw) {
        loadDriver();
        DriverManager.setLoginTimeout(60); // wait 1 min; optional: DB may be
        try {
            String url = new StringBuilder().append("jdbc:").append(type) // “mysql”
                    .append("://").append(host).append(":").append(port).append("/").append(dbName).append("?user=")
                    .append(user).append("&password=").append(pw).toString();
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.err.println("Cannot connect to the database: " + e.getMessage());
        }

        return null;
    }
}
