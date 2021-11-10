package lab6.service;
import lab6.domain.Room;
import lab6.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RoomService extends AbstractService<Room, Integer> {
    public RoomRepository roomRepository;

    @Override
    protected JpaRepository<Room, Integer> getRepository() {
        return roomRepository;
    }
}
