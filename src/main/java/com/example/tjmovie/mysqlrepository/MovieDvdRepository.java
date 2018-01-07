package com.example.tjmovie.mysqlrepository;

import com.example.tjmovie.mysqlentity.MovieDvd;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MovieDvdRepository extends CrudRepository<MovieDvd, Integer>{

    @Query(value = "select COUNT(DISTINCT movie) from movie_dvd NATURAL JOIN time t WHERE t.year=?1", nativeQuery = true)
    int findMovieDvdsByYear2(int year);

    @Query(value = "select COUNT(DISTINCT movie) from movie_dvd NATURAL JOIN time t WHERE t.year=?1 AND t.month=?2", nativeQuery = true)
    int findMovieDvdsByYearAndMonth(int year, int month);

    @Query(value = "select COUNT(DISTINCT movie) from movie_dvd NATURAL JOIN time t WHERE t.year=?1 AND t.season=?2", nativeQuery = true)
    int findMovieDvdsByYearAndSeason(int year, int season);

    @Query(value = "select COUNT(DISTINCT movie) from movie_dvd NATURAL JOIN time t WHERE t.weekday=?1", nativeQuery = true)
    int findMovieDvdsByWeekday(int weekday);

    @Query(value = "select COUNT(id) from movie_dvd m WHERE m.movie=?1", nativeQuery = true)
    int findBanbensByName(String movie);

}
