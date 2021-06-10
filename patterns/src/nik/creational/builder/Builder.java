package nik.creational.builder;

public interface Builder {
    Builder setBrand(String brand);

    Builder setModel(String model);

    Builder setColor(String color);

    Builder setBodyType(String bodyType);

    Builder setYearProduction(Integer yearProduction);

    Builder setFuelType(Car.FuelType fuelType);

    Car build();
}
