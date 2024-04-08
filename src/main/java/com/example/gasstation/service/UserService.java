package com.example.gasstation.service;

import com.example.gasstation.dto.UserForm;
import com.example.gasstation.model.Role;
import com.example.gasstation.model.UserTable;
import com.example.gasstation.repository.RoleRepository;
import com.example.gasstation.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
//@Transactional
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserTable user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new User(user.getUsername(), user.getPassword(), buildSimpleGrantedAuthorities(user.getRoles()));
    }

    private static List<SimpleGrantedAuthority> buildSimpleGrantedAuthorities(List<Role> roles) {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

    public boolean register(UserForm userForm) {
        if (userRepository.existsByUsername(userForm.getUsername())) {
            return false;
        }

        UserTable user = new UserTable();

        user.setUsername(userForm.getUsername());
        user.setPassword(passwordEncoder.encode(userForm.getPassword()));

        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(List.of(userRole));

        userRepository.save(user);
        return true;
    }

    public UserTable getCurrentUser() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findByUsername(userDetails.getUsername());
    }

    public void save(UserTable user) {
        userRepository.save(user);
    }

    public boolean editUsername(String currentUsername, String newUsername) {
        if (userRepository.existsByUsername(newUsername)) {
            return false;
        }

        UserTable user = userRepository.findByUsername(currentUsername);
        user.setUsername(newUsername);
        userRepository.save(user);

        return true;
    }

    public void editPassword(String currentUsername, String password) {
        UserTable user = userRepository.findByUsername(currentUsername);
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
    }

    public boolean editRole(Long userId, String roleName) {
        try {
            UserTable user = userRepository.findById(userId).get();
            Role role = roleRepository.findByName(roleName);
            user.getRoles().remove(user.getRoles().get(0));
            user.getRoles().add(role);
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
