package Husniddin.EducationMap.repository;

import Husniddin.EducationMap.entity.ReklamaTuri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReklamaTuriRepository extends JpaRepository<ReklamaTuri,Long> {
}
