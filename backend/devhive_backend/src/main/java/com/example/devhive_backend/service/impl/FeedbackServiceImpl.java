package com.example.devhive_backend.service.impl;

import com.example.devhive_backend.dto.FeedbackDTO;
import com.example.devhive_backend.entity.Feedback;
import com.example.devhive_backend.repository.FeedbackRepository;
import com.example.devhive_backend.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.devhive_backend.mapper.FeedbackMapper.mapToFeedback;
import static com.example.devhive_backend.mapper.FeedbackMapper.mapToFeedbackDTO;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;
    @Override
    public List<FeedbackDTO> getAllFeedbacks() {
        List<Feedback> feedbacks = feedbackRepository.findAll();
        return feedbacks.stream().map((feedback) -> mapToFeedbackDTO(feedback)).collect(Collectors.toList());
    }

    @Override
    public FeedbackDTO getFeedbackById(Long id) {
        Feedback feedback =  feedbackRepository.findById(id).get();
        return mapToFeedbackDTO(feedback);
    }

    @Override
    public Feedback createFeedback(FeedbackDTO feedbackDTO) {
        Feedback feedback = mapToFeedback(feedbackDTO);
        return feedbackRepository.save(feedback);
    }
}
