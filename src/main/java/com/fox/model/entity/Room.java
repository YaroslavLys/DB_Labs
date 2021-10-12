package com.fox.model.entity;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class Room {

    private Integer id;
    private Integer hotelId;
    private String roomNumber;
    private String description;

    public Room(Integer id, Integer hotelId, String roomNumber, String description) {
        this.id = id;
        this.hotelId = hotelId;
        this.roomNumber = roomNumber;
        this.description = description;
    }

    public Room(Integer hotelId, String roomNumber, String description) {
        this(null, hotelId, roomNumber, description);
    }

    @Override
    public String toString() {
        return "\n\nRoom: id: " + id + ", hotel id: " + hotelId + ", room number: " + roomNumber
                + ", description: " + description
                + "]";
    }
}
