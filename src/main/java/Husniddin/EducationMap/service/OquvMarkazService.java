package Husniddin.EducationMap.service;

import Husniddin.EducationMap.entity.FanTuri;
import Husniddin.EducationMap.entity.OquvMarkaz;

import java.time.LocalDateTime;
import java.util.List;

public interface OquvMarkazService extends CommonService<OquvMarkaz,Long> {
    public OquvMarkaz status(Long id) throws Exception;
    public List<OquvMarkaz> getAllByNomiLike(String nomi);
    public List<OquvMarkaz> getAllByWeek();
    public List<OquvMarkaz> getAllByQoshilganVaqtiBetweenOrderByIdDesc(String sana1, String sana2);
    public List<OquvMarkaz> getAllByViloyatOrderByIdDesc(String viloyat);
    public List<OquvMarkaz> getAllByQoshilganVaqtiBetweenAndViloyatOrderByIdDesc(String sana1, String sana2,String viloyat);
    public List<OquvMarkaz> getAllByStatus();
}
