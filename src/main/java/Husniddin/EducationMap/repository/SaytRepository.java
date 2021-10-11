package Husniddin.EducationMap.repository;

import Husniddin.EducationMap.entity.Sayt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaytRepository extends JpaRepository<Sayt,Long> {
}
