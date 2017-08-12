package ro.sci.carrental.reader;

import ro.sci.carrental.domain.customer.Address;

/**
 * Created by Ivett on 16-Jul-17.
 */
public class AddressConverter implements Converter<Address> {
    @Override
    public Address convert(String convertedString) throws InvalidEntityException {
        String[] tokens = convertedString.split(", ");
        if (tokens.length != 5) {
            throw new InvalidEntityException("Invalid Address Description");
        }
        Address address = new Address();
        address.setCountry(tokens[0]);
        address.setCounty(tokens[1]);
        address.setCity(tokens[2]);
        address.setStreet(tokens[3]);
        address.setNumber(Integer.valueOf(tokens[4]));
        return address;
    }
}
