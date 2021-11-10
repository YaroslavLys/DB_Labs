package lab6.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.sql.Timestamp;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservationDto {
    private Integer userId;
    private Integer roomId;
    private Integer id;
    private Timestamp startTime;
    private Timestamp endTime;
    private BigInteger paymentAmount;
    private Integer adults;
    private Integer kids;
}
