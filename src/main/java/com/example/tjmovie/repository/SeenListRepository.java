package com.example.tjmovie.repository;


import com.example.tjmovie.entity.SeenList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 为数据库映射后的SeenList数据操作
 */
@Transactional
public interface SeenListRepository extends CrudRepository<SeenList, String> {

    /**
     * @param seenList 要存储的seenList
     * @return 返回已经存储在数据库的SeenList
     */
    SeenList save(SeenList seenList);

    List<SeenList> findSeenListsByUserId(String userId);

    void deleteSeenListByMovieIdAndUserId(String movieId, String userId);

}
