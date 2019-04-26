package com.cry.movie.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cry.movie.entity.Movie;

public interface MovieMapper {
    @Select("select * from t_movie")
    public List<Movie> queryAllMovies();
    
    @Select({
        "<script>",
        "select * from t_movie where 1=1",
        "<if test='id!=null and id!=\"\"'>",
        "and id=#{id}",
        "</if>",
        "<if test='type!=null and type!=\"\"'>",
        "and type=#{type}",
        "</if>",
        "</script>" 
    })
    public List<Movie> queryMovieByCond(Movie movie);
    
    
    @Update({
        "<script>",
        "update t_movie",
        "<set>",
            "<if test='name!=null'>",
            "name=#{name},", 
            "</if>",
            "<if test='picture!=null'>",
            "picture=#{picture},",
            "</if>",
            "<if test='score!=null'>",
            "score=#{score},",
            "</if>",
            "<if test='director!=null'>",
            "director=#{director},",
            "</if>",
            "<if test='leadRole!=null'>",
            "lead_role=#{leadRole},",
            "</if>",
            "<if test='type!=null'>",
            "type=#{type},",
            "</if>",
            "<if test='screenwriter!=null'>",
            "screenwriter=#{screenwriter},",
            "</if>",
            "<if test='filmLength!=null'>",
            "film_length=#{filmLength},",
            "</if>",
            "<if test='alias!=null'>",
            "alias=#{alias},",
            "</if>",
            "<if test='synopsis!=null'>",
            "synopsis=#{synopsis},",
            "</if>",
        "</set>",
        "where id=#{id}",
        "</script>" 
    })
    public void updateMovieById(Movie movie);
}
