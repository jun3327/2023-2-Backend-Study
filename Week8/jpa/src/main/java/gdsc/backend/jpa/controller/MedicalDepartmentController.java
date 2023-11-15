package gdsc.backend.jpa.controller;

import gdsc.backend.jpa.domain.MedicalDepartment;
import gdsc.backend.jpa.dto.CreateMedicalDepartmentDto;
import gdsc.backend.jpa.service.MedicalDepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicalDepartments")
@RequiredArgsConstructor
public class MedicalDepartmentController {
    private final MedicalDepartmentService medicalDepartment;

    @GetMapping()
    public List<MedicalDepartment> getAllMedicalDepartment() {
        return medicalDepartment.getAllMedicalDepartment();
    }

    @PostMapping()
    public void createMedicalDepartment(@RequestBody CreateMedicalDepartmentDto createMedicalDepartment) {
        medicalDepartment.createMedicalDepartment(createMedicalDepartment);
    }
}
