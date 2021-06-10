package by.bsu.nik.creational.builder;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class Car {
    private final String brand;
    private final String model;
    private final String color;
    private final String bodyType;
    private final Integer yearProduction;
    private final FuelType fuelType;
    private final SerialType serialType;

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

}
