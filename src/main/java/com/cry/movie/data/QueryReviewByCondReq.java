package com.cry.movie.data;

import com.cry.movie.entity.Movie;
import com.cry.movie.entity.User;

public class QueryReviewByCondReq {
    private Movie movie;

    private User user;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("QueryReviewByCondReq [movie=");
        builder.append(movie);
        builder.append(", user=");
        builder.append(user);
        builder.append("]");
        return builder.toString();
    }

}
