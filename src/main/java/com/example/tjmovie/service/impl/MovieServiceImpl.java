package com.example.tjmovie.service.impl;

import com.example.tjmovie.entity.*;
import com.example.tjmovie.repository.*;
import com.example.tjmovie.service.MovieService;
import com.example.tjmovie.util.ResJsonTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

    @Autowired
    private CelebrityRepository celebrityRepository;

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private WriterRepository writerRepository;

    @Autowired
    private ProducerRepository producerRepository;

    @Autowired
    private DirectorRepository directorRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public ResJsonTemplate findMovie(String movieId){
        Movie movie = movieRepository.findMovieById(movieId);
        if (movie == null)
            return new ResJsonTemplate<>("503", "找不到资源");
        return new ResJsonTemplate<>("200", movie);
    }

    @Override
    public ResJsonTemplate findCelebritiesOfMovie(String movieId){
        IdentityHashMap<String, List> celebrities = new IdentityHashMap<>();
        List<Actor> actors = actorRepository.findActorsByMovieId(movieId);
        List<Director> directors = directorRepository.findDirectorsByMovieId(movieId);
        List<Producer> producers = producerRepository.findProducersByMovieId(movieId);
        List<Writer> writers = writerRepository.findWritersByMovieId(movieId);
        List<Celebrity> ac = new ArrayList<>();
        List<Celebrity> dc = new ArrayList<>();
        List<Celebrity> pc = new ArrayList<>();
        List<Celebrity> wc = new ArrayList<>();

        if (!actors.isEmpty()){
            for (Actor a : actors){
                ac.add(celebrityRepository.findCelebrityById(a.getCbId()));
            }
            celebrities.put("Actors", ac);
        }
        if (!directors.isEmpty()){
            for (Director d : directors){
                dc.add(celebrityRepository.findCelebrityById(d.getCbId()));
            }
            celebrities.put("Directors", dc);
        }
        if (!producers.isEmpty()){
            for (Producer p : producers){
                pc.add(celebrityRepository.findCelebrityById(p.getCbId()));
            }
            celebrities.put("Producers", pc);
        }
        if (!writers.isEmpty()){
            for (Writer w : writers){
                wc.add(celebrityRepository.findCelebrityById(w.getCbId()));
            }
            celebrities.put("Writers", wc);
        }

        return new ResJsonTemplate<>("200", celebrities);
    }

    @Override
    public ResJsonTemplate findReviewsOfMovie(String movieId){
        List<Review> reviews = reviewRepository.findReviewsByMovieId(movieId);
        return new ResJsonTemplate<>("200", reviews);
    }

    @Override
    public ResJsonTemplate searchMovieByKeyword(String keyword){
        return new ResJsonTemplate<>("200", "TBD");
    }

    @Override
    public ResJsonTemplate searchMovieByGenre(String genre){
        List<Movie> movies = movieRepository.findMoviesByGenres(genre);
        return new ResJsonTemplate<>("200", movies);
    }

    @Override
    public ResJsonTemplate searchMovieByYear(int startYear, int endYear){
        return new ResJsonTemplate<>("200", "TBD");
    }

}
