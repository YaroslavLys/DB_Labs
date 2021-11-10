package lab6.domain;

import javax.persistence.*;

@Entity
@Table(name = "hotel_chain", schema = "lys_db")
public class HotelChain {
    private Integer id;
    private String name;
    private String type;
    private String parentCompany;

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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "parent_company")
    public String getParentCompany() {
        return parentCompany;
    }

    public void setParentCompany(String parentCompany) {
        this.parentCompany = parentCompany;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HotelChain that = (HotelChain) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (parentCompany != null ? !parentCompany.equals(that.parentCompany) : that.parentCompany != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (parentCompany != null ? parentCompany.hashCode() : 0);
        return result;
    }

    public HotelChain(){}

    public HotelChain(Integer id, String name, String type, String parentCompany) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.parentCompany = parentCompany;
    }

    public HotelChain(String name, String type, String parentCompany) {
        this(null, name, type, parentCompany);
    }

    @Override
    public String toString() {
        return "\n\nHotel chain: id: " + id + ", name: " + name + ", type: " + type + ", parent_company: " + parentCompany
                + "]";
    }
}
