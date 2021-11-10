package lab6.service;

import lab6.domain.Amenity;
import lab6.repository.AmenityRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AmenityService extends AbstractService<Amenity, Integer> {
    public AmenityRepository amenityRepository;

    @Override
    protected JpaRepository<Amenity, Integer> getRepository() {
        return amenityRepository;
    }
}
