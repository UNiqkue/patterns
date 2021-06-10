package by.bsu.nik.structural.composite.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Getter
@EqualsAndHashCode
@ToString
public class CompoundCountry extends BaseCountry {
    private List<Country> countries = new ArrayList<>();

    public CompoundCountry(){
        super("Default","Default", Collections.emptyList(), Collections.emptyList());
    }
    public CompoundCountry(List<Country> countries) {
        super(countries.get(0).getName(), countries.get(0).getCapital(), countries.get(0).getCities(), countries.get(0).getDistricts());
        add(countries);
    }

    public void add(Country component) {
        countries.add(component);
    }

    public void add(List<Country> components) {
        countries.addAll(components);
    }

    public void remove(Country country) {
        countries.remove(country);
    }

    public void remove(List<Country> components) {
        countries.removeAll(components);
    }

    public void clear() {
        countries.clear();
    }
}
