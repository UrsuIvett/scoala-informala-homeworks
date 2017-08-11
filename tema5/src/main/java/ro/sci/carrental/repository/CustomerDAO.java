package ro.sci.carrental.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ro.sci.carrental.domain.car.Car;
import ro.sci.carrental.domain.car.Category;
import ro.sci.carrental.domain.car.GearBoxType;
import ro.sci.carrental.domain.customer.Address;
import ro.sci.carrental.domain.customer.Customer;
import ro.sci.carrental.service.*;

import java.sql.*;

/**
 * Created by Ivett on 11-Aug-17.
 */
public class CustomerDAO {
    CustomerRepository<Customer> customerRepository = new CustomerRepositoryImpl();
    CustomerService<Customer> customerService =  new CustomerServiceImpl(customerRepository);
    private static final Logger LOGGER = LoggerFactory.getLogger("CustomerDB");

    public void printAllCustomer() {
        try (Connection conn = newConnection("postgresql",
                "localhost", "5432", "grp7",
                "postgres", "admin");
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery("select * from customer");){
            while (rs.next()) {
                Customer customer = new Customer();

                LOGGER.info(rs.getString("first_name") + ", "  +
                        rs.getString("last_name") + ", " +
                        rs.getString("country") + ", " +
                        rs.getString("county") + ", " +
                        rs.getString("city") + ", " +
                        rs.getString("street") + ", " +
                        rs.getInt("street_number") + ", " +
                        rs.getString("mobile_number"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                Address address = new Address();
                address.setCountry(rs.getString("country"));
                address.setCounty(rs.getString("county"));
                address.setCity(rs.getString("city"));
                address.setStreet(rs.getString("street"));
                address.setNumber(rs.getInt("street_number"));
                customer.setAdress(address);
                customer.setMobilNumber(rs.getString("mobile_number"));
                customerService.add(customer);
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

