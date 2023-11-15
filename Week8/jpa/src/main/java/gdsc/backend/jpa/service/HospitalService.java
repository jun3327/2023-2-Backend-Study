package gdsc.backend.jpa.service;

import gdsc.backend.jpa.domain.Hospital;
import gdsc.backend.jpa.dto.UpdateHospitalDto;
import gdsc.backend.jpa.repository.HospitalRepository;
import gdsc.backend.jpa.dto.CreateHospitalDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HospitalService {

    private final HospitalRepository hospitalRepository;

    public void createHospital(CreateHospitalDto createHospitalDto) {
        hospitalRepository.save(new Hospital(createHospitalDto.getName()));
    }

    public List<Hospital> getAllHospitals() {
        return hospitalRepository.findAll();
    }

    public Hospital getHospitalByName(String name) {
        return hospitalRepository.findByName(name);
    }
    public Hospital getHospitalById(Long id) {
        return hospitalRepository.findById(id).orElseThrow(RuntimeException::new);
    }
    @Transactional
    public void updateHospital(Long id, UpdateHospitalDto updateHospitalDto) {
        Hospital hospital = hospitalRepository.findById(id).orElseThrow(RuntimeException::new);
        hospital.updateName(updateHospitalDto.getName());
    }

    @Transactional
    public void deleteHospital(Long id) {
        hospitalRepository.deleteById(id);
    }
}