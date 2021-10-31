package Husniddin.EducationMap.service.impl;

import Husniddin.EducationMap.entity.Fayl;
import Husniddin.EducationMap.repository.FaylRepository;
import Husniddin.EducationMap.security.SecurityUtil;
import Husniddin.EducationMap.service.FaylService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FaylServiceImpl implements FaylService {
    @Autowired
    private FaylRepository faylRepository;
    @Override
    public List<Fayl> getAll() throws Exception {
        return faylRepository.findAll();
    }

    @Override
    public Fayl add(Fayl fayl) throws Exception {
        String username = SecurityUtil.getCurrentUserLogin();
        fayl.setNom("fayl"+username+"dan"+LocalDateTime.now());
        return  faylRepository.save(fayl);
    }

    @Override
    public void update(Fayl fayl) throws Exception {
        faylRepository.save(fayl);
    }

    @Override
    public void delete(Fayl fayl) {
        deleteById(fayl.getId());
    }

    @Override
    public void deleteById(Long aLong) {
        faylRepository.deleteById(aLong);
    }

    @Override
    public Optional<Fayl> getById(Long aLong) throws Exception {
        return faylRepository.findById(aLong);
    }
}








