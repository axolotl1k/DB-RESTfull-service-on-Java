package com.pliffdax.RESTService.repository;

import com.pliffdax.RESTService.entity.Ban;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface BanRepository extends CrudRepository<Ban, Integer> {
    boolean existsByUserIdAndUntilDateAfter(Integer userId, LocalDateTime now);

    Optional<Ban> findByUserIdAndUntilDateAfter(Integer userId, LocalDateTime now);
}
