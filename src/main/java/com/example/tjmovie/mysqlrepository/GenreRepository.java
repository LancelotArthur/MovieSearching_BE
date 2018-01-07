package com.example.tjmovie.mysqlrepository;

import com.example.tjmovie.mysqlentity.Genre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Integer> {

    @Query(value = "SELECT COUNT (asin) FROM genre g WHERE g.genre=?1", nativeQuery = true)
    int findMoviesByGenre(String genre);

}
