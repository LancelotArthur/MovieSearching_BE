package com.example.tjmovie.controller;


import com.example.tjmovie.service.CelebrityService;
import com.example.tjmovie.service.MovieService;
import com.example.tjmovie.util.ResJsonTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private CelebrityService celebrityService;

    @RequestMapping(value = "/movie/{movieId}", method = RequestMethod.GET)
    public ResJsonTemplate getMovie(@PathVariable String movieId){
        return movieService.findMovie(movieId);
    }

    @RequestMapping(value = "/movie/{movieId}/celebrity", method = RequestMethod.GET)
    public ResJsonTemplate getCelebrityOfMovie(@PathVariable String movieId){
        return movieService.findCelebritiesOfMovie(movieId);
    }

    @RequestMapping(value = "/celebrity/{cbId}")
    public ResJsonTemplate getCelebrity(@PathVariable String cbId){
        return celebrityService.findCelebrity(cbId);
    }

}
