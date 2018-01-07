package com.example.tjmovie.service;

import com.example.tjmovie.util.ResJsonTemplate;

public interface Neo4jService {

    ResJsonTemplate findMoviesByActor(String tag);

    ResJsonTemplate findMoviesByDirector(String tag);

    ResJsonTemplate findActorsByDirector(String tag);

}
