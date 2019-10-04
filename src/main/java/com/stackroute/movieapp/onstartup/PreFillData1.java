/*package com.stackroute.movieapp.onstartup;

import com.stackroute.movieapp.domain.Movie;
import com.stackroute.movieapp.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class PreFillData1 implements ApplicationListener<ContextRefreshedEvent> {

    private MovieRepository movieRepository;

    @Autowired
    public PreFillData1(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Movie movie = new Movie(1,"Joker","English","Fiction","3 Oct 2019",9.2,21312);
        movieRepository.save(movie);
    }
}*/
