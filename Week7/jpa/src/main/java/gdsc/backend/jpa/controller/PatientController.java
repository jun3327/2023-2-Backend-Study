package gdsc.backend.jpa.controller;

import gdsc.backend.jpa.domain.Patient;
import gdsc.backend.jpa.dto.CreatePatientDto;
import gdsc.backend.jpa.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    @PostMapping()
    public void createPatient(@RequestBody CreatePatientDto createPatientDto) {
        patientService.createPatient(createPatientDto);
    }

    @GetMapping()
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }
}
