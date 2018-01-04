package com.example.tjmovie.service.impl;

import com.example.tjmovie.entity.*;
import com.example.tjmovie.repository.*;
import com.example.tjmovie.service.CelebrityService;
import com.example.tjmovie.util.ResJsonTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;


@Service
@Transactional
public class CelebrityServiceImpl implements CelebrityService {

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


    @Override
    public ResJsonTemplate findMoviesOfCelebrity(String cbId){
        boolean isActor, isWriter, isDirector, isProducer;
        List<Actor> actorList;
        List<Writer> writerList;
        List<Director> directorList;
        List<Producer> producerList;
        IdentityHashMap<String, List> takepart = new IdentityHashMap<>();
        List<Movie> am = new ArrayList<>();
        List<Movie> wm = new ArrayList<>();
        List<Movie> dm = new ArrayList<>();
        List<Movie> pm = new ArrayList<>();
        Celebrity celebrity = celebrityRepository.findCelebrityById(cbId);
        if (celebrity == null)
            return new ResJsonTemplate<>("503", "资源不存在");
        isActor = celebrity.isActor();
        isWriter = celebrity.isWriter();
        isDirector = celebrity.isDirector();
        isProducer = celebrity.isProducer();
        if (isActor) {
            actorList = actorRepository.findActorsByCbId(cbId);
            for (Actor a : actorList){
                am.add(movieRepository.findMovieById(a.getMovieId()));
            }
            takepart.put("Actors", am);
        }
        if (isDirector){
            directorList = directorRepository.findDirectorsByCbId(cbId);
            for (Director d : directorList){
                dm.add(movieRepository.findMovieById(d.getMovieId()));
            }
            takepart.put("Directors", dm);
        }
        if (isProducer){
            producerList = producerRepository.findProducersByCbId(cbId);
            for (Producer p : producerList){
                pm.add(movieRepository.findMovieById(p.getMovieId()));
            }
            takepart.put("Producers", pm);
        }
        if (isWriter){
            writerList = writerRepository.findWritersByCbId(cbId);
            for (Writer w : writerList){
                wm.add(movieRepository.findMovieById(w.getMovieId()));
            }
            takepart.put("Writers", wm);
        }

        return new ResJsonTemplate<>("200", takepart);
    }

    @Override
    public ResJsonTemplate findCelebrity(String cbId){
        Celebrity celebrity = celebrityRepository.findCelebrityById(cbId);
        return new ResJsonTemplate<>("200", celebrity);
    }

}
