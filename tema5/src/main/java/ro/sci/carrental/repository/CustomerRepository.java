package ro.sci.carrental.repository;

import ro.sci.carrental.domain.customer.Customer;

import java.util.List;

/**
 * Created by Ivett on 28-May-17.
 */
public interface CustomerRepository<T extends Customer> extends Repository<T> {

    List<T> getAll();
    void add(T t);
    void delete(T t);
    void update(T t);
    List<T> getCustomerByLastName (String name);
    List<T> getCustomerByMobile (String mobile);

}
