package lab6.domain;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
public class Reservation {
    private Integer userId;
    private Integer roomId;
    private Integer id;
    private Timestamp startTime;
    private Timestamp endTime;
    private BigInteger paymentAmount;
    private Integer adults;
    private Integer kids;

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
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "room_id")
    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    @Basic
    @Column(name = "start_time")
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "end_time")
    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "payment_amount")
    public BigInteger getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigInteger paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    @Basic
    @Column(name = "adults")
    public Integer getAdults() {
        return adults;
    }

    public void setAdults(Integer adults) {
        this.adults = adults;
    }

    @Basic
    @Column(name = "kids")
    public Integer getKids() {
        return kids;
    }

    public void setKids(Integer kids) {
        this.kids = kids;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reservation that = (Reservation) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        if (paymentAmount != null ? !paymentAmount.equals(that.paymentAmount) : that.paymentAmount != null)
            return false;
        if (adults != null ? !adults.equals(that.adults) : that.adults != null) return false;
        if (kids != null ? !kids.equals(that.kids) : that.kids != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (paymentAmount != null ? paymentAmount.hashCode() : 0);
        result = 31 * result + (adults != null ? adults.hashCode() : 0);
        result = 31 * result + (kids != null ? kids.hashCode() : 0);
        return result;
    }

    public Reservation(){}

    public Reservation(Integer id, Integer userId, Integer roomId, Timestamp startTime, Timestamp endTime,
                       BigInteger paymentAmount, Integer adults, Integer kids) {
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
                       BigInteger paymentAmount, Integer adults, Integer kids) {
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
