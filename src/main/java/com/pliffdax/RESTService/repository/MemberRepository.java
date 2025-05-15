package com.pliffdax.RESTService.repository;

import com.pliffdax.RESTService.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    boolean existsByUserIdAndRoleName(Integer userId, String roleName);
    Optional<Member> findByUserIdAndRoleName(Integer userId, String roleName);
    @Query("SELECT m.role.name FROM Member m WHERE m.user.id = :userId")
    List<String> findRoleNamesByUserId(@Param("userId") Integer userId);
}
