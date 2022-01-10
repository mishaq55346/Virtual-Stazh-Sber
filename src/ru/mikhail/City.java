package ru.mikhail;

public class City {
    private String name;// – наименование города
    private String region;// - регион
    private String district;// – федеральный округ
    private int population;// – количество жителей города
    private String foundation;// – дата основания или первое упоминание

    public City() {}

    public void setName(String name) {
        this.name = name;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setFoundation(String foundation) {
        this.foundation = foundation;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public String getDistrict() {
        return district;
    }

    public int getPopulation() {
        return population;
    }

    public String getFoundation() {
        return foundation;
    }

    @Override
    public String toString() {
        return (foundation != null) ? "City{name='%s', region='%s', district='%s', population=%s, foundation='%s'}".formatted(name, region, district, population, foundation)
                                    : "City{name='%s', region='%s', district='%s', population=%s, foundation=''}".formatted(name, region, district, population);
    }

}
