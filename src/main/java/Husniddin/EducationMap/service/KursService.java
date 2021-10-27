package Husniddin.EducationMap.service;

import Husniddin.EducationMap.entity.Kurs;

import java.util.List;

public interface KursService extends CommonService<Kurs,Long> {
    public List<Kurs> getAllByStatus();
    public Kurs status(Long id) throws Exception;
    public List<Kurs> getAllFilter(String sana1, String sana2,Long oquvMarkazId,Long oqituvchiId,Long fanId);
    public List<Kurs> getAllByNomiLike(String nomi);
}
