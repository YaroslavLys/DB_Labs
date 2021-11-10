package lab6.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AmenityDto {
    private Integer id;
    private Integer roomId;
    private String name;
    private BigInteger price;
}
