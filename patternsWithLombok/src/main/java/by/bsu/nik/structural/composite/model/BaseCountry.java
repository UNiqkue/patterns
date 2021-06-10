package by.bsu.nik.structural.composite.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class BaseCountry implements Country {
    private final String name;
    private final String capital;
    private final List<String> districts;
    private final List<String> cities;
}
