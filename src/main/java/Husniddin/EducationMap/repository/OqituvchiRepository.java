package Husniddin.EducationMap.repository;

import Husniddin.EducationMap.entity.Oqituvchi;
import Husniddin.EducationMap.entity.OquvMarkaz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OqituvchiRepository extends JpaRepository<Oqituvchi,Long> {
    public List<Oqituvchi> findAllByIsmLike(String ism);
    public List<Oqituvchi> findAllByQoshilganVaqtiBetweenOrderByIdDesc(LocalDate sana1, LocalDate sana2);
    public List<Oqituvchi> findAllByFan1IdOrFan2IdOrFan3IdOrderByIdDesc(Long fan1Id, Long fan2Id, Long fan3Id);
    public List<Oqituvchi> findAllByQoshilganVaqtiBetweenAndFan1IdOrQoshilganVaqtiBetweenAndFan2IdOrQoshilganVaqtiBetweenAndFan3IdOrderByIdDesc(LocalDate sana1, LocalDate sana2,Long fan1Id,LocalDate sana3, LocalDate sana4, Long fan2Id,LocalDate sana5, LocalDate sana6, Long fan3Id);
    public List<Oqituvchi> findAllByStatus(Boolean status);
}
