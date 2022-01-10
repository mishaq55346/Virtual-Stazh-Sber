package ru.mikhail;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CityUtils {
    static ArrayList<City> parseFile(File file){
        Scanner sc;
        try {
             sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        ArrayList<City> cities = new ArrayList<>();
        City city;
        while (sc.hasNextLine()){
            Scanner lineScanner = new Scanner(sc.nextLine());
            lineScanner.useDelimiter(";");
            city = new City();
            lineScanner.skip(Pattern.compile("\\d*"));
            //regex: если первая - цифра, то пропускаем всё. Также явно указываем,
            // что это шаблон регулярных выражений
            city.setName(lineScanner.next());
            city.setRegion(lineScanner.next());
            city.setDistrict(lineScanner.next());
            city.setPopulation(lineScanner.nextInt());
            if (lineScanner.hasNext())
                city.setFoundation(lineScanner.next());
            else city.setFoundation("");
            cities.add(city);//Чтобы не добавлять один и тот жн объект
            lineScanner.close();
        }
        sc.close();
        return cities;
    }

    static File loadFile(String fileName){
        URL resource = Main.class.getClassLoader().getResource(fileName);//загрузка
        File file = null;
        try {
            if (resource == null)
                throw new MissingResourceException("city_ru.csv file is missing!", "CityUtils", "city_ru.csv");
            file = Paths.get(resource.toURI()).toFile();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return file;
    }

    static void print(List<City> list){
        list.forEach(System.out::println);
    }

    static void sortByName(List<City> list){
        list.sort(Comparator.comparing(City::getName));
    }

    static void sortByDistrict(List<City> list){
        list.sort(Comparator.comparing(City::getDistrict).thenComparing(City::getName));
    }

    static void findMax(List<City> list){
        City c = list.stream().max(Comparator.comparing(City::getPopulation)).get();
        System.out.println(String.format("Кол-во людей в г.%s - %,d человек", c.getName(), c.getPopulation()));
    }

    public static void getSrez(List<City> list) {
        Map<String, Integer> srez = new HashMap<>();
        list.forEach(c -> srez.merge(c.getRegion(), 1, Integer::sum));
        srez.forEach((a,b) -> System.out.printf("%s - %d%n", a, b));
    }
}
