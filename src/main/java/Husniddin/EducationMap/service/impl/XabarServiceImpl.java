package Husniddin.EducationMap.service.impl;

import Husniddin.EducationMap.entity.Xabar;
import Husniddin.EducationMap.repository.XabarRepository;
import Husniddin.EducationMap.service.XabarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class XabarServiceImpl implements XabarService {
    @Autowired
    private XabarRepository xabarRepository;
    @Override
    public List<Xabar> getAll() throws Exception {
        return xabarRepository.findAll();
    }

    @Override
    public Xabar add(Xabar xabar) throws Exception {
        return xabarRepository.save(xabar);
    }

    @Override
    public void update(Xabar xabar) throws Exception {
        xabarRepository.save(xabar);
    }

    @Override
    public void delete(Xabar xabar) {
        deleteById(xabar.getId());
    }

    @Override
    public void deleteById(Long aLong) {
        xabarRepository.deleteById(aLong);
    }

    @Override
    public Optional<Xabar> getById(Long aLong) throws Exception {
        return xabarRepository.findById(aLong);
    }
}
