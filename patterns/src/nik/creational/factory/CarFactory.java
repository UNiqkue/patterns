package nik.creational.factory;

import nik.creational.builder.Car;
import nik.creational.exception.CarException;

import java.util.List;

public interface CarFactory {
    Car createCar();

    List<Car> createCars(Long count) throws CarException;
}
