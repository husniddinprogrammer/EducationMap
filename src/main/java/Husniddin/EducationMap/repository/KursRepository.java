package Husniddin.EducationMap.repository;

import Husniddin.EducationMap.entity.FanTuri;
import Husniddin.EducationMap.entity.Kurs;
import Husniddin.EducationMap.entity.OquvMarkaz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface KursRepository extends JpaRepository<Kurs,Long> {
    public List<Kurs> findAllByStatus(Boolean status);
    public List<Kurs> findAllByBoshlanishVaqtiBetweenOrderByIdDesc(LocalDate sana1, LocalDate sana2);
    public List<Kurs> findAllByBoshlanishVaqtiBetweenAndOquvMarkazIdOrderByIdDesc(LocalDate sana1, LocalDate sana2,Long id);
    public List<Kurs> findAllByBoshlanishVaqtiBetweenAndFanIdOrderByIdDesc(LocalDate sana1, LocalDate sana2,Long fanId);
    public List<Kurs> findAllByBoshlanishVaqtiBetweenAndOqituvchiIdOrderByIdDesc(LocalDate sana1, LocalDate sana2,Long oqituvchiId);
    public List<Kurs> findAllByBoshlanishVaqtiBetweenAndOquvMarkazIdAndOqituvchiIdOrderByIdDesc(LocalDate sana1, LocalDate sana2,Long oquvMarkazId,Long oqituvchiId);
    public List<Kurs> findAllByBoshlanishVaqtiBetweenAndOquvMarkazIdAndFanIdOrderByIdDesc(LocalDate sana1, LocalDate sana2,Long oquvMarkazId,Long fanId);
    public List<Kurs> findAllByBoshlanishVaqtiBetweenAndFanIdAndOqituvchiIdOrderByIdDesc(LocalDate sana1, LocalDate sana2,Long fanId,Long oqituvchiId);
    public List<Kurs> findAllByBoshlanishVaqtiBetweenAndOquvMarkazIdAndOqituvchiIdAndFanIdOrderByIdDesc(LocalDate sana1, LocalDate sana2,Long oquvMarkazId,Long oqituvchiId,Long fanId);
    public List<Kurs> findAllByNomiLike(String nomi);
}
