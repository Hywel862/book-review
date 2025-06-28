package com.example.reviews.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.reviews.exceptions.ReviewsNotFoundException;
import com.example.reviews.models.Review;
import com.example.reviews.repository.ReviewsRepository;

@Service
public class ReviewsService {

    private final ReviewsRepository reviewsRepository;

    public ReviewsService(ReviewsRepository reviewsRepository) {
        this.reviewsRepository = reviewsRepository;
    }

    public ResponseEntity<String> createReview(Review review) {
        review.setCreated(LocalDateTime.now());
        reviewsRepository.save(review);
        return ResponseEntity.ok("Review created successfully");
    }

    public ResponseEntity<List<Review>> retrieveReviews() {
        List<Review> reviews =  reviewsRepository.findAll();
        if (reviews.isEmpty()) {
            throw new ReviewsNotFoundException("No reviews found.");
        }
        return ResponseEntity.ok(reviews);
    }

    public ResponseEntity<List<Review>> retrieveReviewByTitle(Review review) {
        List<Review> reviews = reviewsRepository.findByTitle(review.getTitle()).stream().filter(
            entity -> entity.getTitle().equals(review.getTitle())
        ).toList();
        if (reviews.isEmpty()) {
            throw new ReviewsNotFoundException("No reviews found.");
        }
        return ResponseEntity.ok(reviews);
    }
}
