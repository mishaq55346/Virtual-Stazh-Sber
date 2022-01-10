package ru.mikhail;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String fileName = "city_ru.csv";
        List<City> cities = CityUtils.parseFile(CityUtils.loadFile(fileName));
        CityUtils.print(cities);
        CityUtils.getSrez(cities);
    }


}
