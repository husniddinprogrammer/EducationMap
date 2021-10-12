package Husniddin.EducationMap;

import Husniddin.EducationMap.entity.Lavozim;
import Husniddin.EducationMap.entity.User;
import Husniddin.EducationMap.repository.UserRepository;
import Husniddin.EducationMap.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@SpringBootApplication
public class EducationMapApplication implements ApplicationRunner {
	@Autowired
	JwtUtil jwtUtil;

	@Value("${system.admin.login}")
	private String login;

	@Value("${system.admin.parol}")
	private String parol;

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(EducationMapApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Optional<User> creator = userRepository.findByUsername(login);
		if(!creator.isPresent()) {
			User user = new User();
			user.setId(1l);
			user.setUsername(login);
			user.setName("Husniddin");
			user.setNumber("998915604085");
			user.setQushilganVaqti(LocalDateTime.now());
			user.setStatus(true);
			Set<Lavozim> lavozimlar = new HashSet<>();
			lavozimlar.add(Lavozim.CREATOR);
			lavozimlar.add(Lavozim.BOSS);
			lavozimlar.add(Lavozim.ADMIN);
			lavozimlar.add(Lavozim.PEOPLE);
			user.setLavozimlar(lavozimlar);
			user.setPassword(passwordEncoder.encode(parol));
			userRepository.save(user);
		}
	}
}




















