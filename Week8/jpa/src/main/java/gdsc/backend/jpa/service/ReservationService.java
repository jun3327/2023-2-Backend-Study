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
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    public void createReservation(CreateReservationDto createReservationDto) {
        Patient patient = patientRepository.findById(createReservationDto.getPatientId()).orElseThrow(RuntimeException::new);
        Doctor doctor = doctorRepository.findById(createReservationDto.getDoctorId()).orElseThrow(RuntimeException::new);
        reservationRepository.save(new Reservation(createReservationDto.getTime(), patient, doctor));

    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.getAllReservationsWithPatientAndDoctor();
    }

    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).orElseThrow(RuntimeException::new);
    }
    @Transactional
    public void updateReservationTime(Long id, LocalDateTime time) {
//        Optional<Reservation> reservation = reservationRepository.findById(id);
//        reservation.ifPresent(r -> r.updateTime(time));
        Reservation reservation = reservationRepository.findById(id).orElseThrow(RuntimeException::new);
        reservation.updateTime(time);
    }

    @Transactional
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
