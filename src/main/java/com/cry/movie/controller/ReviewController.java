package com.cry.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cry.movie.data.QueryReviewByCondReq;
import com.cry.movie.data.QueryReviewByCondResp;
import com.cry.movie.entity.Movie;
import com.cry.movie.entity.Review;
import com.cry.movie.entity.User;
import com.cry.movie.service.MovieService;
import com.cry.movie.service.ReviewService;

@Controller
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @Autowired
    private MovieService movieService;

    @PostMapping(value = "/queryReviewByCond")
    @ResponseBody
    public QueryReviewByCondResp queryReviewByCond(@RequestBody QueryReviewByCondReq req) {
        System.out.println(req);
        QueryReviewByCondResp resp = new QueryReviewByCondResp();
        List < Review > reviewList = reviewService.queryReviewByCond(req);
        int total = reviewService.queryReviewNum(req);
        resp.setReviewList(reviewList);
        resp.setTotal(total);
        return resp;
    }

    @PostMapping(value = "/addReview")
    @ResponseBody
    public void addReview(@RequestBody Review review) {
        reviewService.addReview(review);
        QueryReviewByCondReq req = new QueryReviewByCondReq(); 
        Movie movie = new Movie();
        User user = new User();
        movie.setId(review.getMovieId());
        req.setMovie(movie);
        req.setUser(user);
        Double totalScore = 0.0;
        Double score = 0.0;
        List < Review > reviewList = reviewService.queryReviewByCond(req);
        for (Review eachReview : reviewList) {
            totalScore = totalScore + eachReview.getScore();
        }
        score = totalScore / reviewList.size();
        System.out.println("score=" + score);
        movie.setScore(score);
        movieService.updateMovieById(movie);
    }

}
