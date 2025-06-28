package com.example.reviews.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.reviews.models.ApiError;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler (ReviewsNotFoundException.class)
    public ResponseEntity<ApiError> handleReviewsNotFoundException(ReviewsNotFoundException ex) {
        ApiError error = new ApiError(404, ex.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
