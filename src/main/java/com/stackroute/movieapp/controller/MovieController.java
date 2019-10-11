package com.stackroute.movieapp.controller;


import com.stackroute.movieapp.domain.Movie;
import com.stackroute.movieapp.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieapp.exceptions.MovieNotFoundException;
import com.stackroute.movieapp.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/")
public class MovieController {

    private MovieService movieService;
    ResponseEntity<?> responseEntity;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("movie")
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie) throws MovieAlreadyExistsException {
        movieService.saveMovie(movie);
        return new ResponseEntity<String>("Successfully added", HttpStatus.CREATED);
    }

    @GetMapping("movies")
    public ResponseEntity<?> getAllMovies() throws MovieNotFoundException {
        return new ResponseEntity<List<Movie>>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @DeleteMapping("movie/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable int id) throws MovieNotFoundException{
        return new ResponseEntity<Movie>(movieService.deleteMovieById(id), HttpStatus.OK);
    }

    @PutMapping("movie/{id}")
    public ResponseEntity<?> updateMovie(@RequestBody Movie movie, @PathVariable int id) throws MovieNotFoundException {
        movieService.updateMovie(movie, id);
        return new ResponseEntity<String>("Successfully updated", HttpStatus.CREATED);
    }

    @GetMapping("movies/movieName={movieName}")
    public ResponseEntity<?> movieByName(@PathVariable String movieName) throws MovieNotFoundException {
        return new ResponseEntity<List<Movie>>(movieService.movieByName(movieName), HttpStatus.OK);
    }
}
