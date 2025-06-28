package com.example.reviews.exceptions;

public class ReviewsNotFoundException extends RuntimeException {
    public ReviewsNotFoundException(String message) {
        super(message);
    }
}
