package lab6.mapper;

import lab6.domain.Amenity;
import lab6.dto.AmenityDto;
import org.springframework.stereotype.Component;

@Component
public class AmenityMapper extends AbstractMapper<Amenity, AmenityDto>{
    @Override
    public AmenityDto mapObjectToDto(Amenity amenity) {
        if (amenity == null) return null;

        AmenityDto.AmenityDtoBuilder amenityDtoBuilder = AmenityDto.builder();
        amenityDtoBuilder.id(amenity.getId());
        amenityDtoBuilder.roomId(amenity.getRoomIdId());
        amenityDtoBuilder.name(amenity.getName());
        amenityDtoBuilder.price(amenity.getPrice());

        return amenityDtoBuilder.build();
    }
}
