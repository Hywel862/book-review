package com.example.reviews.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.reviews.models.Review;
import com.example.reviews.services.ReviewsService;

@Controller
@RequestMapping("/reviews")
public class ReviewsController {

    ReviewsService reviewsService;

    public ReviewsController(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createReview(@RequestBody Review review) {
        return reviewsService.createReview(review);
    }

    @GetMapping ("/retrieve")
    public ResponseEntity<List<Review>> retrieveReviews() {
        return reviewsService.retrieveReviews();
    }

    @PostMapping("/retrieve")
    public ResponseEntity<List<Review>> retrieveSpecificReview(@RequestBody Review review) {
        return reviewsService.retrieveReviewByTitle(review);
    }
}
