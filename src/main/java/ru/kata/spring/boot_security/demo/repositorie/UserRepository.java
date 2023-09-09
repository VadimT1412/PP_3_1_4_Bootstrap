package ru.kata.spring.boot_security.demo.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("Select u from User u join fetch u.roles where u.username=:username")
    Optional<User> findByUsername(String username);

    @Override
    Optional<User> findById(Long id);
}
