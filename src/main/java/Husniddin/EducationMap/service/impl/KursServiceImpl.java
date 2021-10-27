package Husniddin.EducationMap.service.impl;

import Husniddin.EducationMap.entity.Kurs;
import Husniddin.EducationMap.repository.KursRepository;
import Husniddin.EducationMap.service.KursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
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
        kurs.setBoshlanishVaqti(LocalDate.now());
        kurs.setKorilgan(0);
        kurs.setKorilganIchi(0);
        kurs.setStatus(true);
        return kursRepository.save(kurs);
    }

    @Override
    public void update(Kurs kurs) throws Exception {
        Kurs element = kursRepository.findById(kurs.getId()).get();
        kurs.setBoshlanishVaqti(element.getBoshlanishVaqti());
        kurs.setKorilgan(element.getKorilgan());
        kurs.setKorilganIchi(element.getKorilganIchi());
        kurs.setStatus(element.getStatus());
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

    @Override
    public List<Kurs> getAllByStatus() {
        return kursRepository.findAllByStatus(true);
    }

    @Override
    public Kurs status(Long id) throws Exception {
        Kurs element = kursRepository.findById(id).get();
        if(element.getStatus() == true){
            element.setStatus(false);
        }
        else{
            element.setStatus(true);
        }
        return kursRepository.save(element);
    }

    @Override
    public List<Kurs> getAllFilter(String sana1, String sana2, Long oquvMarkazId, Long oqituvchiId, Long fanId) {
        List<Kurs> result=null;
        LocalDate date1=LocalDate.parse(sana1);
        LocalDate date2=LocalDate.parse(sana2);
        if(oquvMarkazId != 0 || oqituvchiId != 0 || fanId != 0){
            if(oquvMarkazId != 0 && oqituvchiId != 0 && fanId != 0){
                result=kursRepository.findAllByBoshlanishVaqtiBetweenAndOquvMarkazIdAndOqituvchiIdAndFanIdOrderByIdDesc(date1,date2,oquvMarkazId,oqituvchiId,fanId);
            }
            else {
                if(oquvMarkazId==0){
                    if(fanId != 0 && oqituvchiId != 0){
                        result=kursRepository.findAllByBoshlanishVaqtiBetweenAndFanIdAndOqituvchiIdOrderByIdDesc(date1,date2,fanId,oqituvchiId);
                    }
                    else{
                        if(fanId!=0){
                            result=kursRepository.findAllByBoshlanishVaqtiBetweenAndFanIdOrderByIdDesc(date1,date2,fanId);
                        }
                        else{
                            result=kursRepository.findAllByBoshlanishVaqtiBetweenAndOqituvchiIdOrderByIdDesc(date1,date2,oqituvchiId);
                        }
                    }
                }
                else{
                    if(fanId!=0 || oqituvchiId!=0){
                        if(fanId!=0){
                            result=kursRepository.findAllByBoshlanishVaqtiBetweenAndOquvMarkazIdAndFanIdOrderByIdDesc(date1,date2,oquvMarkazId,fanId);
                        }
                        if(oqituvchiId!=0){
                            result=kursRepository.findAllByBoshlanishVaqtiBetweenAndOquvMarkazIdAndOqituvchiIdOrderByIdDesc(date1,date2,oquvMarkazId,oqituvchiId);
                        }
                    }
                    else{
                        result=kursRepository.findAllByBoshlanishVaqtiBetweenAndOquvMarkazIdOrderByIdDesc(date1,date2,oquvMarkazId);
                    }
                }
            }
        }
        else{
            result=kursRepository.findAllByBoshlanishVaqtiBetweenOrderByIdDesc(date1,date2);
        }
        return result;
    }

    @Override
    public List<Kurs> getAllByNomiLike(String nomi) {
        return kursRepository.findAllByNomiLike(nomi);
    }

}













