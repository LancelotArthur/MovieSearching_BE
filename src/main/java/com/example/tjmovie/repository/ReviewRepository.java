package com.example.tjmovie.repository;


import com.example.tjmovie.entity.Review;
import com.example.tjmovie.entity.ReviewPK;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ReviewRepository extends CrudRepository<Review, String> {

    /**
     * @param review 要存储的review
     * @return 返回已经存储在数据库的SeenList
     */
    Review save(Review review);

    void deleteReviewByMovieIdAndUserId(String movieId, String userId);

    List<Review> findReviewsByUserId(String userId);

    List<Review> findReviewsByMovieId(String movieId);

    List<Review> findReviewsByHelpfulnessGreaterThan(int i);


}
