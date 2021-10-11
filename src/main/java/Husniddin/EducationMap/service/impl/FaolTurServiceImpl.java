package Husniddin.EducationMap.service.impl;

import Husniddin.EducationMap.entity.FaolTur;
import Husniddin.EducationMap.repository.FaolTurRepository;
import Husniddin.EducationMap.service.FaolTurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FaolTurServiceImpl implements FaolTurService {
    @Autowired
    private FaolTurRepository faolTurRepository;
    @Override
    public List<FaolTur> getAll() throws Exception {
        return faolTurRepository.findAll();
    }

    @Override
    public FaolTur add(FaolTur faolTur) throws Exception {
        return faolTurRepository.save(faolTur);
    }

    @Override
    public void update(FaolTur faolTur) throws Exception {
        faolTurRepository.save(faolTur);
    }

    @Override
    public void delete(FaolTur faolTur) {
        deleteById(faolTur.getId());
    }

    @Override
    public void deleteById(Long aLong) {
        faolTurRepository.deleteById(aLong);
    }

    @Override
    public Optional<FaolTur> getById(Long aLong) throws Exception {
        return faolTurRepository.findById(aLong);
    }
}
