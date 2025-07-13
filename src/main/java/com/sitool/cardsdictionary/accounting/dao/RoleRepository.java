package com.sitool.cardsdictionary.accounting.dao;

import com.sitool.cardsdictionary.accounting.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(String roleName);
}
