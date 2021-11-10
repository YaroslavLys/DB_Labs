package lab6.controller;
import lab6.domain.HotelChain;
import lab6.dto.HotelChainDto;
import lab6.mapper.AbstractMapper;
import lab6.mapper.HotelChainMapper;
import lab6.service.AbstractService;
import lab6.service.HotelChainService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/hotelchains")
@RestController
@AllArgsConstructor
public class HotelChainController extends AbstractController<HotelChain, HotelChainDto, Integer> {
    private final HotelChainService hotelChainService;
    private final HotelChainMapper hotelChainMapper;


    @Override
    protected AbstractService<HotelChain, Integer> getService() {
        return hotelChainService;
    }

    @Override
    protected AbstractMapper<HotelChain, HotelChainDto> getMapper() {
        return hotelChainMapper;
    }
}
