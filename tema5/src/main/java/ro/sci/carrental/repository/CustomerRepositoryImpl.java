package ro.sci.carrental.repository;

import ro.sci.carrental.domain.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {

        private List<Customer> customers = new ArrayList<Customer>();

        public List<Customer> getAll() {
            return null; }


        public void add (Customer customer) {
            customers.add(customer);

        }

        public void delete (Customer customer) {

        }

}

