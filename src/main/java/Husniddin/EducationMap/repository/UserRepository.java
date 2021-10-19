package Husniddin.EducationMap.repository;

import Husniddin.EducationMap.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
    public List<User> findByIdNotOrderByIdDesc(Long id);
    public List<User> findAllByQushilganVaqtiBetweenOrderByIdDesc(LocalDateTime sana1, LocalDateTime sana2);
    public List<User> findAllByUsernameLike(String username);
}
