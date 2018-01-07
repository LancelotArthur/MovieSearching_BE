package com.example.tjmovie.service.impl;

import com.example.tjmovie.dto.ActorNumber;
import com.example.tjmovie.mysqlentity.MovieDvd;
import com.example.tjmovie.mysqlrepository.*;
import com.example.tjmovie.service.MovieService;
import com.example.tjmovie.util.ResJsonTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.*;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieDvdRepository movieDvdRepository;

    @Autowired
    private MovieCdRepository movieCdRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private DirectorRepository directorRepository;

    @Override
    public ResJsonTemplate findDVDsByYear(String tag) {
        int year = Integer.parseInt(tag);
        long startTime = System.currentTimeMillis();
        int i = movieDvdRepository.findMovieDvdsByYear2(year) + movieCdRepository.findMoviecdsByYear2(year);
        long endTime = System.currentTimeMillis();
        long runTime = endTime - startTime;
        List<Long> longs = new ArrayList<>();
        longs.add(runTime);
        longs.add(new Long(i));
        return new ResJsonTemplate<>("200", longs);
    }

    @Override
    public ResJsonTemplate findDVDsByYearAndMonth(String tag) {
        int year = Integer.parseInt(tag.split("-")[0]);
        int month = Integer.parseInt(tag.split("-")[1]);
        long startTime = System.currentTimeMillis();
        int i = movieDvdRepository.findMovieDvdsByYearAndMonth(year, month) + movieCdRepository.findMoviecdsByYearAndMonth(year, month);
        long endTime = System.currentTimeMillis();
        long runTime = endTime - startTime;
        List<Long> longs = new ArrayList<>();
        longs.add(runTime);
        longs.add(new Long(i));
        return new ResJsonTemplate<>("200", longs);
    }

    @Override
    public ResJsonTemplate findDVDsByYearAndSeason(String tag) {
        int year = Integer.parseInt(tag.split("-")[0]);
        int season = Integer.parseInt(tag.split("-")[1]);
        long startTime = System.currentTimeMillis();
        int i = movieDvdRepository.findMovieDvdsByYearAndSeason(year, season) + movieCdRepository.findMoviecdsByYearAndSeason(year, season);
        long endTime = System.currentTimeMillis();
        long runTime = endTime - startTime;
        List<Long> longs = new ArrayList<>();
        longs.add(runTime);
        longs.add(new Long(i));
        return new ResJsonTemplate<>("200", longs);
    }

    @Override
    public ResJsonTemplate findDVDsByWeekday(String tag) {
        int weekday = Integer.parseInt(tag);
        long startTime = System.currentTimeMillis();
        int i = movieDvdRepository.findMovieDvdsByWeekday(weekday) + movieCdRepository.findMoviecdsByWeekday(weekday);
        long endTime = System.currentTimeMillis();
        long runTime = endTime - startTime;
        List<Long> longs = new ArrayList<>();
        longs.add(runTime);
        longs.add(new Long(i));
        return new ResJsonTemplate<>("200", longs);
    }

    @Override
    public ResJsonTemplate findBanbensByName(String movie) {
        long startTime = System.currentTimeMillis();
        int i = movieDvdRepository.findBanbensByName(movie) + movieCdRepository.findBanbensByName(movie);
        long endTime = System.currentTimeMillis();
        long runTime = endTime - startTime;
        List<Long> longs = new ArrayList<>();
        longs.add(runTime);
        longs.add(new Long(i));
        return new ResJsonTemplate<>("200", longs);
    }

    @Override
    public ResJsonTemplate findMoviesByGenre(String tag) {
        long startTime = System.currentTimeMillis();
        int i = genreRepository.findMoviesByGenre(tag);
        long endTime = System.currentTimeMillis();
        long runTime = endTime - startTime;
        List<Long> longs = new ArrayList<>();
        longs.add(runTime);
        longs.add(new Long(i));
        return new ResJsonTemplate<>("200", longs);
    }

    @Override
    public ResJsonTemplate findMoviesByActor(String tag) {
        long startTime = System.currentTimeMillis();
        int i = actorRepository.findMoviesByActor(tag);
        long endTime = System.currentTimeMillis();
        long runTime = endTime - startTime;
        List<Long> longs = new ArrayList<>();
        longs.add(runTime);
        longs.add(new Long(i));
        return new ResJsonTemplate<>("200", longs);
    }

    @Override
    public ResJsonTemplate findMoviesByDirector(String tag) {
        long startTime = System.currentTimeMillis();
        int i = directorRepository.findMoviesByDirector(tag);
        long endTime = System.currentTimeMillis();
        long runTime = endTime - startTime;
        List<Long> longs = new ArrayList<>();
        longs.add(runTime);
        longs.add(new Long(i));
        return new ResJsonTemplate<>("200", longs);
    }

    @Override
    public ResJsonTemplate findActorsByDirector(String tag) {
        long startTime = System.currentTimeMillis();
        List<String> actorNumberList = directorRepository.findActorsByDirector(tag);
        long endTime = System.currentTimeMillis();
        long runTime = endTime - startTime;
        //actorNumberList.add(new ActorNumber("xxx", new Long(runTime).intValue(), "xxx"));
        actorNumberList.add("time : " + runTime);
        return new ResJsonTemplate<>("200", actorNumberList);
    }
}
