package Husniddin.EducationMap.service;

import Husniddin.EducationMap.entity.User;
import Husniddin.EducationMap.service.dto.UserDTO;
import Husniddin.EducationMap.service.vm.UserVM;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService{
    public Page<UserDTO> getAll(Pageable pageable);
    public List<User> getAll();
    public UserDTO getById(Long id) throws Exception;
    public User create(User data) throws Exception;
    public UserDTO update(UserVM data) throws Exception;
    public void delete(UserVM data);
    public void deleteById(Long id);
    UserDTO getCurrentUser();
    public UserDTO register(UserVM data) throws Exception;
    public UserDTO status(Long id) throws Exception;
    public List<User> getToday();
    public List<User> getSana(String sana);
    public List<User> getAllByUsernameLike(String username);
}
