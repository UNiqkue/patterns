package by.bsu.nik.structural.composite.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class AfricaCountry implements Country {
    private final String name;
    private final String capital;
    private final List<String> districts;
    private final List<String> cities;

}
