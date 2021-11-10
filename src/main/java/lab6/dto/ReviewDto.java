package lab6.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewDto {
    private Integer id;
    private Integer userId;
    private Integer hotelId;
    private String text;
    private Integer rate;
    private lab6.domain.Hotel hotelByHotelId;
}
