package db;

import domain.Movie;
import domain.person.Actor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by filip on 18/02/2016.
 */
public class VideoBeheerDbFake implements OpslagVerbindingInterface {

    //SOLVED interface maken met alleen methodes, en dan de klassen daaraan linken

    //Solved door 2 maps te gebruiken: db klassen opsplitsen voor actors en movies

    private static int instanceCounterMovies = 0;
    private static int instanceCounterActors = 0;
    //Solved static maken
    Map<Integer, Movie> beheer;
    Map<Integer, Actor> actors;
    private int counterMovies = 0;
    private int counterActors = 0;


    public VideoBeheerDbFake() {
        beheer = new HashMap<Integer, Movie>();
        actors = new HashMap<Integer, Actor>();
    }

    public List<Movie> getAllMovies() {
        List<Movie> lijstfilms = new ArrayList<Movie>(beheer.values());
        return lijstfilms;
    }


    public List<Actor> getAllActorsFromOneMovie(Movie movie) {
        return movie.getActors();
    }

    public List<Actor> getAllActors(){
        return new ArrayList<Actor>(actors.values());
    }

    /* Later Implementeren, is optioneel
    public List<Movie> getAllMoviesFromGenre(MovieGenre genre) {
        List<Movie> movies = new ArrayList<Movie>();
        for (Movie movie : beheer.values()) {

            if (movie.getGenre() == genre) {
                movies.add(movie);
            }

        }
        return movies;
    }

*/

/* Later Implementeren, is optioneel

    public List<Movie> getAllMoviesFromMultipleGenres(List<MovieGenre> movieGenres) {
        return null;
    }
*/

    /* Later Implementeren, is optioneel

    public List<Actor> getAllMaleActors() {
        List<Actor> actors = new ArrayList<Actor>();
        //for(Actor actor : beheer.values()){

        //}

        return actors;
    }

    */

    /* Later Implementeren, is optioneel

    public List<Actor> getAllFemaleActors() {
        return null;
    }
*/


    /**
     * CRUD ==> create
     */
    public void addMovie(Movie movie) {

        instanceCounterMovies++;
        counterMovies = instanceCounterMovies;

        //rekening houden met unieke variabelen voor remove update
        //int maxkey = Collections.max(beheer.keySet());

        //beheer.put(maxkey + 1, movie);
        movie.setId(counterMovies);
        beheer.put(counterMovies, movie);

    }

    /**
     * CRUD ==> read
     */
    public Movie getMovie(String naam, int jaar) {
        Movie returnMovie = null;

        for (Movie movie : beheer.values()) {
            if (movie.getJaar() == jaar && movie.getTitle() == naam) {
                return movie;
            }
        }

        return returnMovie;
    }

    public Movie getMovieById(int id) {
        Movie returnMovie = null;

        for (Movie movie : beheer.values()) {
            if (movie.getId() == id) {
                return movie;
            }
        }

        return returnMovie;
    }


    /**
     * CRUD ==> update
     */
    public void updateMovie(Movie movie, Movie oldMovie) {
        beheer.put(oldMovie.getId(), movie);
    }

    /**
     * CRUD ==> delete
     */
    public void deleteMovie(Movie movie) {
        beheer.remove(movie.getId());
    }

    /**
     * CRUD ==> create
     */
    public void addActor(Actor actor) {
        instanceCounterActors++;
        counterActors = instanceCounterActors;

        actor.setId(counterActors);
        actors.put(counterActors, actor);
    }

    /**
     * CRUD ==> create 2
     */
    public void addActor(Actor actor, Movie movie) {

        List<Actor> actorsInMovie = movie.getActors();
        actorsInMovie.add(actor);
        movie.setActors(actorsInMovie);

    }

    /**
     * CRUD ==> read
     */
    public Actor getActor(String voornaam, String familieNaam) {

        for (Actor act : actors.values()) {
            System.out.println("act familyname == : " + act.getFamilyName() + " voornaam " + act.getName() );
            if (act.getName() == voornaam && act.getFamilyName() == familieNaam) {
                return act;
            }
        }

        return null;
    }

    /**
     * CRUD ==> update
     */
    public void updateActor(Actor actor, Actor oldActor) {
        actors.put(oldActor.getId(), actor);
    }

    /**
     * CRUD ==> delete
     */
    public void deleteActor(Actor actor) {
        actors.remove(actor.getId());
    }


}
