package com.cry.movie.service;

import java.util.List;

import com.cry.movie.data.QueryReviewByCondReq;
import com.cry.movie.entity.Review;

public interface ReviewService {

    List < Review > queryReviewByCond(QueryReviewByCondReq req);

    int queryReviewNum(QueryReviewByCondReq req);

    public void addReview(Review review);
}