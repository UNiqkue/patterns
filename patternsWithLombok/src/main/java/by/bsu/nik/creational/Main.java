package by.bsu.nik.creational;

import by.bsu.nik.creational.builder.Car;
import by.bsu.nik.creational.exception.CarException;
import by.bsu.nik.creational.factory.CarFactory;
import by.bsu.nik.creational.factory.SerialCarFactory;
import by.bsu.nik.creational.factory.SpecialCarFactory;

import java.util.List;

public class Main {
    //Паттерн Builder. Разработать модель системы Автомобиль. Написать код
    //приложения, который будет позволять порождать как серийные автомобили, так и автомобили по специальному заказу.

    //в этом пакете решил сделать поведенческие паттерны
    public static void main(String[] args) {
        //тут создаём фабрики по производству машин
        CarFactory serialCarFactory = new SerialCarFactory();
        CarFactory specialCarFactory = new SpecialCarFactory();

        //далее производим машины
        Car mercedesCar = serialCarFactory.createCar();
        System.out.println(mercedesCar);

        try {
            List<Car> serialLadaCars = serialCarFactory.createCars(100L);
            System.out.println(serialLadaCars);
        } catch (CarException e) {
            System.err.println(e.getMessage());
        }

        Car lamborghiniCar = specialCarFactory.createCar();
        System.out.println(lamborghiniCar);
        try {
            List<Car> specialTeslaCars = specialCarFactory.createCars(10L);
            System.out.println(specialTeslaCars);
        } catch (CarException e) {
            System.err.println(e.getMessage());
        }


    }
}
