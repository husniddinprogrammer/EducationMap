package Husniddin.EducationMap.service.impl;

import Husniddin.EducationMap.entity.FaolTur;
import Husniddin.EducationMap.entity.OquvMarkaz;
import Husniddin.EducationMap.repository.OquvMarkazRepository;
import Husniddin.EducationMap.service.OquvMarkazService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OquvMarkazServiceImpl implements OquvMarkazService {
    @Autowired
    private OquvMarkazRepository oquvMarkazRepository;
    @Override
    public List<OquvMarkaz> getAll() throws Exception {
        return oquvMarkazRepository.findAllByOrderByIdDesc();
    }

    @Override
    public OquvMarkaz add(OquvMarkaz oquvMarkaz) throws Exception {
        oquvMarkaz.setStatus(true);
        oquvMarkaz.setKorilgan(0l);
        oquvMarkaz.setKorilganIchi(0l);
        oquvMarkaz.setOpen(true);
        oquvMarkaz.setOquvchiSoni(0l);
        oquvMarkaz.setOqituvchiSoni(0l);
        oquvMarkaz.setKursSoni(0l);
        oquvMarkaz.setQoshilganVaqti(LocalDate.now());
        return oquvMarkazRepository.save(oquvMarkaz);
    }

    @Override
    public void update(OquvMarkaz oquvMarkaz) throws Exception {
        OquvMarkaz element = oquvMarkazRepository.findById(oquvMarkaz.getId()).get();
        oquvMarkaz.setStatus(element.getStatus());
        oquvMarkaz.setKorilgan(element.getKorilgan());
        oquvMarkaz.setKorilganIchi(element.getKorilganIchi());
        oquvMarkaz.setOpen(element.getOpen());
        oquvMarkaz.setOquvchiSoni(element.getOquvchiSoni());
        oquvMarkaz.setOqituvchiSoni(element.getOqituvchiSoni());
        oquvMarkaz.setKursSoni(element.getKursSoni());
        oquvMarkaz.setQoshilganVaqti(element.getQoshilganVaqti());
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

    @Override
    public OquvMarkaz status(Long id) throws Exception {
        OquvMarkaz result=oquvMarkazRepository.findById(id).get();
        if(result.getStatus()==true) {
            result.setStatus(false);
        }
        else {
            result.setStatus(true);
        }
        return oquvMarkazRepository.save(result);
    }

    @Override
    public List<OquvMarkaz> getAllByNomiLike(String nomi) {
        return oquvMarkazRepository.findAllByNomiLike(nomi);
    }

    @Override
    public List<OquvMarkaz> getAllByWeek() {
        LocalDate date=LocalDate.now();
        return oquvMarkazRepository.findAllByQoshilganVaqtiBetween(date.minusDays(5),date.plusDays(1));
    }

    @Override
    public List<OquvMarkaz> getAllByQoshilganVaqtiBetweenOrderByIdDesc(String sana1,String sana2) {
        return oquvMarkazRepository.findAllByQoshilganVaqtiBetween(LocalDate.parse(sana1),LocalDate.parse(sana2).plusDays(1));
    }

    @Override
    public List<OquvMarkaz> getAllByViloyatOrderByIdDesc(String viloyat) {
        return oquvMarkazRepository.findAllByNomiLike(viloyat);
    }

    @Override
    public List<OquvMarkaz> getAllByQoshilganVaqtiBetweenAndViloyatOrderByIdDesc(String sana1, String sana2, String viloyat) {
        return oquvMarkazRepository.findAllByQoshilganVaqtiBetweenAndViloyatOrderByIdDesc(LocalDate.parse(sana1), LocalDate.parse(sana2),viloyat);
    }
}
