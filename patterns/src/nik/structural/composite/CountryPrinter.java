package nik.structural.composite;

import nik.structural.composite.model.CompoundCountry;
import nik.structural.composite.model.Country;

import java.util.Arrays;

public class CountryPrinter {
    private CompoundCountry country = new CompoundCountry();

    public void loadCountries(Country... countries) {
        this.country.clear();
        this.country.add(Arrays.asList(countries));
    }

    public void print() {
        if (country.getCountries() != null) {
            country.getCountries()
                    .forEach(country -> {
                        if (country instanceof CompoundCountry) {
                            CompoundCountry compoundCountry = (CompoundCountry) country;
                            if (compoundCountry.getCountries() != null) {
                                compoundCountry.getCountries()
                                        .forEach(c -> System.out.println("Страна класса CompoundCountry " + c));
                            }
                        } else
                            System.out.println(country);
                    });
        } else System.out.println("Стран в списке нет");
    }
}
