package by.bsu.nik.creational.builder;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Accessors(chain = true)
@NoArgsConstructor
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

}
