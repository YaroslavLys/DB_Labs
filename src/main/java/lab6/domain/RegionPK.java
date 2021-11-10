package lab6.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class RegionPK implements Serializable {
    private String name;
    private String countryName;

    @Column(name = "name")
    @Id
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "country_name")
    @Id
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegionPK regionPK = (RegionPK) o;

        if (name != null ? !name.equals(regionPK.name) : regionPK.name != null) return false;
        if (countryName != null ? !countryName.equals(regionPK.countryName) : regionPK.countryName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (countryName != null ? countryName.hashCode() : 0);
        return result;
    }
}
