package com.github.xuqplus.springsessiondemobase.repository;

import com.github.xuqplus.springsessiondemobase.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

  boolean existsByName(String name);

  Role getByName(String name);
}
