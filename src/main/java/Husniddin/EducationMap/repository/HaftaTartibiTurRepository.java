package Husniddin.EducationMap.repository;

import Husniddin.EducationMap.entity.FanTuri;
import Husniddin.EducationMap.entity.HaftaTartibiTur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HaftaTartibiTurRepository extends JpaRepository<HaftaTartibiTur,Long> {
    public List<HaftaTartibiTur> findAllByStatus(Integer status);
}
