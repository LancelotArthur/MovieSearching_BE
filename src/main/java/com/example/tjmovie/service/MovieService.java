package com.example.tjmovie.service;

import com.example.tjmovie.util.ResJsonTemplate;

public interface MovieService {

    ResJsonTemplate findDVDsByYear(String tag);

    ResJsonTemplate findDVDsByYearAndMonth(String tag);

    ResJsonTemplate findDVDsByYearAndSeason(String tag);

    ResJsonTemplate findDVDsByWeekday(String tag);

    ResJsonTemplate findBanbensByName(String tag);

    ResJsonTemplate findMoviesByGenre(String tag);

    ResJsonTemplate findMoviesByActor(String tag);

    ResJsonTemplate findMoviesByDirector(String tag);

    ResJsonTemplate findActorsByDirector(String tag);

}
