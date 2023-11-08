package gdsc.backend.jpa.dto;

import lombok.Getter;

@Getter
public class CreateMedicalDepartmentDto {
    private String name;
    private Long hospitalId;
}
