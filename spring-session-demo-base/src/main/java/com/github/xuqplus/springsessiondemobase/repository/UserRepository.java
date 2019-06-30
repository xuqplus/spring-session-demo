package com.github.xuqplus.springsessiondemobase.repository;

import com.github.xuqplus.springsessiondemobase.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

  User findUserByUsername(String username);

  boolean existsByUsername(String username);
}
