package Husniddin.EducationMap.repository;

import Husniddin.EducationMap.entity.Xabar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XabarRepository extends JpaRepository<Xabar,Long> {
}
