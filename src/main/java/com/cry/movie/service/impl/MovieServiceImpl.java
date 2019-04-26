package com.cry.movie.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cry.movie.entity.Movie;
import com.cry.movie.mapper.MovieMapper;
import com.cry.movie.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieMapper movieMapper;

    @Override
    public List < Movie > queryAllMovies() {
        return movieMapper.queryAllMovies();
    }

    @Override
    public List < Movie > queryMovieByCond(Movie movie) {
        return movieMapper.queryMovieByCond(movie);
    }

    @Override
    public void updateMovieById(Movie movie) {
        movieMapper.updateMovieById(movie);
    }

}
