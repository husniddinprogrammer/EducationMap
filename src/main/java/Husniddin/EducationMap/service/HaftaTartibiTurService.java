package Husniddin.EducationMap.service;

import Husniddin.EducationMap.entity.FaolTur;
import Husniddin.EducationMap.entity.HaftaTartibiTur;

public interface HaftaTartibiTurService extends CommonService<HaftaTartibiTur,Long> {
    public HaftaTartibiTur status(Long id) throws Exception;
}
