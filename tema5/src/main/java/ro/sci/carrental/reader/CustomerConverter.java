package ro.sci.carrental.reader;

import ro.sci.carrental.domain.customer.Customer;

/**
 * Created by Ivett on 16-Jul-17.
 */
public class CustomerConverter implements Converter<Customer>{

    @Override
    public Customer convert(String convertedString) throws InvalidEntityException {
        String[] tokens = convertedString.split(", ");
        if (tokens.length!= 3) {
            throw new InvalidEntityException("Invalid Customer Description!");
        }
        Customer customer = new Customer();
        customer.setFirstName(tokens[0]);
        customer.setLastName(tokens[1]);
        customer.setMobilNumber(tokens[2]);
        return customer;
    }
}
