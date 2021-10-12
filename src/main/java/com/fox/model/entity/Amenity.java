package com.fox.model.entity;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class Amenity {

    private Integer id;
    private Integer roomId;
    private String name;
    private Integer price;

    public Amenity(Integer id, Integer roomId, String name, Integer price) {
        this.id = id;
        this.roomId = roomId;
        this.name = name;
        this.price = price;
    }

    public Amenity(Integer roomId, String name, Integer price) {
        this(null, roomId, name, price);
    }

    @Override
    public String toString() {
        return "\n\nAmenity: id: " + id + ", name: " + name + ", price: " + price
                + "]";
    }
}
