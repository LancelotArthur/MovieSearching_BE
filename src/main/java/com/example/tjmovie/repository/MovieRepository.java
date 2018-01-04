package com.example.tjmovie.repository;

import com.example.tjmovie.entity.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface MovieRepository extends CrudRepository<Movie, String> {

    /**
     * @param movie 要存储的movie
     * @return 返回已经存储在数据库的Movie
     */
    Movie save(Movie movie);

    Movie findMovieById(String id);

    @Query(value = "select m from Movie m where m.genres like %?1% ")
    List<Movie> findMoviesByGenres(String genres);

    @Query(value = "select m from Movie m where m.movieName like %?1%")
    List<Movie> findMoviesByMovieName(char movieName);

    @Query(value = "select m from Movie m where m.releaseTime like %?1%")
    List<Movie> findMoviesByReleaseTime(String year);

    @Query(value = "select m from Movie m where m.movieLanguage like %?1%")
    List<Movie> findMoviesByMovieLanguage(String language);

}
