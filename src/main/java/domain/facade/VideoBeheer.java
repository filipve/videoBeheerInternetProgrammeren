package domain.facade;

import db.OpslagVerbindingInterface;
import domain.Movie;
import domain.factory.DatabaseFactory;
import domain.factory.DatabaseType;
import domain.person.Actor;

import java.util.List;

/**
 * Created by filip on 18/02/2016.
 * <p>
 * Dit is mijn facade klasse.
 * <p>
 * Hier moeten alle methodes gebruikt worden om te linken met andere klassen.
 */
public class VideoBeheer {

    //private List<Movie> movies;
    //private List<Actor> actors;


    private OpslagVerbindingInterface videoBeheerDb;
    private DatabaseFactory dbFactory;

    public VideoBeheer() {
        //dbFactory = new DatabaseFactory();

        /*
        Dit is de oude versie, de versie eronder is gemaakt met strategy pattern.
        Door dat in de klasse DatabaseFactory er gewerkt wordt met een create-methode en als type een enum waarde, maken we een nieuw object aan
        door middel van de enum waarde.
        Dus door DatabaseType.FAKE mee te geven als parameter zeg je dat de klasse videoBeheerDb moet worden gebruikt.

        Wil je veranderen van klasse, dan verander je het type gewoon, en wordt een andere klasse gebruikt.
        */
        //videoBeheerDb = new VideoBeheerDbFake();

        //videoBeheerDb = dbFactory.create(DatabaseType.FAKE);

        //static aangeroepen
videoBeheerDb = DatabaseFactory.create(DatabaseType.FAKE);

        //this.movies = new ArrayList<Movie>();
        //this.actors = new ArrayList<Actor>();
    }

    public DatabaseFactory getDbFactory() {
        return dbFactory;
    }

    public void setDbFactory(DatabaseFactory dbFactory) {
        this.dbFactory = dbFactory;
    }

    /**
     * Hier komt alles van de klasse Movie
     */

    public List<Movie> getAllMovies() {
            return getVideoBeheerDb().getAllMovies();
    }

    /**
     * Hier wordt een lijst opgehaald uit de DB klasse.
     *
     * @return een lijst van alle actors die meespelen in 1 film
     */
    public List<Actor> getAllActorsFromOneMovie(Movie movie) {
        return getVideoBeheerDb().getAllActorsFromOneMovie(movie);
    }

    public List<Actor> getAllActors() {
        return getVideoBeheerDb().getAllActors();
    }


/* Later Implementeren, is optioneel

    public List<Movie> generateListOfMoviesAlreadySeen() {

        List<Movie> moviesSeen = new ArrayList<Movie>();

        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).isSeen()) {
                moviesSeen.add(movies.get(i));
            }

        }

        return moviesSeen;
    }
*/
    /* Later Implementeren, is optioneel

    public List<Movie> generateListOfMoviesNotSeen() {
        List<Movie> moviesNotSeen = new ArrayList<Movie>();

        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).isSeen() == false) {
                moviesNotSeen.add(movies.get(i));
            }
        }

        return moviesNotSeen;
    }
*/

    /* Later Implementeren, is optioneel

    public List<Movie> getActorfromMovies(Actor actor) {
        return actor.getMoviesPlayedIn();
    }
*/

    /**
     * CRUD ==> create
     */
    public void addMovie(Movie movie) {
        getVideoBeheerDb().addMovie(movie);
    }

    /**
     * CRUD ==> read
     */
    public Movie getMovie(String naam, int jaar) {
        return getVideoBeheerDb().getMovie(naam, jaar);
    }

    /**
     * CRUD ==> update
     */
    public void updateMovie(Movie movie, Movie oldMovie) {
        getVideoBeheerDb().updateMovie(movie, oldMovie);
    }

    /**
     * CRUD ==> delete
     */
    public void deleteMovie(Movie movie) {
        getVideoBeheerDb().deleteMovie(movie);
    }

    /**
     * CRUD ==> create
     */
    public void addActor(Actor actor) {
        getVideoBeheerDb().addActor(actor);
    }

    /**
     * CRUD ==> create 2
     */
    public void addActor(Actor actor, Movie movie) {
        getVideoBeheerDb().addActor(actor, movie);
    }

    /**
     * CRUD ==> read
     */
    public Actor getActor(String voornaam, String familieNaam) {
        return getVideoBeheerDb().getActor(voornaam, familieNaam);
    }

    /**
     * CRUD ==> update
     */
    public void updateActor(Actor actor, Actor oldActor) {
        getVideoBeheerDb().updateActor(actor, oldActor);
    }

    /**
     * CRUD ==> delete
     */
    public void deleteActor(Actor actor) {
        getVideoBeheerDb().deleteActor(actor);

    }


    public OpslagVerbindingInterface getVideoBeheerDb() {
        return videoBeheerDb;
    }

    public void setVideoBeheerDb(OpslagVerbindingInterface videoBeheerDb) {
        this.videoBeheerDb = videoBeheerDb;
    }
}