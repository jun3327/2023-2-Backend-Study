package gdsc.backend.jpa.controller;

import gdsc.backend.jpa.domain.Doctor;
import gdsc.backend.jpa.dto.CreateDoctorDto;
import gdsc.backend.jpa.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @PostMapping()
    public void createDoctor(@RequestBody CreateDoctorDto createDoctorDto) {
        doctorService.createDoctor(createDoctorDto);
    }

    @GetMapping()
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }
}
