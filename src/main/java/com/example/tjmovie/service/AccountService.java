package com.example.tjmovie.service;

import com.example.tjmovie.entity.Account;
import com.example.tjmovie.util.ResJsonTemplate;

public interface AccountService {

    ResJsonTemplate register(String userName, String userPassword, String email, String nickName);

    ResJsonTemplate login(String username, String userPassword);

    ResJsonTemplate logout(String userName);

    ResJsonTemplate getAccount(String userId);

    ResJsonTemplate addReview(Account account, String movieId, int score, String text);

    ResJsonTemplate deleteReview(Account account, String movieId);

    ResJsonTemplate findReview(String userId);

    ResJsonTemplate findWishList(String userId);

    ResJsonTemplate addWish(Account account, String movieId);

    ResJsonTemplate deleteWish(Account account, String movieId);

    ResJsonTemplate findSeenList(String userId);

    ResJsonTemplate addSeen(Account account, String movieId);

    ResJsonTemplate deleteSeen(Account account, String movieId);

}
