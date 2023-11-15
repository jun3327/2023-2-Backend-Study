package gdsc.backend.jpa.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdateReservationDto {

    private LocalDateTime time;
}
