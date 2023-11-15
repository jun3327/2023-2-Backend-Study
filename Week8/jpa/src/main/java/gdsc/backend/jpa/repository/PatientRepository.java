package gdsc.backend.jpa.repository;

import gdsc.backend.jpa.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
