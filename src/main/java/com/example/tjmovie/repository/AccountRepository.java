package com.example.tjmovie.repository;

import com.example.tjmovie.entity.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


/**
 * 为数据库映射后的account数据操作
 */
public interface AccountRepository extends CrudRepository<Account, String> {

    /**
     * @param account 要存储的account
     * @return 返回已经存储在数据库的account
     */
    Account save(Account account);

    /**
     * @param id user's id
     * @return 返回符合id的account对象
     */
    Account findById(String id);

    /**
     * @param userName user's name
     * @return 返回符合name的account对象
     */
   Account findByUserName(String userName);

}
