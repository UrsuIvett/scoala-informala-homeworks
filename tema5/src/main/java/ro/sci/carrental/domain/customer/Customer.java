package main.java.ro.sci.carrental.domain.customer;

/**
 * Created by Ivett on 28-May-17.
 */
public class Customer {
    private String firstName;
    private String lastName;
    private Address adress;
    private String mobilNumber;

    public Customer() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAdress() {
        return adress;
    }

    public void setAdress(Address adress) {
        this.adress = adress;
    }

    public String getMobilNumber() {
        return mobilNumber;
    }

    public void setMobilNumber(String mobilNumber) {
        this.mobilNumber = mobilNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (!firstName.equals(customer.firstName)) return false;
        if (!lastName.equals(customer.lastName)) return false;
        if (adress != null ? !adress.equals(customer.adress) : customer.adress != null) return false;
        return mobilNumber != null ? mobilNumber.equals(customer.mobilNumber) : customer.mobilNumber == null;
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + (adress != null ? adress.hashCode() : 0);
        result = 31 * result + (mobilNumber != null ? mobilNumber.hashCode() : 0);
        return result;
    }
}

