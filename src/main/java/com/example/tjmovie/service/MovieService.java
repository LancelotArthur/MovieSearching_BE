package com.example.tjmovie.service;

import com.example.tjmovie.util.ResJsonTemplate;

public interface MovieService {

    ResJsonTemplate findMovie(String movieId);

    ResJsonTemplate findCelebritiesOfMovie(String movieId);

    ResJsonTemplate findReviewsOfMovie(String movieId);

    ResJsonTemplate searchMovieByKeyword(String keyword, String sort);

    ResJsonTemplate searchMovieByGenre(String genre, String sort);

    ResJsonTemplate searchMovieByYear(String tag, String sort);

    ResJsonTemplate searchMovieByMonth(String tag, String sort);

    ResJsonTemplate searchMovieByLanguage(String tag, String sort);

}
