package by.bsu.nik.creational.factory;

import by.bsu.nik.creational.builder.Car;
import by.bsu.nik.creational.exception.CarException;

import java.util.List;

public interface CarFactory {
    Car createCar();

    List<Car> createCars(Long count) throws CarException;
}
