package com.fox.model.entity;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class Hotel {

    private Integer id;
    private String name;
    private Integer hotelChainId;
    private String cityName;
    private String cityRegionName;
    private String cityRegionCountryName;

    public Hotel(Integer id, String name, Integer hotelChainId, String cityName, String cityRegionName, String cityRegionCountryName) {
        this.id = id;
        this.name = name;
        this.hotelChainId = hotelChainId;
        this.cityName = cityName;
        this.cityRegionName = cityRegionName;
        this.cityRegionCountryName = cityRegionCountryName;
    }

    public Hotel(String name, Integer hotelChainId, String cityName, String cityRegionName, String cityRegionCountryName) {
        this(null, name, hotelChainId, cityName, cityRegionName, cityRegionCountryName);
    }

    @Override
    public String toString() {
        return "\n\nHotel: id: " + id + ", name: " + name + ", hotel chain id: " + hotelChainId
                + ", city name: " + cityName + ", region name: " + cityRegionName + ", country name: " + cityRegionCountryName
                + "]";
    }
}
