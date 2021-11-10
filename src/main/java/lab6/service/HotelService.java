package lab6.service;

import lab6.domain.Hotel;
import lab6.repository.HotelRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class HotelService extends AbstractService<Hotel, Integer> {
    public HotelRepository hotelRepository;

    @Override
    protected JpaRepository<Hotel, Integer> getRepository() {
        return hotelRepository;
    }
}
