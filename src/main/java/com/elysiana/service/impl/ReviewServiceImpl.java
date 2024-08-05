
package com.elysiana.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elysiana.entities.Event;
import com.elysiana.entities.Location;
import com.elysiana.entities.Review;
import com.elysiana.entities.User;
import com.elysiana.exceptions.ResourceNotFoundException;
import com.elysiana.repository.EventRepository;
import com.elysiana.repository.ReviewRepository;
import com.elysiana.repository.UserRepository;
import com.elysiana.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {
	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private UserRepository userRepository;

	public Review saveReview(Review review) {
		return reviewRepository.save(review);
	}

	public List<Review> getReviewByEventId(Integer eventId) {
		Event event = eventRepository.findById(eventId)
				.orElseThrow(() -> new ResourceNotFoundException("Event", "id", eventId));
		return reviewRepository.findByEvent(event);
	}

	public List<Review> getReviewByUserId(Integer userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		return reviewRepository.findByUser(user);
	}

	public Optional<Review> getReviewById(Integer reviewId) {
		return reviewRepository.findById(reviewId);
	}

	public void deleteReviewById(Integer reviewId) {
		reviewRepository.deleteById(reviewId);
	}

	@Override
	public void updateReviewById(Review review1, Integer reviewId) {
	
Review review = reviewRepository.findById(reviewId).orElseThrow(() -> new ResourceNotFoundException("Review", "Id", reviewId));
		
	}
};