package gdsc.backend.jpa.service;

import gdsc.backend.jpa.domain.Patient;
import gdsc.backend.jpa.repository.PatientRepository;
import gdsc.backend.jpa.dto.CreatePatientDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    public void createPatient(CreatePatientDto createPatientDto) {
        patientRepository.save(new Patient(createPatientDto.getName()));
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
}
