package Husniddin.EducationMap.repository;

import Husniddin.EducationMap.entity.Oqituvchi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OqituvchiRepository extends JpaRepository<Oqituvchi,Long> {
}
