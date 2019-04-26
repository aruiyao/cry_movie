package com.cry.movie.service;

import java.util.List;

import com.cry.movie.entity.Movie;

public interface MovieService {

    List < Movie > queryAllMovies();

    List<Movie> queryMovieByCond(Movie movie);
    
    void updateMovieById(Movie movie);

}