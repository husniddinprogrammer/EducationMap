package Husniddin.EducationMap.service.impl;

import Husniddin.EducationMap.entity.OquvMarkaz;
import Husniddin.EducationMap.repository.OquvMarkazRepository;
import Husniddin.EducationMap.service.OquvMarkazService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class OquvMarkazServiceImpl implements OquvMarkazService {
    @Autowired
    private OquvMarkazRepository oquvMarkazRepository;
    @Override
    public List<OquvMarkaz> getAll() throws Exception {
        return oquvMarkazRepository.findAll();
    }

    @Override
    public OquvMarkaz add(OquvMarkaz oquvMarkaz) throws Exception {
        return oquvMarkazRepository.save(oquvMarkaz);
    }

    @Override
    public void update(OquvMarkaz oquvMarkaz) throws Exception {
        oquvMarkazRepository.save(oquvMarkaz);
    }

    @Override
    public void delete(OquvMarkaz oquvMarkaz) {
        deleteById(oquvMarkaz.getId());
    }

    @Override
    public void deleteById(Long aLong) {
        oquvMarkazRepository.deleteById(aLong);
    }

    @Override
    public Optional<OquvMarkaz> getById(Long aLong) throws Exception {
        return oquvMarkazRepository.findById(aLong);
    }
}
