package ro.sci.carrental.repository;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ro.sci.carrental.domain.car.Car;
import ro.sci.carrental.domain.car.Category;
import ro.sci.carrental.domain.car.GearBoxType;
import ro.sci.carrental.domain.customer.Address;
import ro.sci.carrental.domain.customer.Customer;
import ro.sci.carrental.service.Currency;
import ro.sci.carrental.service.Price;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomerRepositoryImpl extends BaseRepository implements CustomerRepository<Customer>{

    private static final Logger LOGGER = LoggerFactory.getLogger("CustomerDB");
    private static final String SELECT_FROM_CUSTOMER_AND_ADDRESS = "SELECT *FROM customer, address where customer.id=address.id";
    private static final String INSERT_INTO_CUSTOMER = "INSERT INTO customer, address (first_name,last_name,country,county,city,street,street_number,mobile_number)" +
            "values(?,?,?,?,?,?,?,?)";
    private static final String DELETE_FROM_CUSTOMER_WHERE_ID = "DELETE FROM customer, address WHERE mobile_number=?";
    private static final String UPDATE_CUSTOMER_WHERE_ID = "UPDATE customer, address " + "SET first_name=?, last_name=?, country=?, county=?, city=?, street=?, street_number=?, mobile_number=? "
            + "WHERE id = ?";
    private static final String SELECT_FROM_CUSTOMER_WHERE_LAST_NAME = "SELECT * from customer, address WHERE last_name=?";
    private static final String SELECT_FROM_CUSTOMER_WHERE_MOBILE = "SELECT * from customer, address WHERE mobile_number=?";


    @Override
    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();
        try (Connection conn = newConnection();
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery(SELECT_FROM_CUSTOMER_AND_ADDRESS)){
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                Address address =  new Address();
                address.setCountry(rs.getString("country"));
                address.setCounty(rs.getString("county"));
                address.setCity(rs.getString("city"));
                address.setStreet(rs.getString("street"));
                address.setNumber(rs.getInt("street_number"));
                customer.setMobilNumber(rs.getString("mobile_number"));
                customer.setAddress(address);
                customers.add(customer);
            }
        } catch (SQLException ex) {
            LOGGER.error("Error! Exceptions happen: ", ex);
            throw new RuntimeException("Exception at runtime!");
        }
        return customers;
    }

    @Override
    public void add(Customer customer) {
        try (Connection conn = newConnection();
             PreparedStatement stm = conn.prepareStatement(INSERT_INTO_CUSTOMER)) {

            stm.setString(1,customer.getFirstName());
            stm.setString(2,customer.getLastName());
            stm.setString(3, customer.getAddress().getCountry());
            stm.setString(4, customer.getAddress().getCounty());
            stm.setString(5, customer.getAddress().getCity());
            stm.setString(6, customer.getAddress().getStreet());
            stm.setInt(7, customer.getAddress().getNumber());
            stm.setString(8, customer.getMobilNumber());
            stm.execute();
            LOGGER.trace("New customer was added in the table");

        } catch (SQLException ex) {
            LOGGER.error("Error! Exceptions happen: ", ex);
            throw new RuntimeException("Exception at runtime!");
        }
    }

    @Override
    public void delete(Customer customer) {
        try (Connection conn = newConnection();
             PreparedStatement stm = conn.prepareStatement(DELETE_FROM_CUSTOMER_WHERE_ID)) {
            stm.setInt(1, customer.getId());
            stm.executeUpdate();
            LOGGER.trace("This customer was deleted from the table: ", customer.getLastName()+" "+customer.getFirstName());

        } catch (SQLException ex) {
            LOGGER.error("Error! Exceptions happen: ", ex);
            throw new RuntimeException("Exception at runtime!");
        }
    }

    @Override
    public void update(Customer customer) {
        try (Connection conn = newConnection();
             PreparedStatement stm = conn.prepareStatement(UPDATE_CUSTOMER_WHERE_ID)) {

            stm.setString(1,customer.getFirstName());
            stm.setString(2,customer.getLastName());
            stm.setString(3,customer.getAddress().getCountry());
            stm.setString(4,customer.getAddress().getCounty());
            stm.setString(5,customer.getAddress().getCity());
            stm.setString(6,customer.getAddress().getStreet());
            stm.setInt(7,customer.getAddress().getNumber());
            stm.setString(8,customer.getMobilNumber());
            stm.setInt(9, customer.getId());
            stm.executeUpdate();
            LOGGER.trace("A customer was updated");

        } catch (SQLException ex) {
            LOGGER.error("Error! Exceptions happen: ", ex);
            throw new RuntimeException("Exception at runtime!");
        }
    }


    @Override
    public List<Customer> getCustomerByLastName(String name) {
        List<Customer> customerList = new ArrayList<>();
        try (Connection conn = newConnection();
             PreparedStatement stm = conn.prepareStatement(SELECT_FROM_CUSTOMER_WHERE_LAST_NAME)) {
            stm.setString(1, name);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                Address address =  new Address();
                address.setCountry(rs.getString("country"));
                address.setCounty(rs.getString("county"));
                address.setCity(rs.getString("city"));
                address.setStreet(rs.getString("street"));
                address.setNumber(rs.getInt("street_number"));
                customer.setMobilNumber(rs.getString("mobile_number"));
                customer.setAddress(address);
                customerList.add(customer);
            }
        } catch (SQLException ex) {
            LOGGER.error("Error! Exceptions happen: ", ex);
            throw new RuntimeException("Exception at runtime!");
        }
        return customerList;
    }

    @Override
    public List<Customer> getCustomerByMobile(String mobile) {
        List<Customer> customerList = new ArrayList<>();
        try (Connection conn = newConnection();
             PreparedStatement stm = conn.prepareStatement(SELECT_FROM_CUSTOMER_WHERE_MOBILE)) {
            stm.setString(8, mobile);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                Address address =  new Address();
                address.setCountry(rs.getString("country"));
                address.setCounty(rs.getString("county"));
                address.setCity(rs.getString("city"));
                address.setStreet(rs.getString("street"));
                address.setNumber(rs.getInt("street_number"));
                customer.setMobilNumber(rs.getString("mobile_number"));
                customer.setAddress(address);
                customerList.add(customer);
            }
        } catch (SQLException ex) {
            LOGGER.error("Error! Exceptions happen: ", ex);
            throw new RuntimeException("Exception at runtime!");
        }
        return customerList;
    }
}

