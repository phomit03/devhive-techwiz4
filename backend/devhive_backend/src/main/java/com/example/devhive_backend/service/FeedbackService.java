package com.example.devhive_backend.service;

import com.example.devhive_backend.dto.FeedbackDTO;
import com.example.devhive_backend.entity.Feedback;

import java.util.List;

public interface FeedbackService {
    List<FeedbackDTO> getAllFeedbacks();

    FeedbackDTO getFeedbackById(Long id);

    Feedback createFeedback(FeedbackDTO feedbackDTO);
}
