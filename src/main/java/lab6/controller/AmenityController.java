package lab6.controller;

import lab6.domain.Amenity;
import lab6.dto.AmenityDto;
import lab6.mapper.AbstractMapper;
import lab6.mapper.AmenityMapper;
import lab6.service.AbstractService;
import lab6.service.AmenityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/amenities")
@RestController
@AllArgsConstructor
public class AmenityController extends AbstractController<Amenity, AmenityDto, Integer> {
    private final AmenityService amenityService;
    private final AmenityMapper amenityMapper;


    @Override
    protected AbstractService<Amenity, Integer> getService() {
        return amenityService;
    }

    @Override
    protected AbstractMapper<Amenity, AmenityDto> getMapper() {
        return amenityMapper;
    }
}
