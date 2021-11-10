package lab6.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class CityPK implements Serializable {
    private String name;
    private String regionName;
    private String regionCountryName;

    @Column(name = "name")
    @Id
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "region_name")
    @Id
    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Column(name = "region_country_name")
    @Id
    public String getRegionCountryName() {
        return regionCountryName;
    }

    public void setRegionCountryName(String regionCountryName) {
        this.regionCountryName = regionCountryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CityPK cityPK = (CityPK) o;

        if (name != null ? !name.equals(cityPK.name) : cityPK.name != null) return false;
        if (regionName != null ? !regionName.equals(cityPK.regionName) : cityPK.regionName != null) return false;
        if (regionCountryName != null ? !regionCountryName.equals(cityPK.regionCountryName) : cityPK.regionCountryName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (regionName != null ? regionName.hashCode() : 0);
        result = 31 * result + (regionCountryName != null ? regionCountryName.hashCode() : 0);
        return result;
    }
}
