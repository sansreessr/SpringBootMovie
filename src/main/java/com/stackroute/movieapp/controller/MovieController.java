package com.stackroute.movieapp.controller;


import com.stackroute.movieapp.domain.Movie;
import com.stackroute.movieapp.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieapp.exceptions.MovieNotFoundException;
import com.stackroute.movieapp.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/")
public class MovieController {

    MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
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
        return new ResponseEntity<List<Movie>>(movieService.getAllMovies(), HttpStatus.OK);
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
