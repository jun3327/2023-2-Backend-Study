package gdsc.backend.jpa.dto;

import lombok.Getter;

@Getter
public class CreateReservationDto {

    private Long doctorId;
    private Long patientId;

}
