package lab6.controller;

import lab6.domain.Room;
import lab6.dto.RoomDto;
import lab6.mapper.AbstractMapper;
import lab6.mapper.RoomMapper;
import lab6.service.AbstractService;
import lab6.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping(value = "/rooms")
@RestController
@AllArgsConstructor
public class RoomController extends AbstractController<Room, RoomDto, Integer> {
    private final RoomService roomService;
    private final RoomMapper roomMapper;


    @Override
    protected AbstractService<Room, Integer> getService() {
        return roomService;
    }

    @Override
    protected AbstractMapper<Room, RoomDto> getMapper() {
        return roomMapper;
    }
}
