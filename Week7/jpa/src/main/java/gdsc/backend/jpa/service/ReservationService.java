package gdsc.backend.jpa.service;

import gdsc.backend.jpa.domain.Doctor;
import gdsc.backend.jpa.domain.Patient;
import gdsc.backend.jpa.domain.Reservation;
import gdsc.backend.jpa.dto.CreateReservationDto;
import gdsc.backend.jpa.repository.DoctorRepository;
import gdsc.backend.jpa.repository.PatientRepository;
import gdsc.backend.jpa.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    public void createReservation(CreateReservationDto createReservationDto) {
        Patient patient = patientRepository.findById(createReservationDto.getPatientId()).orElseThrow(RuntimeException::new);
        Doctor doctor = doctorRepository.findById(createReservationDto.getDoctorId()).orElseThrow(RuntimeException::new);
        reservationRepository.save(new Reservation(LocalDateTime.now(), patient, doctor));

    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.getAllReservationsWithPatientAndDoctor();
    }
}
