package lab6.mapper;

import lab6.domain.Hotel;
import lab6.dto.HotelDto;
import org.springframework.stereotype.Component;

@Component
public class HotelMapper extends AbstractMapper<Hotel, HotelDto> {
    @Override
    public HotelDto mapObjectToDto(Hotel hotel) {
        if (hotel == null) return null;

        HotelDto.HotelDtoBuilder hotelDtoBuilder = HotelDto.builder();
        hotelDtoBuilder.id(hotel.getId());
        hotelDtoBuilder.name(hotel.getName());
        hotelDtoBuilder.city(hotel.getCity());
        hotelDtoBuilder.hotelChainId(hotel.getHotelChainId());
        hotelDtoBuilder.cityName(hotel.getCityName());
        hotelDtoBuilder.cityRegionName(hotel.getCityRegionName());
        hotelDtoBuilder.cityRegionCountryName(hotel.getCityRegionCountryName());

        return hotelDtoBuilder.build();
    }
}
