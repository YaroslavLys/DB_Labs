package lab6.mapper;

import lab6.domain.User;
import lab6.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends AbstractMapper<User, UserDto> {
    @Override
    public UserDto mapObjectToDto(User user) {
        if (user == null) return null;

        UserDto.UserDtoBuilder userDtoBuilder = UserDto.builder();
        userDtoBuilder.id(user.getId());
        userDtoBuilder.surname(user.getSurname());
        userDtoBuilder.name(user.getName());
        userDtoBuilder.email(user.getEmail());
        userDtoBuilder.gender(user.getGender());
        userDtoBuilder.age(user.getAge());
        userDtoBuilder.birthday(user.getBirthday());
        userDtoBuilder.phone(user.getPhone());

        return userDtoBuilder.build();
    }
}
