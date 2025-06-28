package com.example.reviews.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.reviews.models.Review;
import com.example.reviews.repository.ReviewsRepository;

@Service
public class ReviewsService {

    @Autowired
    ReviewsRepository reviewsRepository;

    public ResponseEntity<String> createReview(Review review) {
        review.setCreated(LocalDateTime.now());
        reviewsRepository.save(review);
        return ResponseEntity.ok("Review created successfully");
    }
}
