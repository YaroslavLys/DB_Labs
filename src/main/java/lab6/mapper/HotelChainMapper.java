package lab6.mapper;


import lab6.domain.HotelChain;
import lab6.dto.HotelChainDto;
import org.springframework.stereotype.Component;

@Component
public class HotelChainMapper extends AbstractMapper<HotelChain, HotelChainDto> {
    @Override
    public HotelChainDto mapObjectToDto(HotelChain hotelChain) {
        if (hotelChain == null) return null;
        HotelChainDto.HotelChainDtoBuilder hotelChainDtoBuilder = HotelChainDto.builder();
        hotelChainDtoBuilder.id(hotelChain.getId());
        hotelChainDtoBuilder.name(hotelChain.getName());
        hotelChainDtoBuilder.type(hotelChain.getType());
        hotelChainDtoBuilder.parentCompany(hotelChain.getParentCompany());

        return hotelChainDtoBuilder.build();
    }
}
