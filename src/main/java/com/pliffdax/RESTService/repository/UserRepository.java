package com.pliffdax.RESTService.repository;

import com.pliffdax.RESTService.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByName(String username);
    Optional<User> findByName(String username);
}
