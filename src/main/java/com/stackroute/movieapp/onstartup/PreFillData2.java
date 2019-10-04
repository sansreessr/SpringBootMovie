package com.stackroute.movieapp.onstartup;

import com.stackroute.movieapp.domain.Movie;
import com.stackroute.movieapp.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PreFillData2 implements CommandLineRunner {

    private MovieRepository movieRepository;

    @Autowired
    public PreFillData2(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        movieRepository.save(new Movie(2,"Once Upon A Time In Hollywood", "English", "Drama", "11 Aug 2019", 8.7, 21431));
    }
}