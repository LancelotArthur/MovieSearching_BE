package com.example.tjmovie.controller;

import com.example.tjmovie.entity.Account;
import com.example.tjmovie.security.Authorization;
import com.example.tjmovie.security.CurrentUser;
import com.example.tjmovie.service.AccountService;
import com.example.tjmovie.util.ResJsonTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;


@RestController
@EnableAutoConfiguration
public class AccountController {

    @Autowired
    private AccountService accountService;



    @RequestMapping("/")
    @Authorization
    public ResJsonTemplate home(
            @CurrentUser Account account
    ) {
        return new ResJsonTemplate<>("200", account);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResJsonTemplate register(
            @RequestParam(value = "userName") String userName,
            @RequestParam(value = "userPassword") String userPassword,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "nickName") String nickName) {
        return accountService.register(userName, userPassword, email, nickName);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResJsonTemplate login(
            @RequestParam(value = "userName") String userName,
            @RequestParam(value = "userPassword") String userPassword){

        return accountService.login(userName, userPassword);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @Authorization
    public ResJsonTemplate logout(@RequestParam(value = "userName") String userName){
        return accountService.logout(userName);
    }

    @RequestMapping(value = "/review/addition", method = RequestMethod.POST)
    @Authorization
    public ResJsonTemplate addReview(
            @CurrentUser Account account,
            @RequestParam(value = "movieId") String movieId,
            @RequestParam(value = "score") int score,
            @RequestParam(value = "reviewText") String reviewText){
        return accountService.addReview(account, movieId, score, reviewText);

    }

    @RequestMapping(value = "/review/delete", method = RequestMethod.POST)
    @Authorization
    public ResJsonTemplate deleteReview(
            @CurrentUser Account account,
            @RequestParam(value = "movieId") String movieId){
        return accountService.deleteReview(account, movieId);
    }

    @RequestMapping(value = "/users/{userId}/reviews", method = RequestMethod.GET)
    public ResJsonTemplate getReview(@PathVariable String userId){return accountService.findReview(userId);}

    @RequestMapping(value = "/users/{userId}/wish")
    public ResJsonTemplate getWishList(@PathVariable String userId){
        return accountService.findWishList(userId);
    }

    @RequestMapping(value = "/wishList/addition")
    @Authorization
    public ResJsonTemplate addWish(
            @CurrentUser Account account,
            @RequestParam(value = "movieId") String movieId){
        return accountService.addWish(account, movieId);
    }

    @RequestMapping(value = "/wishList/delete")
    @Authorization
    public ResJsonTemplate deleteWish(
            @CurrentUser Account account,
            @RequestParam(value = "movieId") String movieId){
        return accountService.deleteWish(account, movieId);
    }

    @RequestMapping(value = "/users/{userId}/seen")
    public ResJsonTemplate getSeenList(@PathVariable String userId){
        return accountService.findSeenList(userId);
    }

    @RequestMapping(value = "/seenList/addition")
    @Authorization
    public ResJsonTemplate addSeen(
            @CurrentUser Account account,
            @RequestParam(value = "movieId") String movieId){
        return accountService.addSeen(account, movieId);
    }

    @RequestMapping(value = "/seenList/delete")
    @Authorization
    public ResJsonTemplate deleteSeen(
            @CurrentUser Account account,
            @RequestParam(value = "movieId") String movieId){
        return accountService.deleteSeen(account, movieId);
    }


}
