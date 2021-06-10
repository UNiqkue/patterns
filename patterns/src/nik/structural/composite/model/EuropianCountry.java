package nik.structural.composite.model;

import java.util.List;
import java.util.Objects;

public class EuropianCountry implements Country {
    private final String name;
    private final String capital;
    private final List<String> districts;
    private final List<String> cities;

    public EuropianCountry(String name, String capital, List<String> districts, List<String> cities) {
        this.name = name;
        this.capital = capital;
        this.districts = districts;
        this.cities = cities;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getCapital() {
        return capital;
    }

    @Override
    public List<String> getDistricts() {
        return districts;
    }

    @Override
    public List<String> getCities() {
        return cities;
    }

    @Override
    public String toString() {
        return "EuropianCountry{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", districts=" + districts +
                ", cities=" + cities +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EuropianCountry that = (EuropianCountry) o;
        return Objects.equals(name, that.name) && Objects.equals(capital, that.capital) && Objects.equals(districts, that.districts) && Objects.equals(cities, that.cities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, capital, districts, cities);
    }
}
