package com.example.reviews.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reviews.models.Review;

public interface ReviewsRepository extends JpaRepository<Review, Long> {
    List<Review> findByTitle(String title);
}
