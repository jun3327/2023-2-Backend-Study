package gdsc.backend.jpa.repository;

import gdsc.backend.jpa.domain.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<repository가 담당하는 table, 엔티티 ID 값 타입>
public interface HospitalRepository extends JpaRepository<Hospital, Long>  {
    Hospital findByName(String name);

}
