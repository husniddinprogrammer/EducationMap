package Husniddin.EducationMap.service.impl;

import Husniddin.EducationMap.entity.Reklama;
import Husniddin.EducationMap.repository.ReklamaRepository;
import Husniddin.EducationMap.service.ReklamaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ReklamaServiceImpl implements ReklamaService {
    @Autowired
    private ReklamaRepository reklamaRepository;
    @Override
    public List<Reklama> getAll() throws Exception {
        return reklamaRepository.findAll();
    }

    @Override
    public Reklama add(Reklama reklama) throws Exception {
        return reklamaRepository.save(reklama);
    }

    @Override
    public void update(Reklama reklama) throws Exception {
        reklamaRepository.save(reklama);
    }

    @Override
    public void delete(Reklama reklama) {
        deleteById(reklama.getId());
    }

    @Override
    public void deleteById(Long aLong) {
        reklamaRepository.deleteById(aLong);
    }

    @Override
    public Optional<Reklama> getById(Long aLong) throws Exception {
        return reklamaRepository.findById(aLong);
    }
}
