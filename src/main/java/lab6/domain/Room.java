package lab6.domain;

import javax.persistence.*;

@Entity
public class Room {
    private Integer id;
    private Integer hotelId;
    private String roomNumber;
    private String description;
    private Hotel hotelByHotelId;

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
    @Column(name = "hotel_id")
    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    @Basic
    @Column(name = "room_number")
    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (id != null ? !id.equals(room.id) : room.id != null) return false;
        if (roomNumber != null ? !roomNumber.equals(room.roomNumber) : room.roomNumber != null) return false;
        if (description != null ? !description.equals(room.description) : room.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (roomNumber != null ? roomNumber.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "hotel_id", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    public Hotel getHotelByHotelId() {
        return hotelByHotelId;
    }

    public void setHotelByHotelId(Hotel hotelByHotelId) {
        this.hotelByHotelId = hotelByHotelId;
    }

    public Room(){}

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
