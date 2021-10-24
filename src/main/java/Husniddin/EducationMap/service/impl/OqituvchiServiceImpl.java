package Husniddin.EducationMap.service.impl;

import Husniddin.EducationMap.entity.Oqituvchi;
import Husniddin.EducationMap.entity.OquvMarkaz;
import Husniddin.EducationMap.repository.OqituvchiRepository;
import Husniddin.EducationMap.service.OqituvchiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OqituvchiServiceImpl implements OqituvchiService {
    @Autowired
    private OqituvchiRepository oqituvchiRepository;
    @Override
    public List<Oqituvchi> getAll() throws Exception {
        return oqituvchiRepository.findAllByQoshilganVaqtiBetweenOrderByIdDesc(LocalDate.now().minusDays(5),LocalDate.now().plusDays(1));
    }

    @Override
    public Oqituvchi add(Oqituvchi oqituvchi) throws Exception {
        oqituvchi.setPhoto(null);
        oqituvchi.setOquvchiSoni(0l);
        oqituvchi.setKursSoni(0l);
        oqituvchi.setStatus(true);
        oqituvchi.setQoshilganVaqti(LocalDate.now());
        return oqituvchiRepository.save(oqituvchi);
    }

    @Override
    public void update(Oqituvchi oqituvchi) throws Exception {
        Oqituvchi element = oqituvchiRepository.findById(oqituvchi.getId()).get();
        oqituvchi.setPhoto(element.getPhoto());
        oqituvchi.setOquvchiSoni(element.getOquvchiSoni());
        oqituvchi.setKursSoni(element.getKursSoni());
        oqituvchi.setStatus(element.getStatus());
        oqituvchi.setQoshilganVaqti(element.getQoshilganVaqti());
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

    @Override
    public Oqituvchi status(Long id) throws Exception {
        Oqituvchi result=oqituvchiRepository.findById(id).get();
        if(result.getStatus()==true) {
            result.setStatus(false);
        }
        else {
            result.setStatus(true);
        }
        return oqituvchiRepository.save(result);
    }

    @Override
    public List<Oqituvchi> getAllByIsmLike(String ism) {
        return oqituvchiRepository.findAllByIsmLike(ism);
    }

    @Override
    public List<Oqituvchi> getAllByQoshilganVaqtiBetweenOrderByIdDesc(String sana1, String sana2) {
        return oqituvchiRepository.findAllByQoshilganVaqtiBetweenOrderByIdDesc(LocalDate.parse(sana1).minusDays(1),LocalDate.parse(sana2).plusDays(1));
    }

    @Override
    public List<Oqituvchi> getAllByFan1IdOrFan2IdOrFan3IdOrderByIdDesc(Long fan) {
        return oqituvchiRepository.findAllByFan1IdOrFan2IdOrFan3IdOrderByIdDesc(fan,fan,fan);
    }

    @Override
    public List<Oqituvchi> getAllByQoshilganVaqtiBetweenAndFan1IdOrFan2IdOrFan3IdOrderByIdDesc(String sana1, String sana2, Long fan) {
        LocalDate date1 = LocalDate.parse(sana1);
        LocalDate date2 = LocalDate.parse(sana2);
        return oqituvchiRepository.findAllByQoshilganVaqtiBetweenAndFan1IdOrQoshilganVaqtiBetweenAndFan2IdOrQoshilganVaqtiBetweenAndFan3IdOrderByIdDesc(date1, date2, fan,date1,date2,fan,date1,date2,fan);
    }

    @Override
    public List<Oqituvchi> getAllByStatus() {
        return oqituvchiRepository.findAllByStatus(true);
    }
}









