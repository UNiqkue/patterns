package nik.creational.factory;

import nik.creational.builder.Car;
import nik.creational.exception.CarException;

import java.util.ArrayList;
import java.util.List;

public class SpecialCarFactory implements nik.creational.factory.CarFactory {
    @Override
    public Car createCar() {
        return Car.serialBuilder()
                .setBrand("Lamborghini")
                .setModel("Aventador")
                .setColor("жёлтый")
                .setBodyType("спорт купе")
                .setYearProduction(2011)
                .setFuelType(Car.FuelType.FUEL)
                .build();
    }

    @Override
    public List<Car> createCars(Long count) throws CarException {
        List<Car> specialCars = new ArrayList<>();
        if (count > 50L) {
            throw new CarException("Невозможно произвести такое большое количество специализированных автомобилей. Введите меньше или равно 50");
        }
        for (long i = 0L; i < count; i++) {
            Car car = Car.specialBuilder()
                    .setBrand("Tesla")
                    .setModel("Roadster")
                    .setColor("чёрный")
                    .setBodyType("хэтчбек")
                    .setYearProduction(2008)
                    .setFuelType(Car.FuelType.ELECTRICITY)
                    .build();
            specialCars.add(car);
        }
        return specialCars;
    }
}
