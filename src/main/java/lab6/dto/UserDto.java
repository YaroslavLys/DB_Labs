package lab6.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private Integer id;
    private String surname;
    private String name;
    private String email;
    private String gender;
    private Integer age;
    private Timestamp birthday;
    private String phone;
}
