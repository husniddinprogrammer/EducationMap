package Husniddin.EducationMap.service;

import Husniddin.EducationMap.entity.FanTuri;
import Husniddin.EducationMap.entity.FaylTur;
import Husniddin.EducationMap.entity.User;
import Husniddin.EducationMap.service.dto.UserDTO;

import java.util.List;

public interface FanTuriService  extends CommonService<FanTuri,Long> {
    public FanTuri status(Long id) throws Exception;
    public List<FanTuri> findAllByStatus();
}
