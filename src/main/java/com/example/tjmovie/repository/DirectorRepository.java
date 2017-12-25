package com.example.tjmovie.repository;

import com.example.tjmovie.entity.Director;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DirectorRepository extends CrudRepository<Director, String> {

    /**
     * @param director 要存储的director
     * @return 返回已经存储在数据库的Director
     */
    Director save(Director director);

    /**
     * @param movieId movie's id
     * @return 返回符合movie_id的director对象,根据电影查导演
     */
    List<Director> findDirectorsByMovieId(String movieId);

    /**
     * @param cbId celebrity's id
     * @return 返回符合movie_id的director对象,根据导演查电影
     */
    List<Director> findDirectorsByCbId(String cbId);

}
