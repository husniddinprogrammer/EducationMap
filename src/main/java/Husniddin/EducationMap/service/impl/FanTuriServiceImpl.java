package Husniddin.EducationMap.service.impl;

import Husniddin.EducationMap.entity.FanTuri;
import Husniddin.EducationMap.entity.User;
import Husniddin.EducationMap.repository.FanTuriRepository;
import Husniddin.EducationMap.service.FanTuriService;
import Husniddin.EducationMap.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FanTuriServiceImpl implements FanTuriService {
    @Autowired
    private FanTuriRepository fanTuriRepository;
    @Override
    public List<FanTuri> getAll() throws Exception {
        return fanTuriRepository.findAllByOrderById();
    }

    @Override
    public FanTuri add(FanTuri fanTuri) throws Exception {
        fanTuri.setStatus(1);
        return fanTuriRepository.save(fanTuri);
    }

    @Override
    public void update(FanTuri fanTuri) throws Exception {
        FanTuri element = fanTuriRepository.findById(fanTuri.getId()).get();
        fanTuri.setStatus(element.getStatus());
        fanTuriRepository.save(fanTuri);
    }

    @Override
    public void delete(FanTuri fanTuri) {
        deleteById(fanTuri.getId());
    }

    @Override
    public void deleteById(Long aLong) {
        fanTuriRepository.deleteById(aLong);
    }

    @Override
    public Optional<FanTuri> getById(Long aLong) throws Exception {
        return fanTuriRepository.findById(aLong);
    }

    @Override
    public FanTuri status(Long id) throws Exception {
        FanTuri result=fanTuriRepository.findById(id).get();
        if(result.getStatus()==1){
            result.setStatus(0);
        }
        else {
            result.setStatus(1);
        }
        return fanTuriRepository.save(result);
    }

    @Override
    public List<FanTuri> findAllByStatus() {
        return fanTuriRepository.findAllByStatus(1);
    }
}
