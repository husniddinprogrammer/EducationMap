package Husniddin.EducationMap.service;

import Husniddin.EducationMap.entity.FanTuri;
import Husniddin.EducationMap.entity.FaylTur;
import Husniddin.EducationMap.entity.User;
import Husniddin.EducationMap.service.dto.UserDTO;

public interface FanTuriService  extends CommonService<FanTuri,Long> {
    public FanTuri status(Long id) throws Exception;
}
