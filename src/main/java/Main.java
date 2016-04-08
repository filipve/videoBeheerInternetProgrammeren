import db.VideoBeheerRelationalDatabase;
import domain.Movie;
import helperclasses.MovieEvaluation;
import helperclasses.MovieGenre;
import helperclasses.MovieRating;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by filip on 22/03/2016.
 */
public class Main {

    private static final String persistence_unit_name = "videobeheer";
    private static EntityManagerFactory factory;

    public static void main(String[] args){

        factory = Persistence.createEntityManagerFactory(persistence_unit_name);
        EntityManager em = factory.createEntityManager();
        //read the existing entries and write to console
        Query q = em.createQuery("select m from Movie m");

        Movie movie = new Movie();
        movie.setJaar(2001);
        movie.setDirector("Peter Jackson");
        movie.setEvaluation(MovieEvaluation.FIVESTARS);
        movie.setGenre(MovieGenre.ACTION);
        movie.setTitle("THE LORD OF THE RINGS : THE FELLOWSHIP OF THE RING");
        movie.setRating(MovieRating.GENERALAUDIENCE);
        movie.setSeen(false);

        Movie movie2 = new Movie();
        movie2.setJaar(2005);
        movie2.setDirector("dff");
        movie2.setEvaluation(MovieEvaluation.THREESTARS);
        movie2.setGenre(MovieGenre.HORROR);
        movie2.setTitle("hallo");
        movie2.setRating(MovieRating.PARENTALGUIDANCE);
        movie2.setSeen(false);

        VideoBeheerRelationalDatabase vdb = new VideoBeheerRelationalDatabase();
        vdb.addMovie(movie);
        vdb.addMovie(movie2);

        List<Movie> movieList = q.getResultList();
        for(Movie movies : movieList){
            System.out.println(movies.getId());
            System.out.println(movies.getDirector());
            System.out.println(movies.getEvaluation());
            System.out.println(movies.getGenre());
            System.out.println(movies.getJaar());
            System.out.println(movies.getTitle());
            System.out.println(movies.getRating());

        }

        System.out.println("size: " + movieList.size());



    }
}
