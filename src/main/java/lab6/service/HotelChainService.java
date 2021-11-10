package lab6.service;

import lab6.domain.HotelChain;
import lab6.repository.HotelChainRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class HotelChainService extends AbstractService<HotelChain, Integer> {
    public HotelChainRepository hotelChainRepository;

    @Override
    protected JpaRepository<HotelChain, Integer> getRepository() {
        return hotelChainRepository;
    }
}