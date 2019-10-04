package com.stackroute.movieapp.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Arrays;

@Entity
public class Movie {

    @Id
    private int movieId;
    private String movieName;
    private String language;
    private String genres;
    private String releaseDate;
    private Double rating;
    private long voteCount;

    public Movie() {
    }

    public Movie(int movieId, String movieName, String language, String genres, String releaseDate, Double rating, long voteCount) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.language = language;
        this.genres = genres;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.voteCount = voteCount;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", language='" + language + '\'' +
                ", genres='" + genres + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", rating=" + rating +
                ", voteCount=" + voteCount +
                '}';
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public long getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(long voteCount) {
        this.voteCount = voteCount;
    }
}
