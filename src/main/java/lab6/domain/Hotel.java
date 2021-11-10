package lab6.domain;

import javax.persistence.*;

@Entity
public class Hotel {
    private Integer hotelChainId;
    private String cityName;
    private String cityRegionName;
    private String cityRegionCountryName;
    private Integer id;
    private String name;
    private lab6.domain.City city;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "hotel_chain_id")
    public Integer getHotelChainId() {
        return id;
    }

    public void setHotelChainId(Integer hotelChainId) {
        this.hotelChainId = hotelChainId;
    }

    @Basic
    @Column(name = "city_name")
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Basic
    @Column(name = "city_region_name")
    public String getCityRegionName() {
        return cityRegionName;
    }

    public void setCityRegionName(String cityRegionName) {
        this.cityRegionName = cityRegionName;
    }

    @Basic
    @Column(name = "city_region_country_name")
    public String getCityRegionCountryName() {
        return cityRegionCountryName;
    }

    public void setCityRegionCountryName(String cityRegionCountryName) {
        this.cityRegionCountryName = cityRegionCountryName;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hotel hotel = (Hotel) o;

        if (id != null ? !id.equals(hotel.id) : hotel.id != null) return false;
        if (name != null ? !name.equals(hotel.name) : hotel.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "city_name", referencedColumnName = "name", nullable = false, updatable = false, insertable = false), @JoinColumn(name = "city_region_name", referencedColumnName = "region_name", nullable = false, updatable = false, insertable = false), @JoinColumn(name = "city_region_country_name", referencedColumnName = "region_country_name", nullable = false, updatable = false, insertable = false)})
    public lab6.domain.City getCity() {
        return city;
    }

    public void setCity(lab6.domain.City city) {
        this.city = city;
    }

    public Hotel(){}

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
