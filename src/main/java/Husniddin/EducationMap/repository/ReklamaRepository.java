package Husniddin.EducationMap.repository;

import Husniddin.EducationMap.entity.Reklama;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReklamaRepository extends JpaRepository<Reklama,Long> {
}
