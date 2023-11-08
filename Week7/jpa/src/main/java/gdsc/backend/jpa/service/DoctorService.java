package gdsc.backend.jpa.service;

import gdsc.backend.jpa.domain.Doctor;
import gdsc.backend.jpa.repository.DoctorRepository;
import gdsc.backend.jpa.domain.MedicalDepartment;
import gdsc.backend.jpa.repository.MedicalDepartmentRepository;
import gdsc.backend.jpa.dto.CreateDoctorDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final MedicalDepartmentRepository medicalDepartmentRepository;

    public void createDoctor(CreateDoctorDto createDoctorDto) {
        MedicalDepartment department = medicalDepartmentRepository.findById(createDoctorDto.getMedicalDepartmentId())
                        .orElseThrow(RuntimeException::new);
        doctorRepository.save(new Doctor(createDoctorDto.getName(), department));
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAllWithMedicalDepartment();
    }
}
