package com.cry.movie.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.cry.movie.data.QueryReviewByCondReq;
import com.cry.movie.entity.Review;

public interface ReviewMapper {

    @Select({
        "<script>",
        "select * from t_review where 1=1",
        "<if test='movie.id!=null'>",
        "and movie_id=#{movie.id}",
        "</if>",
        "<if test='user.id!=null'>",
        "and user_id=#{user.id}",
        "</if>",
        "</script>" 
    }) 
    public List < Review > queryReviewByCond(QueryReviewByCondReq req);
    
    @Select({
        "<script>",
        "select count(*) from t_review where 1=1",
        "<if test='movie.id!=null'>",
        "and movie_id=#{movie.id}",
        "</if>",
        "<if test='user.id!=null'>",
        "and user_id=#{user.id}",
        "</if>",
        "</script>" 
    }) 
    public int queryReviewNum(QueryReviewByCondReq req);
    
    @Insert("insert into t_review (user_id,user_name,movie_id,movie_name,score,review,create_time) values (#{userId},#{userName},#{movieId},#{movieName},#{score},#{review},#{createTime})")
    public void addReview(Review review);
   
}
