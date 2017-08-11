package ro.sci.carrental.service;

import ro.sci.carrental.domain.customer.Customer;
import ro.sci.carrental.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivett on 05-Jun-17.
 */

public class CustomerServiceImpl implements CustomerService{

    private CustomerRepository<Customer> customerRepository;

    // private List<Customer> customers = new ArrayList<Customer>();

    public CustomerServiceImpl(CustomerRepository<Customer> customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void add(Customer customer) {

    }

    @Override
    public void delete(Customer customer) {

    }

    @Override
    public void update(Customer customer) {

    }

    public List<Customer> findCustomerByFirstName(String FirstName) {
        List<Customer> foundCustomer = new ArrayList<Customer>();

        for (Customer customer: customerRepository.getAll()) {
            if (customer.getFirstName().equals(FirstName)){
                foundCustomer.add(customer);
            }
        }
        return foundCustomer;
    }

    public List<Customer> findCustomerByLastName(String LastName) {
        List<Customer> foundCustomer = new ArrayList<Customer>();

        for (Customer customer: customerRepository.getAll()){
            if (customer.getLastName().equals(LastName)){
                foundCustomer.add(customer);
            }
        }
        return foundCustomer;
    }
}
