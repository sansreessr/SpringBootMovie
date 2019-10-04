package com.stackroute.movieapp.controller;


import com.stackroute.movieapp.domain.Movie;
import com.stackroute.movieapp.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieapp.exceptions.MovieNotFoundException;
import com.stackroute.movieapp.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/")
public class MovieController {
    @Autowired
    MovieService movieService;

    @Autowired
    @Qualifier("qualifier")
    MovieService movieService2;

    public MovieController(MovieService movieService, MovieService movieService2) {
        this.movieService = movieService;
        this.movieService2 = movieService2;
    }

    @PostMapping("movie")
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie) throws MovieAlreadyExistsException {
        ResponseEntity responseEntity;
        movieService.saveMovie(movie);
        return new ResponseEntity<String>("Successfully added", HttpStatus.CREATED);
    }

    @GetMapping("movie")
    public ResponseEntity<?> getAllMovies() throws MovieNotFoundException {
        ResponseEntity responseEntity;
        return new ResponseEntity<List<Movie>>(movieService2.getAllMovies(), HttpStatus.OK);
    }

    @DeleteMapping("movie/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable int id) throws MovieNotFoundException{
        ResponseEntity responseEntity;
        movieService.deleteMovie(id);
        return new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);
    }

    @PutMapping("movie/{id}")
    public ResponseEntity<?> updateMovie(@RequestBody Movie movie, @PathVariable int id) throws MovieNotFoundException {
        ResponseEntity responseEntity;
        movieService.updateMovie(movie, id);
        return new ResponseEntity<String>("Successfully updated", HttpStatus.CREATED);
    }

    @GetMapping("movie/movieName={movieName}")
    public ResponseEntity<?> movieByName(@PathVariable String movieName) throws MovieNotFoundException {
        ResponseEntity responseEntity;
        return new ResponseEntity<List<Movie>>(movieService.movieByName(movieName), HttpStatus.OK);
    }
}
