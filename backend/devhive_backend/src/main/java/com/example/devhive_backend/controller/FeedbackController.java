package com.example.devhive_backend.controller;

import com.example.devhive_backend.dto.FeedbackDTO;
import com.example.devhive_backend.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;
    @GetMapping("getAll")
    public ResponseEntity<List<FeedbackDTO>> getAllFeedbacks() {
        List<FeedbackDTO> feedbacks = feedbackService.getAllFeedbacks();
        return new ResponseEntity<>(feedbacks, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<FeedbackDTO> getFeedbackById(@PathVariable Long id) {
        FeedbackDTO FeedbackById = feedbackService.getFeedbackById(id);
        return new ResponseEntity<>(FeedbackById,HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<String> createFeedback(@RequestBody FeedbackDTO feedbackDTO) {
        feedbackService.createFeedback(feedbackDTO);
        return new ResponseEntity<>("Feedback created successfully",HttpStatus.CREATED);
    }

}
