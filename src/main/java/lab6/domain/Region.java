package lab6.domain;

import javax.persistence.*;

@Entity
@IdClass(lab6.domain.RegionPK.class)
public class Region {
    private String name;
    private String countryName;
    private String climate;
    private lab6.domain.Country countryByCountryName;

    @Id
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @Column(name = "country_name")
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Basic
    @Column(name = "climate")
    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Region region = (Region) o;

        if (name != null ? !name.equals(region.name) : region.name != null) return false;
        if (countryName != null ? !countryName.equals(region.countryName) : region.countryName != null) return false;
        if (climate != null ? !climate.equals(region.climate) : region.climate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (countryName != null ? countryName.hashCode() : 0);
        result = 31 * result + (climate != null ? climate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "country_name", referencedColumnName = "name", nullable = false, insertable = false, updatable = false)
    public lab6.domain.Country getCountryByCountryName() {
        return countryByCountryName;
    }

    public void setCountryByCountryName(lab6.domain.Country countryByCountryName) {
        this.countryByCountryName = countryByCountryName;
    }

    public Region(){}

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
