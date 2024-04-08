package com.example.gasstation.controller;

import com.example.gasstation.dto.RoleForm;
import com.example.gasstation.model.Feedback;
import com.example.gasstation.model.Role;
import com.example.gasstation.model.UserTable;
import com.example.gasstation.repository.FeedbackRepository;
import com.example.gasstation.repository.RoleRepository;
import com.example.gasstation.repository.UserRepository;
import com.example.gasstation.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {
    private final FeedbackRepository feedbackRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserService userService;

    @GetMapping("/feedback")
    public String feedbackTable(Model model) {
        List<Feedback> feedbacks = feedbackRepository.findAll(Sort.by(Sort.Direction.DESC, "feedbackDate"));
        feedbacks.forEach(feedback -> {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
            feedback.setFormattedDate(dtf.format(feedback.getFeedbackDate()));
        });

        model.addAttribute("feedbacks", feedbacks);
        return "admin/feedback";
    }

    @GetMapping("/users")
    public String userTable(Model model) {
        List<UserTable> users = userRepository.findAll(Sort.by("id"));
        users.forEach(user -> user.setRolesView(user.getRoles()
                .stream()
                .map(Role::getName)
                .collect(Collectors.joining(", "))
        ));

        model.addAttribute("users", users);
        return "admin/users";
    }

    @GetMapping("/users/{id}/edit")
    public String editUserForm(@PathVariable Long id) {
        return "profile/change_username";
    }

    @PostMapping("/users/{id}/edit")
    public String editUser(@PathVariable Long id, @RequestParam("username") String username) {
        UserTable user = userRepository.findById(id).get();
        if (userService.editUsername(user.getUsername(), username)) {
            return "redirect:/admin/users";
        }

        return "profile/change_username";
    }

    @GetMapping("/users/{id}/roles")
    public String editRoleForm(@PathVariable Long id, Model model) {
        List<Role> roles = roleRepository.findAll();
        model.addAttribute("roles", roles);
        model.addAttribute("roleForm", new RoleForm());
        return "admin/roles";
    }

    @PostMapping("/users/{id}/roles")
    public String editRole(@PathVariable Long id, @RequestParam("role") String role) {
        userService.editRole(id, role);
        return "redirect:/admin/users";
    }
}
