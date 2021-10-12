package com.fox.model.entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Region {

    private String name;
    private String countryName;
    private String climate;

    public Region(String name, String countryName, String climate) {
        this.name = name;
        this.countryName = countryName;
        this.climate = climate;
    }

    public Region(String climate) {
        this(null, null, climate);
    }

    @Override
    public String toString() {
        return "\n\nRegion: name: " + name + ", countryName: " + countryName + ", climate: " + climate
                + "]";
    }
}
