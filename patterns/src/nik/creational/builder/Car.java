package nik.creational.builder;


import java.util.Objects;

public class Car {
    private final String brand;
    private final String model;
    private final String color;
    private final String bodyType;
    private final Integer yearProduction;
    private final FuelType fuelType;
    private final SerialType serialType;

    public Car(String brand, String model, String color, String bodyType, Integer yearProduction, FuelType fuelType, SerialType serialType) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.bodyType = bodyType;
        this.yearProduction = yearProduction;
        this.fuelType = fuelType;
        this.serialType = serialType;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getBodyType() {
        return bodyType;
    }

    public Integer getYearProduction() {
        return yearProduction;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public SerialType getSerialType() {
        return serialType;
    }

    public enum FuelType {
        FUEL, ELECTRICITY
    }

    public enum SerialType {
        SERIAL, SPECIAL
    }

    public static Builder specialBuilder() {
        return new CarSpecialBuilder();
    }

    public static Builder serialBuilder() {
        return new CarSerialBuilder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(brand, car.brand) && Objects.equals(model, car.model) && Objects.equals(color, car.color) && Objects.equals(bodyType, car.bodyType) && Objects.equals(yearProduction, car.yearProduction) && fuelType == car.fuelType && serialType == car.serialType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, color, bodyType, yearProduction, fuelType, serialType);
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", bodyType='" + bodyType + '\'' +
                ", yearProduction=" + yearProduction +
                ", fuelType=" + fuelType +
                ", serialType=" + serialType +
                '}';
    }
}
