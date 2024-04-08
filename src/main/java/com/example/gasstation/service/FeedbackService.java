package com.example.gasstation.service;

import com.example.gasstation.dto.FeedbackForm;
import com.example.gasstation.model.Branch;
import com.example.gasstation.model.Feedback;
import com.example.gasstation.repository.BranchRepository;
import com.example.gasstation.repository.FeedbackRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;
    private final BranchRepository branchRepository;

    public boolean add(FeedbackForm feedbackForm) {
        Feedback feedback = new Feedback();

        if (!branchRepository.existsById(feedbackForm.getBranchId())) {
            return false;
        }

        feedback.setBranch(branchRepository.findById(feedbackForm.getBranchId()).get());
        feedback.setPhone(feedbackForm.getPhone());
        feedback.setName(feedbackForm.getName());
        feedback.setEmail(feedbackForm.getEmail());
        feedback.setBody(feedbackForm.getBody());
        feedback.setFeedbackDate(LocalDateTime.now());

        try {
            feedbackRepository.save(feedback);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
