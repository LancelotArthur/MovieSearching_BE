package com.example.tjmovie.mysqlrepository;

import com.example.tjmovie.mysqlentity.MovieCd;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MovieCdRepository extends CrudRepository<MovieCd, Integer>{

    @Query(value = "select COUNT(DISTINCT movie) from movie_cd NATURAL JOIN time t WHERE t.year=?1", nativeQuery = true)
    int findMoviecdsByYear2(int year);

    @Query(value = "select COUNT(DISTINCT movie) from movie_cd NATURAL JOIN time t WHERE t.year=?1 AND t.month=?2", nativeQuery = true)
    int findMoviecdsByYearAndMonth(int year, int month);

    @Query(value = "select COUNT(DISTINCT movie) from movie_cd NATURAL JOIN time t WHERE t.year=?1 AND t.season=?2", nativeQuery = true)
    int findMoviecdsByYearAndSeason(int year, int season);

    @Query(value = "select COUNT(DISTINCT movie) from movie_cd NATURAL JOIN time t WHERE t.weekday=?1", nativeQuery = true)
    int findMoviecdsByWeekday(int weekday);

    @Query(value = "select COUNT(id) from movie_cd m WHERE m.movie=?1", nativeQuery = true)
    int findBanbensByName(String movie);

}
