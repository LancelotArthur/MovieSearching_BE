package com.example.tjmovie.mysqlrepository;

import com.example.tjmovie.mysqlentity.MovieDvd;
import com.example.tjmovie.mysqlentity.Time;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TimeRepository extends CrudRepository<Time, String> {

}
