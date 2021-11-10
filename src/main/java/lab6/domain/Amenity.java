package lab6.domain;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
public class Amenity {
    private Integer id;
    private Integer roomId;
    private String name;
    private BigInteger price;

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
    @Column(name = "room_id")
    public Integer getRoomIdId() {
        return roomId;
    }

    public void setRoomIdId(Integer roomId) {
        this.roomId = roomId;
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
    @Column(name = "price")
    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Amenity amenity = (Amenity) o;

        if (id != null ? !id.equals(amenity.id) : amenity.id != null) return false;
        if (name != null ? !name.equals(amenity.name) : amenity.name != null) return false;
        if (price != null ? !price.equals(amenity.price) : amenity.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    public Amenity() {
    }

    public Amenity(Integer id, Integer roomId, String name, BigInteger price) {
        this.id = id;
        this.roomId = roomId;
        this.name = name;
        this.price = price;
    }

    public Amenity(Integer roomId, String name, BigInteger price) {
        this(null, roomId, name, price);
    }

    @Override
    public String toString() {
        return "\n\nAmenity: id: " + id + ", name: " + name + ", price: " + price
                + "]";
    }
}
