package nik.structural;

import nik.structural.composite.CountryPrinter;
import nik.structural.composite.model.BaseCountry;
import nik.structural.composite.model.CompoundCountry;
import nik.structural.composite.model.EuropianCountry;

import java.util.Arrays;

public class Main {
    //Сomposite. Разработать структуру данных для хранения информации о государствах, их административных частях и городах
    public static void main(String[] args) {
        CountryPrinter countryPrinter = new CountryPrinter();

        countryPrinter.loadCountries(
                new EuropianCountry("Germany", "Berlin", Arrays.asList("Bavaria", "East Germany"), Arrays.asList("Munchen", "Bohn", "Lepcig")),
                new CompoundCountry(Arrays.asList(
                        new BaseCountry("Australia", "Canberra", Arrays.asList("State", "Centre"), Arrays.asList("Sidney", "City")),
                        new BaseCountry("New Zeland", "Wellington", Arrays.asList("State", "West"), Arrays.asList("Oklend", "Danidin"))
                ))
        );
        countryPrinter.print();
    }
}
