package nik.creational.builder;

import java.util.Objects;

public class CarSerialBuilder implements Builder {
    private String brand;
    private String model;
    private String color;
    private String bodyType;
    private Integer yearProduction;
    private Car.FuelType fuelType;

    public Car build() {
        return new Car(brand, model, color, bodyType, yearProduction, fuelType, Car.SerialType.SERIAL);
    }

    @Override
    public CarSerialBuilder setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    @Override
    public CarSerialBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    @Override
    public CarSerialBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    @Override
    public CarSerialBuilder setBodyType(String bodyType) {
        this.bodyType = bodyType;
        return this;
    }

    @Override
    public CarSerialBuilder setYearProduction(Integer yearProduction) {
        this.yearProduction = yearProduction;
        return this;
    }

    @Override
    public CarSerialBuilder setFuelType(Car.FuelType fuelType) {
        this.fuelType = fuelType;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarSerialBuilder that = (CarSerialBuilder) o;
        return Objects.equals(brand, that.brand) && Objects.equals(model, that.model) && Objects.equals(color, that.color) && Objects.equals(bodyType, that.bodyType) && Objects.equals(yearProduction, that.yearProduction) && fuelType == that.fuelType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, color, bodyType, yearProduction, fuelType);
    }

    @Override
    public String toString() {
        return "CarSerialBuilder{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", bodyType='" + bodyType + '\'' +
                ", yearProduction=" + yearProduction +
                ", fuelType=" + fuelType +
                '}';
    }
}
