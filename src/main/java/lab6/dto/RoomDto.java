package lab6.dto;
import lab6.domain.Hotel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomDto {
    private Integer id;
    private Integer hotelId;
    private String roomNumber;
    private String description;
    private Hotel hotelByHotelId;
}
