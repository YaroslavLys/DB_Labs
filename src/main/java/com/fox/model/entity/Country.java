package com.fox.model.entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Country {

    private String name;
    private Integer population;
    private Integer area;

    public Country(String name, Integer population, Integer area) {
        this.name = name;
        this.population = population;
        this.area = area;
    }

    public Country(Integer population, Integer area) {
        this(null, population, area);
    }

    @Override
    public String toString() {
        return "\n\nCountry: name: " + name + ", population: " + population + ", area: " + area
                + "]";
    }

}
