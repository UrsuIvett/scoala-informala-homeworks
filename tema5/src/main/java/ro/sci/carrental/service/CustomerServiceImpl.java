package ro.sci.carrental.service;

import ro.sci.carrental.domain.customer.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivett on 05-Jun-17.
 */

public class CustomerServiceImpl implements CustomerService{

    private List<Customer> customers = new ArrayList<Customer>();

    public CustomerServiceImpl(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Customer> findCustomerByFirstName(String FirstName) {
        List<Customer> foundCustomer = new ArrayList<Customer>();

        for (Customer customer: customers) {
            if (customer.getFirstName().equals(FirstName)){
                foundCustomer.add(customer);
            }
        }
        return foundCustomer;
    }

    public List<Customer> findCustomerByLastName(String LastName) {
        List<Customer> foundCustomer = new ArrayList<Customer>();

        for (Customer customer: customers){
            if (customer.getLastName().equals(LastName)){
                foundCustomer.add(customer);
            }
        }
        return foundCustomer;
    }
}
