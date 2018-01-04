package com.example.tjmovie.service.impl;

import com.example.tjmovie.entity.*;
import com.example.tjmovie.repository.*;
import com.example.tjmovie.service.MovieService;
import com.example.tjmovie.util.ListSort;
import com.example.tjmovie.util.ResJsonTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.*;

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

    private ListSort<Movie> movieListSort = new ListSort<>();

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
    public ResJsonTemplate searchMovieByKeyword(String keyword, String sort){
        List<List<Movie>> movieLists = new ArrayList<>();
        for(int i = 0; i < keyword.length(); ++i)
        {
            movieLists.add(movieRepository.findMoviesByMovieName(keyword.charAt(i)));
        }
        HashMap<Movie, Integer> hp = new HashMap<>();
        for (List<Movie> ms : movieLists) {
            for (Movie m : ms){
                if (!hp.containsKey(m)){
                    hp.put(m, 1);
                }
                else{
                    Integer t = hp.get(m);
                    t = t + 1;
                    hp.put(m, t);
                }
            }
        }
        int total = hp.size() >= 10 ? 10 : hp.size();
        int i = 0;
        List<Movie> movies = new ArrayList<>();
        //Integer[] integers = new Integer[hp.size()];
        //hp.values().toArray(integers);
        //Arrays.sort(integers);
        List<Map.Entry<Movie,Integer>> list = new ArrayList<>(hp.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<Movie,Integer>>() {
            //降序排序
            public int compare(Map.Entry<Movie,Integer> o1, Map.Entry<Movie,Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        for (Map.Entry<Movie, Integer> me : list){
            movies.add(me.getKey());
            ++i;
            if (i >= total) {
                break;
            }
        }
        movieListSort.sort(movies, "get" + sort, "desc");
        return new ResJsonTemplate<>("200", movies);
    }

    @Override
    public ResJsonTemplate searchMovieByGenre(String genre, String sort){
        List<Movie> movies = movieRepository.findMoviesByGenres(genre);
        movieListSort.sort(movies, "get" + sort, "desc");
        return new ResJsonTemplate<>("200", movies);
    }

    @Override
    public ResJsonTemplate searchMovieByYear(String tag, String sort){
        int startYear = Integer.parseInt(tag.split("-")[0]);
        int endYear = Integer.parseInt(tag.split("-")[1]);
        List<Movie> movies = new ArrayList<>();
        if (startYear <= endYear) {
            for (int i = startYear; i <= endYear; ++i){
                movies.addAll(movieRepository.findMoviesByReleaseTime(String.valueOf(i)));
            }
        }
        /*
        Collections.sort(movies, new Comparator<Movie>(){
            public int compare(Movie m1, Movie m2){
                return m2.getRate() - m1.getRate() > 0 ? 1 : m2.getRate() - m1.getRate() == 0 ? 0 : -1;
            }
        });*/
        movieListSort.sort(movies, "get" + sort, "desc");
        return new ResJsonTemplate<>("200", movies);
    }

    @Override
    public ResJsonTemplate searchMovieByMonth(String tag, String sort){
        String year = tag.split("-")[0];
        int startMonth = Integer.parseInt(tag.split("-")[1]);
        int endMonth = Integer.parseInt(tag.split("-")[2]);
        List<Movie> movies = new ArrayList<>();
        if (startMonth <= endMonth) {
            for (int i = startMonth; i <= endMonth; ++i){
                movies.addAll(movieRepository.findMoviesByReleaseTime(year + "-" + String.valueOf(i)));
            }
        }
        movieListSort.sort(movies, "get" + sort, "desc");
        return new ResJsonTemplate<>("200", movies);
    }

    @Override
    public ResJsonTemplate searchMovieByLanguage(String tag, String sort){
        List<Movie> movies = movieRepository.findMoviesByMovieLanguage(tag);
        movieListSort.sort(movies, "get" + sort, "desc");
        return new ResJsonTemplate<>("200", movies);
    }

}
