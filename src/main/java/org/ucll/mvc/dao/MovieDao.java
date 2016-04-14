package org.ucll.mvc.dao;

import domain.Movie;
import helperclasses.MovieEvaluation;
import helperclasses.MovieGenre;
import helperclasses.MovieRating;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by filip on 21/03/2016.
 */
public class MovieDao {

    private List<Movie> movieList;

    public List<Movie> getMovieList() {
        Movie movie1 = new Movie("The Lord of The Rings, The Fellowship of the ring",
                "Peter Jackson",2001, MovieGenre.ACTION,
                MovieRating.GENERALAUDIENCE, MovieEvaluation.FIVESTARS,true);
        Movie movie2 = new Movie("The Lord of The Rings, The return of the king",
                "Peter Jackson",2003, MovieGenre.ACTION,
                MovieRating.GENERALAUDIENCE, MovieEvaluation.FIVESTARS,true);

        movieList = new ArrayList<Movie>();
        movieList.add(movie1);
        movieList.add(movie2);

        return movieList;
    }

}
