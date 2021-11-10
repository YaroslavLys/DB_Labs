package lab6.mapper;

import lab6.domain.Room;
import lab6.dto.RoomDto;
import org.springframework.stereotype.Component;

@Component
public class RoomMapper extends AbstractMapper<Room, RoomDto> {
    @Override
    public RoomDto mapObjectToDto(Room room) {
        if (room == null) return null;

        RoomDto.RoomDtoBuilder roomDtoBuilder = RoomDto.builder();
        roomDtoBuilder.id(room.getId());
        roomDtoBuilder.hotelId(room.getHotelId());
        roomDtoBuilder.roomNumber(room.getRoomNumber());
        roomDtoBuilder.description(room.getDescription());
        roomDtoBuilder.hotelByHotelId(room.getHotelByHotelId());

        return roomDtoBuilder.build();
    }
}
