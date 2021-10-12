package Husniddin.EducationMap.service.impl;

import Husniddin.EducationMap.entity.Sayt;
import Husniddin.EducationMap.repository.SaytRepository;
import Husniddin.EducationMap.service.SaytService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaytServiceImpl implements SaytService {
    @Autowired
    private SaytRepository saytRepository;
    @Override
    public List<Sayt> getAll() throws Exception {
        return saytRepository.findAll();
    }

    @Override
    public Sayt add(Sayt sayt) throws Exception {
        return saytRepository.save(sayt);
    }

    @Override
    public void update(Sayt sayt) throws Exception {
        saytRepository.save(sayt);
    }

    @Override
    public void delete(Sayt sayt) {
        deleteById(sayt.getId());
    }

    @Override
    public void deleteById(Long aLong) {
        saytRepository.deleteById(aLong);
    }

    @Override
    public Optional<Sayt> getById(Long aLong) throws Exception {
        return saytRepository.findById(aLong);
    }
}
