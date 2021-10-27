package Husniddin.EducationMap.repository;

import Husniddin.EducationMap.entity.FanTuri;
import Husniddin.EducationMap.entity.FaolTur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FaolTurRepository extends JpaRepository<FaolTur,Long> {
    public List<FaolTur> findAllByStatus(Integer status);
}
