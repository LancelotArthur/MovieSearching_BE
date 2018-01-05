package com.example.tjmovie.service.impl;

import com.example.tjmovie.entity.Account;
import com.example.tjmovie.entity.Review;
import com.example.tjmovie.entity.SeenList;
import com.example.tjmovie.entity.WishList;
import com.example.tjmovie.repository.AccountRepository;
import com.example.tjmovie.repository.ReviewRepository;
import com.example.tjmovie.repository.SeenListRepository;
import com.example.tjmovie.repository.WishListRepository;
import com.example.tjmovie.security.TokenManager;
import com.example.tjmovie.security.TokenModel;
import com.example.tjmovie.service.AccountService;
import com.example.tjmovie.util.ResJsonTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.tjmovie.util.MD5Encryption;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private WishListRepository wishListRepository;

    @Autowired
    private SeenListRepository seenListRepository;

    @Autowired
    private TokenManager tokenManager;

    @Override
    public ResJsonTemplate register(String userName, String userPassword, String email, String nickName){
        if (accountRepository.findByUserName(userName) != null){
            return new ResJsonTemplate<>("400", "用户名已存在");
        }
        //System.out.print(accountRepository.findByUserName(username).getUserName());
        Account account = new Account();
        account.setId(userName);
        account.setUserName(userName);
        account.setUserPassword(MD5Encryption.md5(userPassword));
        account.setEmail(email);
        account.setNickName(nickName);
        account.setCreateTime(new Date());
        account.setUpdateTime(new Date());
        accountRepository.save(account);
        return new ResJsonTemplate<>("201", "注册成功");
    }

    @Override
    public ResJsonTemplate login(String userName, String userPassword){
        Account account = accountRepository.findByUserName(userName);
        if (account == null)
            return new ResJsonTemplate<>("401", "用户不存在");
        else if (!account.getUserPassword().equals(MD5Encryption.md5(userPassword)))
            return new ResJsonTemplate<>("401", "用户名或密码不正确");
        TokenModel tokenModel = tokenManager.createToken(userName);
        return new ResJsonTemplate<>("200", tokenModel);
    }

    @Override
    public ResJsonTemplate logout(String userName){
        tokenManager.deleteToken(userName);
        return new ResJsonTemplate<>("200", "注销成功");
    }

    @Override
    public ResJsonTemplate getAccount(String userId){
        return new ResJsonTemplate<>("200", accountRepository.findByUserName(userId));
    }

    @Override
    public ResJsonTemplate addReview(Account account, String movieId, int score, String text){
        Review review = new Review();
        review.setMovieId(movieId);
        review.setUserId(account.getId());
        review.setUserName(account.getUserName());
        review.setScore(score);
        review.setReviewTime(new Date());
        review.setReviewText(text);
        reviewRepository.save(review);
        return new ResJsonTemplate<>("200", review);
    }

    @Override
    public ResJsonTemplate deleteReview(Account account, String movieId){
        reviewRepository.deleteReviewByMovieIdAndUserId(movieId, account.getUserName());
        return new ResJsonTemplate<>("200", "成功删除");
    }

    @Override
    public ResJsonTemplate findReview(String userId){
        return new ResJsonTemplate<>("200", reviewRepository.findReviewsByUserId(userId));
    }

    @Override
    public ResJsonTemplate findWishList(String userId){
        return new ResJsonTemplate<>("200", wishListRepository.findWishListsByUserId(userId));
    }

    @Override
    public ResJsonTemplate addWish(Account account, String movieId){
        WishList wish = new WishList();
        wish.setMovieId(movieId);
        wish.setUserId(account.getUserName());
        wishListRepository.save(wish);
        return new ResJsonTemplate<>("200", wish);
    }

    @Override
    public ResJsonTemplate deleteWish(Account account, String movieId){
        wishListRepository.deleteWishListByMovieIdAndUserId(account.getUserName(), movieId);
        return new ResJsonTemplate<>("200", "删除成功");
    }

    @Override
    public ResJsonTemplate findSeenList(String userId){
        return new ResJsonTemplate<>("200", seenListRepository.findSeenListsByUserId(userId));
    }

    @Override
    public ResJsonTemplate addSeen(Account account, String movieId){
        SeenList seen = new SeenList();
        seen.setMovieId(movieId);
        seen.setUserId(account.getUserName());
        seenListRepository.save(seen);
        return new ResJsonTemplate<>("200", seen);
    }

    @Override
    public ResJsonTemplate deleteSeen(Account account, String movieId){
        seenListRepository.deleteSeenListByMovieIdAndUserId(account.getUserName(), movieId);
        return new ResJsonTemplate<>("200", "删除成功");
    }

}
