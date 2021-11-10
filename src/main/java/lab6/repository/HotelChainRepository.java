package lab6.repository;


import lab6.domain.HotelChain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelChainRepository extends JpaRepository<HotelChain, Integer> {
}
