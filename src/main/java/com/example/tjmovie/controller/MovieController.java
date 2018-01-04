package com.example.tjmovie.controller;


import com.example.tjmovie.service.CelebrityService;
import com.example.tjmovie.service.MovieService;
import com.example.tjmovie.util.ResJsonTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/celebrity/{cbId}", method = RequestMethod.GET)
    public ResJsonTemplate getCelebrity(@PathVariable String cbId){
        return celebrityService.findCelebrity(cbId);
    }

    @RequestMapping(value = "/celebrity/{cbId}/movie", method = RequestMethod.GET)
    public ResJsonTemplate getMoviesOfCelebrity(@PathVariable String cbId){
        return celebrityService.findMoviesOfCelebrity(cbId);
    }

    @RequestMapping(value = "/explore", method = RequestMethod.GET)
    public ResJsonTemplate exploreMovie(@RequestParam String tag, @RequestParam String type,
                                        @RequestParam String sort){
        if (type.equals("genres"))
            return movieService.searchMovieByGenre(tag, sort);
        else if (type.equals("keyword"))
            return movieService.searchMovieByKeyword(tag, sort);
        else if (type.equals("year"))
            return movieService.searchMovieByYear(tag, sort);
        else if (type.equals("month"))
            return movieService.searchMovieByMonth(tag, sort);
        else if (type.equals("language"))
            return movieService.searchMovieByLanguage(tag, sort);
        else
            return new ResJsonTemplate<>("200", "no type");
    }

    @RequestMapping(value = "/movie/{movieId}/review", method = RequestMethod.GET)
    public ResJsonTemplate findReviewsOfMovie(@PathVariable String movieId){
        return movieService.findReviewsOfMovie(movieId);
    }

}
