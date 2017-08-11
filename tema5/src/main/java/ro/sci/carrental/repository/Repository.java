package ro.sci.carrental.repository;

/**
 * Created by Ivett on 10-Aug-17.
 */
public interface Repository<T> {
    void add(T t);
    void delete(T t);
    void update(T t);
}
