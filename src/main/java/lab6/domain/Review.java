package lab6.domain;

import javax.persistence.*;

@Entity
public class Review {
    private Integer id;
    private Integer userId;
    private Integer hotelId;
    private String text;
    private Integer rate;
    private lab6.domain.Hotel hotelByHotelId;

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
    @Column(name = "hotel_id")
    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    @Basic
    @Column(name = "text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "rate")
    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Review review = (Review) o;

        if (id != null ? !id.equals(review.id) : review.id != null) return false;
        if (text != null ? !text.equals(review.text) : review.text != null) return false;
        if (rate != null ? !rate.equals(review.rate) : review.rate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (rate != null ? rate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "hotel_id", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    public lab6.domain.Hotel getHotelByHotelId() {
        return hotelByHotelId;
    }

    public void setHotelByHotelId(lab6.domain.Hotel hotelByHotelId) {
        this.hotelByHotelId = hotelByHotelId;
    }

    public Review(){}

    public Review(Integer id, String text, Integer rate, Integer hotelId, Integer userId) {
        this.id = id;
        this.text = text;
        this.rate = rate;
        this.hotelId = hotelId;
        this.userId = userId;
    }

    public Review(String text, Integer rate, Integer hotelId, Integer userId) {
        this(null, text, rate, hotelId, userId);
    }

    @Override
    public String toString() {
        return "\n\nReview: id: " + id + ", text: " + text + ", rate: " + rate + ", hotel id: "
                + hotelId + ", user id: " + userId
                + "]";
    }
}
