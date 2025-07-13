package com.sitool.cardsdictionary.accounting.dao;

import com.sitool.cardsdictionary.accounting.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
