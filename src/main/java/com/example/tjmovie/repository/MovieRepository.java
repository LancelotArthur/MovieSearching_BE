package com.example.tjmovie.repository;

import com.example.tjmovie.entity.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface MovieRepository extends CrudRepository<Movie, String> {

    /**
     * @param movie 要存储的movie
     * @return 返回已经存储在数据库的Movie
     */
    Movie save(Movie movie);

    Movie findMovieById(String id);

}
