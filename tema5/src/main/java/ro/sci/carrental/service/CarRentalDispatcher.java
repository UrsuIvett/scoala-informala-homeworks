package ro.sci.carrental.service;

import ro.sci.carrental.domain.car.Car;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ivett on 22-Jul-17.
 */

/* This Class has two methods, a producer(sets the current car's availability to true, because he brought it back),
and a consumer (sets the current car's availability to false, beacause he wants to rent the car)

 */
public class CarRentalDispatcher {

    public void produce(List<Car> cars, Car currentCar) throws InterruptedException {

        while (true) {
            synchronized (this) {
                while (currentCar.isAvailable()== true){
                    wait();
                }
                System.out.println("The carlist is full,the producer produced: "+ currentCar.getMake()+" "+currentCar.getModel());
                currentCar.setAvailable(true);
                notifyAll();
                Thread.sleep(1000);
            }
        }
    }

    public void consume(List<Car> cars, Car currentCar) throws InterruptedException{

        while (true) {
            synchronized (this) {
                while (currentCar.isAvailable()== false){
                    wait();
                }
                System.out.println("This car is rented: "+ currentCar.getMake()+" "+currentCar.getModel()+" the thread ID is: "+Thread.currentThread().getId());
                currentCar.setAvailable(false);
                notifyAll();
                Thread.sleep(1000);
            }
        }
    }

}
