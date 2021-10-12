package Husniddin.EducationMap.service.impl;

import Husniddin.EducationMap.entity.User;
import Husniddin.EducationMap.repository.UserRepository;
import Husniddin.EducationMap.service.UserService;
import Husniddin.EducationMap.service.dto.UserDTO;
import Husniddin.EducationMap.service.vm.UserVM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class.getName());
    @Override
    public Page<UserDTO> getAll(Pageable pageable) {
        Page<User> userlar =  userRepository.findAll(pageable);
        return  userlar.map(UserDTO::new);
    }

    @Override
    public UserDTO getById(Long id) throws Exception {
        Optional<User> user =  userRepository.findById(id);

        if(user.isPresent()){
            User u =  user.get();

            UserDTO userDTO = new UserDTO(u);

            return userDTO;
        }
        throw new Exception("User topilmadi");
    }

    @Override
    public UserDTO create(UserVM data) throws Exception {
        UserDTO currentUser = getCurrentUser();
        User user = new User();
        user.setId(data.getId());
        user.setUsername(data.getUsername());
        user.setName(data.getName());
        user.setNumber(data.getNumber());
        user.setQushilganVaqti(LocalDateTime.now());
        user.setStatus(true);
        user.setLavozimlar(data.getLavozimlar());
        user.setPassword(passwordEncoder.encode(data.getPassword()));
        logger.info("user keldi");
        return new UserDTO(userRepository.save(user));

    }

    @Override
    public UserDTO update(UserVM data) throws Exception {
        if (data.getId() != null){
            UserDTO currentUser = getCurrentUser();

            User user = userRepository.findById(data.getId()).get();
            user.setName(data.getName());
            user.setNumber(data.getNumber());
            user.setQushilganVaqti(user.getQushilganVaqti());
            user.setStatus(user.getStatus());
            user.setLavozimlar(user.getLavozimlar());

            user.setPassword(passwordEncoder.encode(data.getPassword()));
            logger.info("user keldi");

            return new UserDTO(userRepository.save(user));
        }else{
            throw new Exception("id null bo'lishi kerak");
        }
    }


    @Override
    public void delete(UserVM data) {
        deleteById(data.getId());
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO getByLogin(String username) {
        return userRepository.findByUsername(username).map(UserDTO::new).orElse(null);
    }

    @Override
    public Page<UserDTO> getByAktiv(Boolean aktiv, Pageable pageable) throws Exception {
        return null;
    }

    @Override
    public List<User> getAllList() {
        return null;
    }

    @Override
    public UserDTO getCurrentUser() {
        String username = getPrincipal();
        if (username != null)
            return userRepository.findByUsername(username).map(UserDTO::new).orElse(null);
        return null;
    }
    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

    @Override
    public UserDTO register(UserVM data) throws Exception {
        return null;
    }

    @Override
    public UserDTO updateAccount(UserVM userVM) throws Exception {
        return null;
    }
}
