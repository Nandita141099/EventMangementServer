


package com.elysiana.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.elysiana.entities.Event;
import com.elysiana.entities.Review;
import com.elysiana.entities.User;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Integer> {
	List<Review> findByEvent(Event event);

	List<Review> findByUser(User user);

//	List<Review> findByEventAndRatingGreaterThanEqual(Integer eventId, Integer rating);

}

