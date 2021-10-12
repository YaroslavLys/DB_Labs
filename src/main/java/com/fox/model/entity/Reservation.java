package com.fox.model.entity;
import java.sql.Timestamp;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class Reservation {

    private Integer id;
    private Integer userId;
    private Integer roomId;
    private Timestamp startTime;
    private Timestamp endTime;
    private Integer paymentAmount;
    private Integer adults;
    private Integer kids;

    public Reservation(Integer id, Integer userId, Integer roomId, Timestamp startTime, Timestamp endTime,
                       Integer paymentAmount, Integer adults, Integer kids) {
        this.id = id;
        this.userId = userId;
        this.roomId = roomId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.paymentAmount = paymentAmount;
        this.adults = adults;
        this.kids = kids;
    }

    public Reservation(Integer userId, Integer roomId, Timestamp startTime, Timestamp endTime,
                       Integer paymentAmount, Integer adults, Integer kids) {
        this(null, userId, roomId, startTime, endTime, paymentAmount, adults, kids);
    }

    @Override
    public String toString() {
        return "\n\nReservation: id: " + id + ", user id: " + userId + ", room id: " + roomId
                + ", start time: " + startTime + ", end time: " + endTime + ", payment: "
                + paymentAmount +", adults: " + adults +", kids: " + kids
                + "]";
    }

}
