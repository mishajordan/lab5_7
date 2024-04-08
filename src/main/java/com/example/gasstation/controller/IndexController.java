package com.example.gasstation.controller;

import com.example.gasstation.dto.FeedbackForm;
import com.example.gasstation.dto.UserForm;
import com.example.gasstation.model.Branch;
import com.example.gasstation.repository.BranchRepository;
import com.example.gasstation.service.CounterService;
import com.example.gasstation.service.FeedbackService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@AllArgsConstructor
public class IndexController {

    private final CounterService counterService;
    private final FeedbackService feedbackService;
    private final BranchRepository branchRepository;

    @GetMapping(value = { "/", "/index" })
    public String index(Model model) {
        Long counter = counterService.init();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String time = dtf.format(now);

        model.addAttribute("counter", counter);
        model.addAttribute("time", time);

        return "index";
    }

    @GetMapping("/feedback")
    public String feedback(Model model) {
        List<Branch> branches = branchRepository.findAll();

        model.addAttribute("feedbackForm", new FeedbackForm());
        model.addAttribute("branches", branches);
        return "feedback/index";
    }

    @PostMapping("/feedback")
    public String sendFeedback(@ModelAttribute("userForm") @Valid FeedbackForm feedbackForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "feedback/index";
        }

        if (feedbackService.add(feedbackForm)) {
            return "feedback/success";
        }
        return "feedback/index";
    }
}
