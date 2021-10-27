package Husniddin.EducationMap.service;

import Husniddin.EducationMap.entity.FaolTur;
import Husniddin.EducationMap.entity.HaftaTartibiTur;

import java.util.List;

public interface HaftaTartibiTurService extends CommonService<HaftaTartibiTur,Long> {
    public HaftaTartibiTur status(Long id) throws Exception;
    public List<HaftaTartibiTur> getAllByStatus();
}
