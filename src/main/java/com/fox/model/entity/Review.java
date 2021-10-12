package com.fox.model.entity;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class Review {

    private Integer id;
    private String text;
    private Integer rate;
    private Integer hotelId;
    private Integer userId;

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
