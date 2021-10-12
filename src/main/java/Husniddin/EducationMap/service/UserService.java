package Husniddin.EducationMap.service;

import Husniddin.EducationMap.entity.User;
import Husniddin.EducationMap.service.dto.UserDTO;
import Husniddin.EducationMap.service.vm.UserVM;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService{
    public Page<UserDTO> getAll(Pageable pageable);
    public UserDTO getById(Long id) throws Exception;
    public UserDTO create(UserVM data) throws Exception;
    public UserDTO update(UserVM data) throws Exception;
    public void delete(UserVM data);
    public void deleteById(Long id);
    UserDTO getByLogin(String username);
    Page<UserDTO> getByAktiv(Boolean aktiv, Pageable pageable) throws Exception;
    public List<User> getAllList();
    UserDTO getCurrentUser();
    public UserDTO register(UserVM data) throws Exception;

    UserDTO updateAccount(UserVM userVM) throws Exception;}
