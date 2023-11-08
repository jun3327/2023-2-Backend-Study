package gdsc.backend.jpa.repository;

import gdsc.backend.jpa.domain.MedicalDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MedicalDepartmentRepository extends JpaRepository<MedicalDepartment, Long> {
    @Query("select md from MedicalDepartment md " +
            "join fetch md.hospital h")
    List<MedicalDepartment> findAllWithHospital();
}
