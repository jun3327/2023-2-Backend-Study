package gdsc.backend.jpa.service;

import gdsc.backend.jpa.domain.Hospital;
import gdsc.backend.jpa.repository.HospitalRepository;
import gdsc.backend.jpa.domain.MedicalDepartment;
import gdsc.backend.jpa.repository.MedicalDepartmentRepository;
import gdsc.backend.jpa.dto.CreateMedicalDepartmentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicalDepartmentService {
    private final MedicalDepartmentRepository medicalDepartmentRepository;
    private final HospitalRepository hospitalRepository;

    public void createMedicalDepartment(CreateMedicalDepartmentDto createMedicalDepartmentDto) {
        Hospital hospital = hospitalRepository.findById(createMedicalDepartmentDto.getHospitalId())
                .orElseThrow(RuntimeException::new);
        medicalDepartmentRepository.save(new MedicalDepartment(hospital, createMedicalDepartmentDto.getName()));
    }

    public List<MedicalDepartment> getAllMedicalDepartment() {
        return medicalDepartmentRepository.findAllWithHospital();
    }
}
