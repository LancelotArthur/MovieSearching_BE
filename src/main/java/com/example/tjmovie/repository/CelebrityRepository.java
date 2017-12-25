package com.example.tjmovie.repository;

import com.example.tjmovie.entity.Celebrity;
import org.springframework.data.repository.CrudRepository;

public interface CelebrityRepository extends CrudRepository<Celebrity, String> {

    /**
     * @param celebrity 要存储的celebrity
     * @return 返回已经存储在数据库的Celebrity
     */
    Celebrity save(Celebrity celebrity);

    Celebrity findCelebrityById(String cbId);

}
