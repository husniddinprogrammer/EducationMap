package Husniddin.EducationMap.service.impl;

import Husniddin.EducationMap.entity.User;
import Husniddin.EducationMap.repository.UserRepository;
import Husniddin.EducationMap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getAll() throws Exception {
        return userRepository.findAll();
    }

    @Override
    public User add(User user) throws Exception {
        return userRepository.save(user);
    }

    @Override
    public void update(User user) throws Exception {
        userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        deleteById(user.getId());
    }

    @Override
    public void deleteById(Long aLong) {
        userRepository.deleteById(aLong);
    }

    @Override
    public Optional<User> getById(Long aLong) throws Exception {
        return userRepository.findById(aLong);
    }
}
