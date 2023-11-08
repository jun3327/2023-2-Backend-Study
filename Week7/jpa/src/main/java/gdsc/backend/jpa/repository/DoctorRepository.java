package gdsc.backend.jpa.repository;

import gdsc.backend.jpa.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    @Query("select d from Doctor d " +
            "join fetch d.medicalDepartment md " +
            "join fetch md.hospital h")
    List<Doctor> findAllWithMedicalDepartment();
}
