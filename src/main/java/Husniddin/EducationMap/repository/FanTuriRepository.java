package Husniddin.EducationMap.repository;

import Husniddin.EducationMap.entity.FanTuri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FanTuriRepository extends JpaRepository<FanTuri,Long> {
}
