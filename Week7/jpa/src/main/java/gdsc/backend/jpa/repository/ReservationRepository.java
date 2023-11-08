package gdsc.backend.jpa.repository;

import gdsc.backend.jpa.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("select r from Reservation r " +
            "join fetch r.doctor d " +
            "join fetch r.patient p " +
            "join fetch d.medicalDepartment md " +
            "join fetch md.hospital h")
    List<Reservation> getAllReservationsWithPatientAndDoctor();
}
