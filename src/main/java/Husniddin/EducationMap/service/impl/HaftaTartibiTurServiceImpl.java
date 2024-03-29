package Husniddin.EducationMap.service.impl;

import Husniddin.EducationMap.entity.HaftaTartibiTur;
import Husniddin.EducationMap.entity.ReklamaTuri;
import Husniddin.EducationMap.repository.HaftaTartibiTurRepository;
import Husniddin.EducationMap.service.HaftaTartibiTurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HaftaTartibiTurServiceImpl implements HaftaTartibiTurService {
    @Autowired
    private HaftaTartibiTurRepository haftaTartibiTurRepository;
    @Override
    public List<HaftaTartibiTur> getAll() throws Exception {
        return haftaTartibiTurRepository.findAll();
    }

    @Override
    public HaftaTartibiTur add(HaftaTartibiTur haftaTartibiTur) throws Exception {
        haftaTartibiTur.setStatus(1);
        return haftaTartibiTurRepository.save(haftaTartibiTur);
    }

    @Override
    public void update(HaftaTartibiTur haftaTartibiTur) throws Exception {
        HaftaTartibiTur element=haftaTartibiTurRepository.findById(haftaTartibiTur.getId()).get();
        haftaTartibiTur.setStatus(element.getStatus());
        haftaTartibiTurRepository.save(haftaTartibiTur);
    }

    @Override
    public void delete(HaftaTartibiTur haftaTartibiTur) {
        deleteById(haftaTartibiTur.getId());
    }

    @Override
    public void deleteById(Long aLong) {
        haftaTartibiTurRepository.deleteById(aLong);
    }

    @Override
    public Optional<HaftaTartibiTur> getById(Long aLong) throws Exception {
        return haftaTartibiTurRepository.findById(aLong);
    }

    @Override
    public HaftaTartibiTur status(Long id) throws Exception {
        HaftaTartibiTur result=haftaTartibiTurRepository.findById(id).get();
        if(result.getStatus()==1){
            result.setStatus(0);
        }
        else {
            result.setStatus(1);
        }
        return haftaTartibiTurRepository.save(result);
    }

    @Override
    public List<HaftaTartibiTur> getAllByStatus() {
        return haftaTartibiTurRepository.findAllByStatus(1);
    }
}
