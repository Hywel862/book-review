package com.example.reviews.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reviews.models.Review;

public interface ReviewsRepository extends JpaRepository<Review, Long> {
    //Zero code required
}
