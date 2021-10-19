package Husniddin.EducationMap.repository;

import Husniddin.EducationMap.entity.FanTuri;
import Husniddin.EducationMap.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FanTuriRepository extends JpaRepository<FanTuri,Long> {
    public List<FanTuri> findAllByOrderById();
}
