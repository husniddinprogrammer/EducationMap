package Husniddin.EducationMap.service;

import Husniddin.EducationMap.entity.FanTuri;
import Husniddin.EducationMap.entity.FaolTur;

import java.util.List;

public interface FaolTurService extends CommonService<FaolTur,Long> {
    public FaolTur status(Long id) throws Exception;
    public List<FaolTur> getAllByStatus();
}
