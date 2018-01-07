package com.example.tjmovie.mysqlrepository;

import com.example.tjmovie.dto.ActorNumber;
import com.example.tjmovie.mysqlentity.Actor;
import com.example.tjmovie.mysqlentity.Director;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface DirectorRepository extends CrudRepository<Director, Integer> {

    @Query(value = "SELECT COUNT (asin) FROM director d WHERE d.director=?1", nativeQuery = true)
    int findMoviesByDirector(String director);

    @Query(value = "SELECT actor, COUNT (asin), director AS xxx FROM actor a JOIN (SELECT * FROM director d WHERE d.director=?1 USING (asin) GROUP BY xxx.actor HAVING xxx.director=?1)", nativeQuery = true)
    List<ActorNumber> findActorsByDirector(String director);

}