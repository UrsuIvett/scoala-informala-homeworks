package ro.sci.carrental.repository;


import ro.sci.carrental.domain.customer.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository<Customer>{

        private List<Customer> customers = new ArrayList<Customer>();

    @Override
    public List<Customer> getAll() {
        return customers;
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
}

