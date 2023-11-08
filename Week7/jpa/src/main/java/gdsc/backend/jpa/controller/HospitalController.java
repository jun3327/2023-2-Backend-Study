package gdsc.backend.jpa.controller;

import gdsc.backend.jpa.domain.Hospital;
import gdsc.backend.jpa.dto.CreateHospitalDto;
import gdsc.backend.jpa.service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospitals")
@RequiredArgsConstructor
public class HospitalController {

    private final HospitalService hospitalService;

    @GetMapping()
    public List<Hospital> getAllHospitals() {
        return hospitalService.getAllHospitals();
    }

    @PostMapping()
    public void createHospital(@RequestBody CreateHospitalDto createHospitalDto) {
        hospitalService.createHospital(createHospitalDto);
    }

    @GetMapping("/{name}")
    public Hospital getHospitalByName(@PathVariable("name") String name) {
        return hospitalService.getHospitalByName(name);
    }
}
