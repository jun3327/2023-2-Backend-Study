package gdsc.backend.jpa.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class CreateReservationDto {

    private Long doctorId;
    private Long patientId;
    private LocalDateTime time;
}
