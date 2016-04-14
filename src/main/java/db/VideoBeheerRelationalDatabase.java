package db;

import domain.Movie;
import domain.person.Actor;
import domain.person.GenderPerson;
import helperclasses.MovieEvaluation;
import helperclasses.MovieGenre;
import helperclasses.MovieRating;
import org.eclipse.persistence.exceptions.DatabaseException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by filip on 18/02/2016.
 */

public class VideoBeheerRelationalDatabase implements OpslagVerbindingInterface {


    private static int instanceCounterMovies = 0;
    private static int instanceCounterActors = 0;
    //Solved static maken
    Map<Integer, Movie> beheer;
    Map<Integer, Actor> actors;
    private EntityManagerFactory factory;

    //SOLVED interface maken met alleen methodes, en dan de klassen daaraan linken

    //Solved door 2 maps te gebruiken: db klassen opsplitsen voor actors en movies
    private EntityManager manager;
    private String name = "videobeheer";
    private int counterMovies = 0;
    private int counterActors = 0;

    public VideoBeheerRelationalDatabase() {
        beheer = new HashMap<Integer, Movie>();
        actors = new HashMap<Integer, Actor>();

    }



    public void openConnection() {

        factory = Persistence.createEntityManagerFactory(name);
        /*
       manager ==> Does all the work
        */
        manager = factory.createEntityManager();

    }

    public void closeConnection() throws DBException {
        try {
            manager.close();
            factory.close();
        } catch (Exception e) {
            throw new DBException(e.getMessage(), e);
        }
    }

    public List<Movie> getAllMovies() {
        try {
            openConnection();

            Query query = manager.createQuery("Select mov from Movie mov");


            List<Movie> movies = query.getResultList();
            //closeConnection();
            return movies;
        } catch (Exception e) {
//throw new DatabaseException(e.getMessage(),e);
            throw new DBException(e.getMessage(), e);

        }

    }


    public List<Actor> getAllActorsFromOneMovie(Movie movie) {
        return movie.getActors();
    }

    public List<Actor> getAllActors() {
        try {
            openConnection();

            Query query = manager.createQuery("select act from Actor act");
            List<Actor> actors = query.getResultList();
            return actors;
        } catch (Exception e) {
            throw new DBException(e.getMessage(), e);
        }


    }


    /**
     * CRUD ==> create
     */
    public void addMovie(Movie movie) {

        openConnection();

        manager.getTransaction().begin();
        manager.persist(movie);
        manager.flush();
        manager.getTransaction().commit();
        closeConnection();
    }

    /**
     * CRUD ==> read
     */
    public Movie getMovie(String naam, int jaar) {

        openConnection();
        manager.getTransaction().begin();
        Movie returnMovie = null;

        for (Movie movie : beheer.values()) {
            if (movie.getJaar() == jaar && movie.getTitle() == naam) {
                return movie;
            }
        }

        return returnMovie;
    }

    public Movie getMovieById(int id) {

        try {
            openConnection();

            //String sql = "Select mov from Movie mov where mov.id=id";
            /*Query query = manager.createQuery(sql);*/
            Movie movie = manager.find(Movie.class, id);


            return movie;
        } catch (Exception e) {
//throw new DatabaseException(e.getMessage(),e);
            throw new DBException(e.getMessage(), e);

        }

    }

    /**
     * CRUD ==> update
     */
    public void updateMovie(Movie movie, Movie oldMovie) {
        beheer.put(oldMovie.getId(), movie);
    }



    /*
    JPA exposes two methods... persist() and merge()

    Persist: Persist is responsible for inserting new rows to DB and then associating the Entity with state in JPA session.

    Merge: Merge takes existing Entity and updates the DB row. It also updates the state of the entity in JPA session.

    ------------------------

    EntityManager.persist() is used to create a new entity bean.

Creating a new entity bean involves inserting a new row in the database.

You use EntityManager.merge() to update an entity bean that already exists.

Calling EntityManager.merge() updates the database to reflect changes made to a detached entity bean.

If your entity bean is not detached, there's no need to invoke merge().

If your user bean is not detached, you can simply modify its properties by calling methods like setLoginAttempts().

The EntityManager and container will update the database automatically (when the transaction is committed).
     */

    public void updateMovie(Movie movie, int id) {

        //Movie oldMovie = manager.find(Movie.class,id);

        openConnection();
        manager.getTransaction().begin();
/*
        oldMovie.setTitle(movie.getTitle());
        oldMovie.setDirector(movie.getDirector());
        oldMovie.setJaar(movie.getJaar());
        oldMovie.setGenre(movie.getGenre());
        oldMovie.setRating(movie.getRating());
        oldMovie.setEvaluation(movie.getEvaluation());
        oldMovie.setSeen(movie.isSeen());
*/
        //manager.merge(oldMovie);
        manager.merge(movie);
        //manager.flush();
        manager.getTransaction().commit();
        closeConnection();
    }

    /**
     * CRUD ==> delete
     */
    public void deleteMovie(Movie movie) {
        beheer.remove(movie.getId());
    }

    public void deleteMovieById(int id) {

        openConnection();

        manager.getTransaction().begin();
        Movie movie = manager.find(Movie.class, id);
        manager.remove(movie);
        manager.getTransaction().commit();
        closeConnection();
    }

    /**
     * CRUD ==> create
     */
    public void addActor(Actor actor) {

        /*
        instanceCounterActors++;
        counterActors = instanceCounterActors;

        actor.setId(counterActors);
        actors.put(counterActors, actor);

        */

        openConnection();

        manager.getTransaction().begin();

        //Actor actor1 = manager.find(Actor.class,actor.getId());

        manager.persist(actor);
        manager.flush();
        manager.getTransaction().commit();
        closeConnection();
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
            System.out.println("act familyname == : " + act.getFamilyName() + " voornaam " + act.getName());
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
