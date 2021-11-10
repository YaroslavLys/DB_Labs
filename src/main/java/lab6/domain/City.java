package lab6.domain;

import javax.persistence.*;

@Entity
@IdClass(CityPK.class)
public class City {
    private String name;
    private String regionName;
    private String regionCountryName;
    private String language;

    @Id
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @Column(name = "region_name")
    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Id
    @Column(name = "region_country_name")
    public String getRegionCountryName() {
        return regionCountryName;
    }

    public void setRegionCountryName(String regionCountryName) {
        this.regionCountryName = regionCountryName;
    }

    @Basic
    @Column(name = "language")
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (name != null ? !name.equals(city.name) : city.name != null) return false;
        if (regionName != null ? !regionName.equals(city.regionName) : city.regionName != null) return false;
        if (regionCountryName != null ? !regionCountryName.equals(city.regionCountryName) : city.regionCountryName != null)
            return false;
        if (language != null ? !language.equals(city.language) : city.language != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (regionName != null ? regionName.hashCode() : 0);
        result = 31 * result + (regionCountryName != null ? regionCountryName.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        return result;
    }

    public City(){}

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
