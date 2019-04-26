package com.cry.movie.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cry.movie.data.QueryReviewByCondReq;
import com.cry.movie.entity.Review;
import com.cry.movie.mapper.ReviewMapper;
import com.cry.movie.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewMapper reviewMapper;

    @Override
    public List < Review > queryReviewByCond(QueryReviewByCondReq req) {
        return reviewMapper.queryReviewByCond(req);
    }

    @Override
    public int queryReviewNum(QueryReviewByCondReq req) {
        return reviewMapper.queryReviewNum(req);
    }

    @Override
    public void addReview(Review review) {
        reviewMapper.addReview(review);
    }

}