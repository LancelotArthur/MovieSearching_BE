package com.example.tjmovie.repository;

import com.example.tjmovie.entity.Producer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ProducerRepository extends CrudRepository<Producer, String>{

    /**
     * @param producer 要存储的producer
     * @return 返回已经存储在数据库的producer
     */
    Producer save(Producer producer);

    List<Producer> findProducersByCbId(String cbId);

    List<Producer> findProducersByMovieId(String movieId);

}
