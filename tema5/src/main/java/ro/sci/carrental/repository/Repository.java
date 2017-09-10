package ro.sci.carrental.repository;

import java.util.List;

/**
 * Created by Ivett on 10-Aug-17.
 */
public interface Repository<T> {
    List<T> getAll();
    void add(T t);
    void delete(T t);
    void update(T t);
}
