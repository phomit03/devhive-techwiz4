package com.example.devhive_backend.mapper;

import com.example.devhive_backend.dto.FeedbackDTO;
import com.example.devhive_backend.entity.Feedback;

public class FeedbackMapper {
    public static Feedback mapToFeedback(FeedbackDTO feedbackDTO) {
        return Feedback.builder()
                .id(feedbackDTO.getId())
                .name(feedbackDTO.getName())
                .email(feedbackDTO.getEmail())
                .subject(feedbackDTO.getSubject())
                .description(feedbackDTO.getDescription())
                .build();
    }

    public static FeedbackDTO mapToFeedbackDTO(Feedback feedback) {
        return FeedbackDTO.builder()
                .id(feedback.getId())
                .name(feedback.getName())
                .email(feedback.getEmail())
                .subject(feedback.getSubject())
                .description(feedback.getDescription())
                .build();
    }
}