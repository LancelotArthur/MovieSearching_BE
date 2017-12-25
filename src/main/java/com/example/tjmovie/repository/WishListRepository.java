package com.example.tjmovie.repository;


import com.example.tjmovie.entity.WishList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 为数据库映射后的WishList数据操作
 */
@Transactional
public interface WishListRepository extends CrudRepository<WishList, String> {

    /**
     * @param wishList 要存储的wishList
     * @return 返回已经存储在数据库的WishList
     */
    WishList save(WishList wishList);

    List<WishList> findWishListsByUserId(String userId);

    void deleteWishListByMovieIdAndUserId(String movieId, String userId);

}
