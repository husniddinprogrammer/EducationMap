package Husniddin.EducationMap.service.impl;

import Husniddin.EducationMap.entity.Lavozim;
import Husniddin.EducationMap.entity.User;
import Husniddin.EducationMap.repository.UserRepository;
import Husniddin.EducationMap.security.SecurityUtil;
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
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
    public List<User> getAll() {
        String username = SecurityUtil.getCurrentUserLogin();
        UserDTO user1=userRepository.findByUsername(username).map(UserDTO::new).orElse(null);
        return userRepository.findByIdNotOrderByIdDesc(user1.getId());
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
    public User create(User  data) throws Exception {
        UserDTO currentUser = getCurrentUser();
        User user = new User();
        user.setId(data.getId());
        user.setUsername(data.getUsername());
        user.setName(data.getName());
        user.setNumber(data.getNumber());
        user.setQushilganVaqti(LocalDateTime.now());
        user.setStatus(true);
        Set<Lavozim> lavozimlar = new HashSet<>();
        lavozimlar.add(Lavozim.ADMIN);
        user.setLavozimlar(lavozimlar);
        user.setPassword(passwordEncoder.encode(data.getPassword()));
        return userRepository.save(user);

    }

    @Override
    public UserDTO update(UserVM data) throws Exception {
            User user = userRepository.findById(data.getId()).get();
            user.setUsername(data.getUsername());
            user.setName(data.getName());
            user.setNumber(data.getNumber());
            user.setPassword(passwordEncoder.encode(data.getPassword()));
            return new UserDTO(userRepository.save(user));
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
        User user = new User();
        user.setId(data.getId());
        user.setUsername(data.getUsername());
        user.setName(data.getName());
        user.setNumber(data.getNumber());
        user.setQushilganVaqti(LocalDateTime.now());
        user.setStatus(true);
        Set<Lavozim> lavozimlar = new HashSet<>();
        lavozimlar.add(Lavozim.ADMIN);
        user.setLavozimlar(lavozimlar);
        user.setPassword(passwordEncoder.encode(data.getPassword()));
        return new UserDTO(userRepository.save(user));
    }

    @Override
    public UserDTO status(Long id) throws Exception {
        User user=userRepository.findById(id).get();
        if(user.getStatus()==true){
            user.setStatus(false);
        }
        else {
            user.setStatus(true);
        }
        return new UserDTO(userRepository.save(user));
    }

    @Override
    public List<User> getToday() {
        LocalDate date=LocalDate.now();
        LocalDateTime kun1=date.atTime(0,0,0,0);
        return userRepository.findAllByQushilganVaqtiBetweenOrderByIdDesc(kun1,kun1.plusDays(1));
    }

    @Override
    public List<User> getSana(String sana) {
        LocalDate date=LocalDate.parse(sana);
        LocalDateTime kun1=date.atTime(0,0,0,0);
        return userRepository.findAllByQushilganVaqtiBetweenOrderByIdDesc(kun1,kun1.plusDays(1));
    }

    @Override
    public List<User> getAllByUsernameLike(String username) {
        return userRepository.findAllByUsernameLike(username);
    }

}










