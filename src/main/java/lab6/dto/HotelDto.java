package lab6.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HotelDto {
    private Integer hotelChainId;
    private String cityName;
    private String cityRegionName;
    private String cityRegionCountryName;
    private Integer id;
    private String name;
    private lab6.domain.City city;
}
