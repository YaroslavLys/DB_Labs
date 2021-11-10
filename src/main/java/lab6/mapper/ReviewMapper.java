package lab6.mapper;

import lab6.domain.Review;
import lab6.dto.ReviewDto;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper extends AbstractMapper<Review, ReviewDto> {
    @Override
    public ReviewDto mapObjectToDto(Review review) {
        if (review == null) return null;

        ReviewDto.ReviewDtoBuilder reviewDtoBuilder = ReviewDto.builder();
        reviewDtoBuilder.id(review.getId());
        reviewDtoBuilder.userId(review.getUserId());
        reviewDtoBuilder.hotelId(review.getHotelId());
        reviewDtoBuilder.text(review.getText());
        reviewDtoBuilder.rate(review.getRate());
        reviewDtoBuilder.hotelByHotelId(review.getHotelByHotelId());

        return reviewDtoBuilder.build();
    }
}
