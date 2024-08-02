package com.elysiana.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elysiana.entities.Review;
import com.elysiana.exceptions.ResourceNotFoundException;
import com.elysiana.payloads.ApiResponse;
import com.elysiana.service.ReviewService;
import com.elysiana.service.impl.ReviewServiceImpl;

@RestController
@RequestMapping("/api/users")
public class ReviewController {

	@Autowired
	private ReviewServiceImpl reviewService;
	

	@PostMapping("/events/{eventId}/reviews")
	public ResponseEntity<Review> createReview(@RequestBody Review review) {
		Review savedReview = reviewService.saveReview(review);
		return ResponseEntity.ok(savedReview);
	}

	@GetMapping("/event/{eventId}/reviews")
	public ResponseEntity<List<Review>> getReviewsByEvent(@PathVariable Integer eventId) {
		List<Review> reviews = reviewService.getReviewByEventId(eventId);
		return ResponseEntity.ok(reviews);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<List<Review>> getReviewsByUser(@PathVariable Integer userId) {
		List<Review> reviews = reviewService.getReviewByUserId(userId);
		return ResponseEntity.ok(reviews);
	}

	@GetMapping("/reviews/{reviewId}")
	public ResponseEntity<Review> getReviewById(@PathVariable Integer reviewId) {
		Review review = reviewService.getReviewById(reviewId)
				.orElseThrow(() -> new ResourceNotFoundException("Review", "id", reviewId));

		return new ResponseEntity<>(review, HttpStatus.OK);
	}

	@DeleteMapping("/reviews/{reviewId}")
	public ResponseEntity<ApiResponse> deleteReview(@PathVariable Integer reviewId) {
		reviewService.deleteReviewById(reviewId);
		return new ResponseEntity<>(new ApiResponse("Review deleted successfully", true), HttpStatus.OK);
	}

}
