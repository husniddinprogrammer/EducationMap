package Husniddin.EducationMap.service;

import Husniddin.EducationMap.entity.FanTuri;
import Husniddin.EducationMap.entity.FaolTur;

public interface FaolTurService extends CommonService<FaolTur,Long> {
    public FaolTur status(Long id) throws Exception;
}
