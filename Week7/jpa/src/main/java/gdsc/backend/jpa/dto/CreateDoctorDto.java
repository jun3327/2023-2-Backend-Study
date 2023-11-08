package gdsc.backend.jpa.dto;

import lombok.Getter;

@Getter
public class CreateDoctorDto {

    private String name;
    private Long medicalDepartmentId;

}
