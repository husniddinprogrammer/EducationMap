package Husniddin.EducationMap.service.impl;

import Husniddin.EducationMap.entity.ReklamaTuri;
import Husniddin.EducationMap.repository.ReklamaTuriRepository;
import Husniddin.EducationMap.service.ReklamaTuriService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ReklamaTuriServiceImpl implements ReklamaTuriService {
    @Autowired
    private ReklamaTuriRepository reklamaTuriRepository;
    @Override
    public List<ReklamaTuri> getAll() throws Exception {
        return reklamaTuriRepository.findAll();
    }

    @Override
    public ReklamaTuri add(ReklamaTuri reklamaTuri) throws Exception {
        return reklamaTuriRepository.save(reklamaTuri);
    }

    @Override
    public void update(ReklamaTuri reklamaTuri) throws Exception {
        reklamaTuriRepository.save(reklamaTuri);
    }

    @Override
    public void delete(ReklamaTuri reklamaTuri) {
        deleteById(reklamaTuri.getId());
    }

    @Override
    public void deleteById(Long aLong) {
        reklamaTuriRepository.deleteById(aLong);
    }

    @Override
    public Optional<ReklamaTuri> getById(Long aLong) throws Exception {
        return reklamaTuriRepository.findById(aLong);
    }
}