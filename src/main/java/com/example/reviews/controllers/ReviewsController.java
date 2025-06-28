package com.example.reviews.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.reviews.models.Review;
import com.example.reviews.services.ReviewsService;

@Controller
@RequestMapping("/reviews")
public class ReviewsController {

    @Autowired
    ReviewsService reviewsService;

    @PostMapping("/create")
    public ResponseEntity<String> createReview(@RequestBody Review review) {
        return reviewsService.createReview(review);
    }
}
