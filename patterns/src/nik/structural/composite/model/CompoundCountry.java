package nik.structural.composite.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CompoundCountry extends BaseCountry {
    private List<Country> countries = new ArrayList<>();

    public CompoundCountry(){
        super("Default","Default", Collections.emptyList(), Collections.emptyList());
    }
    public CompoundCountry(List<Country> countries) {
        super(countries.get(0).getName(), countries.get(0).getCapital(), countries.get(0).getCities(), countries.get(0).getDistricts());
        add(countries);
    }

    public List<Country> getCountries() {
        return countries;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CompoundCountry that = (CompoundCountry) o;
        return Objects.equals(countries, that.countries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), countries);
    }

    @Override
    public String toString() {
        return "CompoundCountry{" +
                "countries=" + countries +
                '}';
    }
}
