package Husniddin.EducationMap.service;

import Husniddin.EducationMap.entity.Oqituvchi;
import Husniddin.EducationMap.entity.OquvMarkaz;

import java.time.LocalDate;
import java.util.List;

public interface OqituvchiService extends CommonService<Oqituvchi,Long> {
    public Oqituvchi status(Long id) throws Exception;
    public List<Oqituvchi> getAllByIsmLike(String ism);
    public List<Oqituvchi> getAllByQoshilganVaqtiBetweenOrderByIdDesc(String sana1, String sana2);
    public List<Oqituvchi> getAllByFan1IdOrFan2IdOrFan3IdOrderByIdDesc(Long fan);
    public List<Oqituvchi> getAllByQoshilganVaqtiBetweenAndFan1IdOrFan2IdOrFan3IdOrderByIdDesc(String sana1, String sana2,Long fan);
    public List<Oqituvchi> getAllByStatus();

}
