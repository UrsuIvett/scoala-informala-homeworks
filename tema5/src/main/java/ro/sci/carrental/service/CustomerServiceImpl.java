package ro.sci.carrental.service;

import ro.sci.carrental.domain.customer.Customer;
import ro.sci.carrental.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivett on 05-Jun-17.
 */

public class CustomerServiceImpl implements CustomerService<Customer>{

    private CustomerRepository<Customer> customerRepository;

    @Override
    public void setCustomerRepository(CustomerRepository<Customer> customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAll() {
       return this.customerRepository.getAll();
    }

    @Override
    public void add(Customer customer) {
    this.customerRepository.add(customer);
    }

    @Override
    public void delete(Customer customer) {
    this.customerRepository.delete(customer);
    }

    @Override
    public void update(Customer customer) {
    this.customerRepository.update(customer);
    }

    @Override
    public List<Customer> findCustomerByMobile(String mobile) {
        return this.customerRepository.getCustomerByMobile(mobile);
    }

    @Override
    public List<Customer> findCustomerByLastName(String lastName) {
        return this.customerRepository.getCustomerByLastName(lastName);
    }


}
