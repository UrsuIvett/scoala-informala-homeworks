package ro.sci.carrental.repository;


import ro.sci.carrental.domain.customer.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {

        private List<Customer> customers = new ArrayList<Customer>();

        public List<Customer> getAll() {
            return customers; }


        public void add (Customer customer) {
            customers.add(customer);

        }

        public void delete (Customer customer) {

        }

}

