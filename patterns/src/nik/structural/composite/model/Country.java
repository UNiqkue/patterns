package nik.structural.composite.model;

import java.util.List;

public interface Country {
    String getName();
    String getCapital();
    List<String> getCities();
    List<String> getDistricts();
}
