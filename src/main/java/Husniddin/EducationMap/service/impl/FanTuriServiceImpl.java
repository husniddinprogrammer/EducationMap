package Husniddin.EducationMap.service.impl;

import Husniddin.EducationMap.entity.FanTuri;
import Husniddin.EducationMap.repository.FanTuriRepository;
import Husniddin.EducationMap.service.FanTuriService;
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
        return fanTuriRepository.findAll();
    }

    @Override
    public FanTuri add(FanTuri fanTuri) throws Exception {
        return fanTuriRepository.save(fanTuri);
    }

    @Override
    public void update(FanTuri fanTuri) throws Exception {
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
}
