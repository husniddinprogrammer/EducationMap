package Husniddin.EducationMap.repository;

import Husniddin.EducationMap.entity.OquvMarkaz;
import Husniddin.EducationMap.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OquvMarkazRepository extends JpaRepository<OquvMarkaz,Long> {
    public List<OquvMarkaz> findAllByOrderByIdDesc();
    public List<OquvMarkaz> findAllByNomiLike(String nomi);
    public List<OquvMarkaz> findAllByQoshilganVaqtiBetween(LocalDate sana1, LocalDate sana2);
    public List<OquvMarkaz> findAllByViloyatOrderByIdDesc(String viloyat);
    public List<OquvMarkaz> findAllByQoshilganVaqtiBetweenAndViloyatOrderByIdDesc(LocalDate sana1, LocalDate sana2, String viloyat);

}
