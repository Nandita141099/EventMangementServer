package com.elysiana.service;

import java.util.List;
import java.util.Optional;

import com.elysiana.entities.Review;

public interface ReviewService {

	List<Review> getReviewByUserId(Integer userId);

	Optional<Review> getReviewById(Integer reviewId);

	void deleteReviewById(Integer reviewId);

	Review saveReview(Review review);

	List<Review> getReviewByEventId(Integer eventId);
	
	void updateReviewById(Review review, Integer reviewId); //this one new
	
	

}
