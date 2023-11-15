package gdsc.backend.jpa.controller;

import gdsc.backend.jpa.domain.Hospital;
import gdsc.backend.jpa.dto.CreateHospitalDto;
import gdsc.backend.jpa.dto.UpdateHospitalDto;
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

    @GetMapping("/{param}")
    public Hospital getHospitalByName(@PathVariable("param") String param) {
        if (param.chars().allMatch(Character::isDigit)) {
            Long id = Long.parseLong(param);
            return hospitalService.getHospitalById(id);
        } else {
            return hospitalService.getHospitalByName(param);
        }
    }

    @PatchMapping("/{id}")
    public void updateHospital(@RequestBody UpdateHospitalDto updateHospitalDto,
                                   @PathVariable("id") Long id) {
        hospitalService.updateHospital(id, updateHospitalDto);
    }

    @DeleteMapping("/{id}")
    public void deleteHospital(@PathVariable("id") Long id) {
        hospitalService.deleteHospital(id);
    }
}
