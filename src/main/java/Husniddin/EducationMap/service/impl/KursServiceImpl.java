package Husniddin.EducationMap.service.impl;

import Husniddin.EducationMap.entity.Kurs;
import Husniddin.EducationMap.repository.KursRepository;
import Husniddin.EducationMap.service.KursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KursServiceImpl implements KursService {
    @Autowired
    private KursRepository kursRepository;
    @Override
    public List<Kurs> getAll() throws Exception {
        return kursRepository.findAll();
    }

    @Override
    public Kurs add(Kurs kurs) throws Exception {
        return kursRepository.save(kurs);
    }

    @Override
    public void update(Kurs kurs) throws Exception {
        kursRepository.save(kurs);
    }

    @Override
    public void delete(Kurs kurs) {
        deleteById(kurs.getId());
    }

    @Override
    public void deleteById(Long aLong) {
        kursRepository.deleteById(aLong);
    }

    @Override
    public Optional<Kurs> getById(Long aLong) throws Exception {
        return kursRepository.findById(aLong);
    }
}
