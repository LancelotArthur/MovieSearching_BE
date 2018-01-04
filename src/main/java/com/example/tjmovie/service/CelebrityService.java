package com.example.tjmovie.service;


import com.example.tjmovie.util.ResJsonTemplate;


public interface CelebrityService {

    ResJsonTemplate findMoviesOfCelebrity(String cbId);

    ResJsonTemplate findCelebrity(String cbId);

}
