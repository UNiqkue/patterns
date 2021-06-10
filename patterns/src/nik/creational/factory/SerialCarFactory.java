package nik.creational.factory;

import nik.creational.builder.Car;
import nik.creational.exception.CarException;

import java.util.ArrayList;
import java.util.List;

public class SerialCarFactory implements nik.creational.factory.CarFactory {
    @Override
    public Car createCar() {
        return Car.serialBuilder()
                .setBrand("Mercedes")
                .setModel("GLC 300 d 4MATIC")
                .setColor("синий")
                .setBodyType("купе")
                .setYearProduction(2015)
                .setFuelType(Car.FuelType.FUEL)
                .build();
    }

    @Override
    public List<Car> createCars(Long count) throws CarException {
        if (count <= 50L) {
            throw new CarException("Невозможно произвести такое маленькое количество серийных автомобилей. Введите больше 50");
        }
        List<Car> serialCars = new ArrayList<>();
        for (long i = 0L; i < count; i++) {
            Car car = Car.serialBuilder()
                    .setBrand("Lada")
                    .setModel("Vesta")
                    .setColor("серый")
                    .setBodyType("седан")
                    .setYearProduction(2017)
                    .setFuelType(Car.FuelType.FUEL)
                    .build();
            serialCars.add(car);
        }
        return serialCars;
    }
}
