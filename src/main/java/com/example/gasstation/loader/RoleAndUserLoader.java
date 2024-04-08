package com.example.gasstation.loader;

import com.example.gasstation.model.Counter;
import com.example.gasstation.model.Role;
import com.example.gasstation.model.UserTable;
import com.example.gasstation.repository.CounterRepository;
import com.example.gasstation.repository.RoleRepository;
import com.example.gasstation.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class RoleAndUserLoader implements ApplicationRunner {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final CounterRepository counterRepository;
    private PasswordEncoder passwordEncoder;

    private void loadRoles() {
        Role admin = new Role();
        admin.setName("ROLE_ADMIN");

        Role moderator = new Role();
        moderator.setName("ROLE_MODERATOR");

        Role user = new Role();
        user.setName("ROLE_USER");

        try {
            roleRepository.save(admin);
        } catch (DataIntegrityViolationException e) {}
        try {
            roleRepository.save(moderator);
        }catch (DataIntegrityViolationException e) {}
        try {
            roleRepository.save(user);
        } catch (DataIntegrityViolationException e) {}
    }

    private void loadUsers() {
        UserTable admin = new UserTable();
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("password"));
        Role adminRole = roleRepository.findByName("ROLE_ADMIN");
        System.out.println(adminRole);
        admin.setRoles(List.of(adminRole));

        UserTable moderator = new UserTable();
        moderator.setUsername("moderator");
        moderator.setPassword(passwordEncoder.encode("password"));
        Role moderatorRole = roleRepository.findByName("ROLE_MODERATOR");
        moderator.setRoles(List.of(moderatorRole));

        UserTable user = new UserTable();
        user.setUsername("user123");
        user.setPassword(passwordEncoder.encode("password"));
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(List.of(userRole));

        try {
            userRepository.save(admin);
        } catch (DataIntegrityViolationException e) {}
        try {
            userRepository.save(moderator);
        } catch (DataIntegrityViolationException e) {}
        try {
            userRepository.save(user);
        } catch (DataIntegrityViolationException e) {}
    }

    private void initCounter() {
        Counter counter = new Counter();
        try {
            counterRepository.save(counter);
        } catch (DataIntegrityViolationException e) {}
    }

    public void run(ApplicationArguments args) {
        loadRoles();
        loadUsers();
        initCounter();
    }
}
