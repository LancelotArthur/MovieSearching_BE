package com.example.tjmovie.controller;


import com.example.tjmovie.service.MovieService;
import com.example.tjmovie.service.Neo4jService;
import com.example.tjmovie.util.ResJsonTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private Neo4jService neo4jService;

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public ResJsonTemplate findMovieDVDsByYear(@RequestParam String tag, @RequestParam String type){
        switch (type){
            case "year": return movieService.findDVDsByYear(tag);
            case "month": return movieService.findDVDsByYearAndMonth(tag);
            case "weekday": return movieService.findDVDsByWeekday(tag);
            case "season": return movieService.findDVDsByYearAndSeason(tag);
            case "banben": return movieService.findBanbensByName(tag);
            case "genre" : return movieService.findMoviesByGenre(tag);
            case "actor" : return movieService.findMoviesByActor(tag);
            case "director" : return movieService.findMoviesByDirector(tag);
            case "actor-director" : return movieService.findActorsByDirector(tag);
            case "default": break;
        }

        return null;
    }

    @RequestMapping(value = "/neo4j/count", method = RequestMethod.GET)
    public ResJsonTemplate countNeo4jMovies(@RequestParam String tag, @RequestParam String type){
        switch (type){
            case "actor" : return neo4jService.findMoviesByActor(tag);
            case "director" : return neo4jService.findMoviesByDirector(tag);
            case "actor-director" : return neo4jService.findActorsByDirector(tag);
            case "default": break;
        }

        return null;
    }

}
