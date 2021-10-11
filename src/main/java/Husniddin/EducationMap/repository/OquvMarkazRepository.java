package Husniddin.EducationMap.repository;

import Husniddin.EducationMap.entity.OquvMarkaz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OquvMarkazRepository extends JpaRepository<OquvMarkaz,Long> {
}
