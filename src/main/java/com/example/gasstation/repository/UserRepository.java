package com.example.gasstation.repository;

import com.example.gasstation.model.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserTable, Long> {
    UserTable findByUsername(String username);

    boolean existsByUsername(String username);
}
