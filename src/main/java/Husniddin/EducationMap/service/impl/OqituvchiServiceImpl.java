package Husniddin.EducationMap.service.impl;

import Husniddin.EducationMap.entity.Oqituvchi;
import Husniddin.EducationMap.repository.OqituvchiRepository;
import Husniddin.EducationMap.service.OqituvchiService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class OqituvchiServiceImpl implements OqituvchiService {
    @Autowired
    private OqituvchiRepository oqituvchiRepository;
    @Override
    public List<Oqituvchi> getAll() throws Exception {
        return oqituvchiRepository.findAll();
    }

    @Override
    public Oqituvchi add(Oqituvchi oqituvchi) throws Exception {
        return oqituvchiRepository.save(oqituvchi);
    }

    @Override
    public void update(Oqituvchi oqituvchi) throws Exception {
        oqituvchiRepository.save(oqituvchi);
    }

    @Override
    public void delete(Oqituvchi oqituvchi) {
        deleteById(oqituvchi.getId());
    }

    @Override
    public void deleteById(Long aLong) {
        oqituvchiRepository.deleteById(aLong);
    }

    @Override
    public Optional<Oqituvchi> getById(Long aLong) throws Exception {
        return oqituvchiRepository.findById(aLong);
    }
}
