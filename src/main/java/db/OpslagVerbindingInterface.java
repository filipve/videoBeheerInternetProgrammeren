package db;

import domain.Movie;
import domain.person.Actor;

import java.util.List;

/**
 * Created by filip on 18/02/2016.
 */
public interface OpslagVerbindingInterface {

    /**
     * CRUD ==> READ
     *
     */

    /**
     * @return een lijst van alle films in de collectie
     */
    public List<Movie> getAllMovies();

    /**
     * @param movie
     * @return
     */
    public List<Actor> getAllActorsFromOneMovie(Movie movie);

    public List<Actor> getAllActors();

    /**
     *
     * @param genre
     * @return
     */
    //public List<Movie> getAllMoviesFromGenre(MovieGenre genre);

    /**
     *
     * @param movieGenres
     * @return
     */
    //public List<Movie> getAllMoviesFromMultipleGenres(List<MovieGenre> movieGenres);


    //public List<Actor> getAllMaleActors();

    //public List<Actor> getAllFemaleActors();


    /**
     * Voegt een film toe aan de collectie
     * CRUD ==> create
     *
     * @param movie
     */
    public void addMovie(Movie movie);

    /**
     * CRUD ==> read
     */
    public Movie getMovie(String naam, int jaar);

    public Movie getMovieById(int id);

    /**
     * CRUD ==> update
     */
    public void updateMovie(Movie movie, Movie oldMovie);

    /**
     * CRUD ==> delete
     */
    public void deleteMovie(Movie movie);

    /**
    * CRUD ==> create
    */

    /**
     * Voegt een acteur toe aan een film waarin hij meegespeeld heeft.
     *
     * @param actor
     * @param movie
     */
    public void addActor(Actor actor, Movie movie);

    /**
     * Voegt een actor toe aan de collectie
     *
     * @param actor
     */
    public void addActor(Actor actor);

    /**
     * CRUD ==> read
     */
    public Actor getActor(String voornaam, String familieNaam);


    public void updateActor(Actor actor, Actor oldActor);

    /**
     * CRUD ==> delete
    */
    public void deleteActor(Actor actor);
}