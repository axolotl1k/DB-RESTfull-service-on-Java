package com.pliffdax.RESTService.repository;

import com.pliffdax.RESTService.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    boolean existsByUserIdAndRoleName(Integer userId, String roleName);
    Optional<Member> findByUserIdAndRoleName(Integer userId, String roleName);
}
