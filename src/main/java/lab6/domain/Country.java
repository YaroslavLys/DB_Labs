package lab6.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Country {
    private String name;
    private Integer population;
    private Integer area;

    @Id
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "population")
    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    @Basic
    @Column(name = "area")
    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (name != null ? !name.equals(country.name) : country.name != null) return false;
        if (population != null ? !population.equals(country.population) : country.population != null) return false;
        if (area != null ? !area.equals(country.area) : country.area != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (population != null ? population.hashCode() : 0);
        result = 31 * result + (area != null ? area.hashCode() : 0);
        return result;
    }

    public Country(){}

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
