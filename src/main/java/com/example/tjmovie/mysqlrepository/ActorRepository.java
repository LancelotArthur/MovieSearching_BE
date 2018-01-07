package com.example.tjmovie.mysqlrepository;

import com.example.tjmovie.mysqlentity.Actor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ActorRepository extends CrudRepository<Actor, Integer> {

    @Query(value = "SELECT COUNT (asin) FROM actor a WHERE a.actor=?1", nativeQuery = true)
    int findMoviesByActor(String actor);

}
