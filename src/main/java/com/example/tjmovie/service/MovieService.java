package com.example.tjmovie.service;

import com.example.tjmovie.util.ResJsonTemplate;

public interface MovieService {

    ResJsonTemplate findMovie(String movieId);

    ResJsonTemplate findCelebritiesOfMovie(String movieId);

    ResJsonTemplate findReviewsOfMovie(String movie);

    ResJsonTemplate searchMovieByKeyword(String keyword);

    ResJsonTemplate searchMovieByGenre(String genre);

    ResJsonTemplate searchMovieByYear(int startYear, int endYear);

}
