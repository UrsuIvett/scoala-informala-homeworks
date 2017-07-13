package ro.sci.carrental.reader;

import ro.sci.carrental.reader.InvalidEntityException;

/**
 * Created by Ivett on 13-Jul-17.
 */
public interface Convertor <T> {
    T convert(String convertedString) throws InvalidEntityException;

}
