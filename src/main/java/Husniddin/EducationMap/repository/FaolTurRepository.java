package Husniddin.EducationMap.repository;

import Husniddin.EducationMap.entity.FaolTur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaolTurRepository extends JpaRepository<FaolTur,Long> {
}
