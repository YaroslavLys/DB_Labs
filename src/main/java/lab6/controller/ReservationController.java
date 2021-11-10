package lab6.controller;


import lab6.domain.Reservation;
import lab6.dto.ReservationDto;
import lab6.mapper.AbstractMapper;
import lab6.mapper.ReservationMapper;
import lab6.service.AbstractService;
import lab6.service.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/reservations")
@RestController
@AllArgsConstructor
public class ReservationController extends AbstractController<Reservation, ReservationDto, Integer> {
    private final ReservationService reservationService;
    private final ReservationMapper reservationMapper;


    @Override
    protected AbstractService<Reservation, Integer> getService() {
        return reservationService;
    }

    @Override
    protected AbstractMapper<Reservation, ReservationDto> getMapper() {
        return reservationMapper;
    }
}
