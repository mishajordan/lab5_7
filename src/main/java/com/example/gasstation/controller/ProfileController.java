package com.example.gasstation.controller;

import com.example.gasstation.model.UserTable;
import com.example.gasstation.service.UserService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    private final UserService userService;

    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getProfile(Model model) {
        UserTable user = userService.getCurrentUser();

        if (user.getAvatar() != null) {
            byte[] encodeBase64 = Base64.encodeBase64(user.getAvatar());
            String base64Encoded = new String(encodeBase64, StandardCharsets.UTF_8);
            user.setBase64image(base64Encoded);
        }

        model.addAttribute("user", user);
        return "profile/index";
    }

    @PostMapping("/avatar")
    public String updateAvatar(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                UserTable user = userService.getCurrentUser();
                user.setAvatar(bytes);
                userService.save(user);
            } catch (Exception e) {
                return "redirect:/profile";
            }
        }

        return "redirect:/profile";
    }

    @GetMapping("/edit/username")
    public String usernameForm() {
        return "profile/change_username";
    }

    @PostMapping("/edit/username")
    public String changeUsername(@RequestParam("username") String username) {
        UserTable user = userService.getCurrentUser();
        if (userService.editUsername(user.getUsername(), username)) {
            return "redirect:/logout";
        }
        return "profile/change_username";
    }

    @GetMapping("/edit/password")
    public String passwordForm() {
        return "profile/change_password";
    }

    @PostMapping("/edit/password")
    public String changePassword(@RequestParam("password") String password) {
        UserTable user = userService.getCurrentUser();
        userService.editPassword(user.getUsername(), password);

        return "redirect:/logout";
    }
}
