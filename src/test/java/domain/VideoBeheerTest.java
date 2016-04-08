package domain;

import domain.facade.VideoBeheer;
import domain.person.Actor;
import domain.person.Age;
import domain.person.GenderPerson;
import helperclasses.MovieEvaluation;
import helperclasses.MovieGenre;
import helperclasses.MovieRating;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.Assert.assertNotEquals;

/**
 * Created by filip on 20/02/2016.
 */
public class VideoBeheerTest extends TestCase {

    private String title;
    private String director;
    private int year;
    private MovieGenre genre;
    private MovieRating rating;
    private MovieEvaluation evaluation;
    private boolean seen;
    private VideoBeheer vdb;
    private Movie movie,movie2;
    private Actor actor,actor2;

    @Before
    public void setUp() throws Exception {

        vdb = new VideoBeheer();

        title = "The Hobbit 1";
        director = "Peter Jackson";
        year = 2012;
        genre = MovieGenre.ACTION;
        rating = MovieRating.GENERALAUDIENCE;
        evaluation = MovieEvaluation.THREESTARS;
        seen = true;
        movie = new Movie(title, director, year, genre, rating, evaluation, seen);
        movie2 = new Movie("the hobbit 2","Peter Jackson", 2013,MovieGenre.COMEDY,
                MovieRating.NCSEVENTEEN,MovieEvaluation.FIVESTARS,
                false);
        //System.out.println(movie.toString());

        actor = new Actor("Ian","Mc Kellen",new Age(LocalDate.of(1939, Month.MAY,25)), GenderPerson.MALE);
        actor2 = new Actor("Martin","Freeman",new Age(LocalDate.of(1971,Month.SEPTEMBER,8)), GenderPerson.MALE);

    }

    @Test
    public void test_get_all_movies_list() throws Exception {
        addMovieTestKlasse();
        List<Movie> movieList = vdb.getAllMovies();

        /*for (int i = 0; i < movieList.size(); i++) {
            System.out.println(movieList.get(i));
        }
        */

        printResultaatLijst(movieList);

        assertEquals(1,movieList.size());
    }

    @Test
    public void test_get_all_actors_from_one_movie()throws Exception{

        movie.addActor(actor);
        movie.addActor(actor2);
        addMovieTestKlasse();
        List<Actor> actorList = vdb.getAllActorsFromOneMovie(movie);
        /*
        for(int i = 0; i < actorList.size(); i++){
            System.out.println(actorList.get(i));
        }
        */
        printResultaatLijst(actorList);
        assertEquals(2,actorList.size());
    }

    @Test
    public void test_get_all_actors_list()throws Exception{
        addActorTestKlasse();
        List<Actor> actorList = vdb.getAllActors();
        /*
        for(int i = 0; i < actorList.size(); i++){
            System.out.println(actorList.get(i));
        }
        */

        printResultaatLijst(actorList);

        assertEquals(1,actorList.size());
        //assertEquals(1,actorList.get(0).getId());
    }

    @Test
    public void test_add_movie() throws Exception {
        addMovieTestKlasse();
        assertEquals(1,vdb.getAllMovies().size());
    }

    @Test
    public void test_get_movie_met_parameters_titel_en_jaar() throws Exception {
        vdb.addMovie(movie);
        assertEquals(title,vdb.getMovie(title,year).getTitle());
        assertEquals(year,vdb.getMovie(title,year).getJaar());
    }

    @Test
public void test_update_movie() throws Exception{

        Movie movie2 = movie;
        movie2.setJaar(1993);
        vdb.updateMovie(movie2,movie);
        List<Movie> movieList = vdb.getAllMovies();
        printResultaatLijst(movieList);

        assertEquals(1993,vdb.getAllMovies().get(0).getJaar());

    }

    @Test
public void test_delete_movie() throws Exception{
        vdb.addMovie(movie);
        vdb.addMovie(movie2);
        vdb.deleteMovie(movie);
        List<Movie> movieList = vdb.getAllMovies();
        printResultaatLijst(movieList);

        assertNotEquals(1,vdb.getAllMovies().get(0).getId());
    }

    @Test
public void test_add_actor_met_parameters_actor() throws Exception{
        addActorTestKlasse();
        assertEquals(1,vdb.getAllActors().size());
    }

    @Test
public void test_add_actor_met_parameters_actor_en_movie() throws Exception{
        addMovieTestKlasse();
        System.out.println("aantal acteurs voor toevoegen : " + vdb.getMovie(title,year).getActors().size());
vdb.addActor(actor,movie);
        Movie mov = vdb.getMovie(title,year);
        List<Actor> actorList = mov.getActors();
        assertEquals(1,actorList.size());
        System.out.println("aantal acteurs na toevoegen : " + vdb.getMovie(title,year).getActors().size());
    }

    @Test
    public void test_get_actor_met_parameters_familienaam_en_voornaam() throws Exception{
        addActorsTestKlasse();
        assertEquals(actor,vdb.getActor("Ian","Mc Kellen"));
    }

    @Test
    public void test_update_actor() throws Exception{
Actor act = actor;
        act.setGender(GenderPerson.FEMALE);
        vdb.updateActor(act,actor);
        List<Actor> actorList = vdb.getAllActors();
        printResultaatLijst(actorList);

        assertEquals(GenderPerson.FEMALE,vdb.getAllActors().get(0).getGender());
    }

    @Test
    public void test_delete_actor() throws Exception{
addActorsTestKlasse();
        vdb.deleteActor(actor);
        List<Actor> actorList = vdb.getAllActors();
        printResultaatLijst(actorList);

        assertNotEquals(1,vdb.getAllActors().get(0).getId());


    }



    @After
    public void tearDown() throws Exception {

    }

    /**
     * Aparte hulpmethodes
     */

    private void addActorTestKlasse(){
        vdb.addActor(actor);
    }

    private void addActorsTestKlasse(){
        vdb.addActor(actor);
        vdb.addActor(actor2);
    }

    private void addMovieTestKlasse(){
        vdb.addMovie(movie);

    }

    // <?> zorgt ervoor dat je eender welk type van lijst kan meegeven
    // http://stackoverflow.com/questions/11392380/generics-what-does-actually-mean
    private void printResultaatLijst(List<?> lijst ){

        for(int i = 0; i < lijst.size();i++){
            System.out.println(lijst.get(i));
        }

    }
}