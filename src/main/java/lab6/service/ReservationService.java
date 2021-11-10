package lab6.service;
import lab6.domain.Reservation;
import lab6.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ReservationService  extends AbstractService<Reservation, Integer> {
    public ReservationRepository reservationRepository;

    @Override
    protected JpaRepository<Reservation, Integer> getRepository() {
        return reservationRepository;
    }
}
