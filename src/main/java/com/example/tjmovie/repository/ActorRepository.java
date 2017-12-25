package com.example.tjmovie.repository;

import com.example.tjmovie.entity.Actor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * 为数据库映射后的actor数据操作
 */

public interface ActorRepository extends CrudRepository<Actor, String> {

    /**
     * @param actor 要存储的actor
     * @return 返回已经存储在数据库的actor
     */
    Actor save(Actor actor);

    /**
     * @param movieId movie's id
     * @return 返回符合movie_id的actor对象,根据电影查演员
     */
    List<Actor> findActorsByMovieId(String movieId);

    /**
     * @param cbId celebrity's id
     * @return 返回符合movie_id的actor对象,根据演员查电影
     */
    List<Actor> findActorsByCbId(String cbId);


}
