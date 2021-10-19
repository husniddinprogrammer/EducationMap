package Husniddin.EducationMap.service;

import Husniddin.EducationMap.entity.FanTuri;
import Husniddin.EducationMap.entity.ReklamaTuri;

public interface ReklamaTuriService extends CommonService<ReklamaTuri,Long> {
    public ReklamaTuri status(Long id) throws Exception;
}
