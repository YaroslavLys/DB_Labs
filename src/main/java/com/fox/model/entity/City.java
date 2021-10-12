package com.fox.model.entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class City {

    private String name;
    private String regionName;
    private String regionCountryName;
    private String language;

    public City(String name, String regionName, String regionCountryName, String language) {
        this.name = name;
        this.regionName = regionName;
        this.regionCountryName = regionCountryName;
        this.language = language;
    }
    public City(String language) {
        this(null, null, null, language);
    }

    @Override
    public String toString() {
        return "\n\nCity: name: " + name + ", region name: " + regionName + ", country name: "
                + regionCountryName + ", language: " + language
                + "]";
    }
}
