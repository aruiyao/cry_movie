package com.cry.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cry.movie.data.QueryMovieListResp;
import com.cry.movie.entity.Movie;
import com.cry.movie.service.MovieService;

@Controller
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping(value = "/queryAllMovies")
    @ResponseBody
    public QueryMovieListResp queryAllMovies() {
        QueryMovieListResp rsp = new QueryMovieListResp();
        List < Movie > movieList = movieService.queryAllMovies();
        rsp.setMovieList(movieList);
        return rsp;
    }

    @GetMapping(value = "/queryMovieByCond")
    @ResponseBody
    public QueryMovieListResp queryMovieByCond(Movie movie) {
        QueryMovieListResp rsp = new QueryMovieListResp();
        List < Movie > movieList = movieService.queryMovieByCond(movie);
        rsp.setMovieList(movieList);
        return rsp;
    }

}
