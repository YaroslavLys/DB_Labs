package lab6.mapper;

import lab6.domain.Reservation;
import lab6.dto.ReservationDto;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper extends AbstractMapper<Reservation, ReservationDto> {
    @Override
    public ReservationDto mapObjectToDto(Reservation reservation) {
        if (reservation == null) return null;

        ReservationDto.ReservationDtoBuilder reservationDtoBuilder = ReservationDto.builder();
        reservationDtoBuilder.id(reservation.getId());
        reservationDtoBuilder.userId(reservation.getUserId());
        reservationDtoBuilder.roomId(reservation.getRoomId());
        reservationDtoBuilder.startTime(reservation.getStartTime());
        reservationDtoBuilder.endTime(reservation.getEndTime());
        reservationDtoBuilder.paymentAmount(reservation.getPaymentAmount());
        reservationDtoBuilder.adults(reservation.getAdults());
        reservationDtoBuilder.kids(reservation.getKids());

        return reservationDtoBuilder.build();
    }
}
