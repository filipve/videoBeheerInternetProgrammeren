package domain.person;

import domain.Movie;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by filipve on 17/02/2016.
 */
@Entity
public class Actor extends Person {


    @OneToMany
    private List<Movie> moviesPlayedIn;

    public Actor(){
        super();
    }

    /*
    public Actor(String name, String familyName,
                 Age dateOfBirth, GenderPerson gender) {
        super(name,familyName,dateOfBirth,gender);
        this.moviesPlayedIn = new ArrayList<Movie>();
    }*/

    public Actor(String name, String familyName,
                 int dagGeboorte, int maandGeboorte, int jaarGeboorte, boolean geslacht) {
        super(name,familyName,dagGeboorte,maandGeboorte,jaarGeboorte,geslacht);
        this.moviesPlayedIn = new ArrayList<Movie>();
    }

    public List<Movie> getMoviesPlayedIn() {
        return moviesPlayedIn;
    }

    public void setMoviesPlayedIn(List<Movie> moviesPlayedIn) {
        this.moviesPlayedIn = moviesPlayedIn;
    }

    public void addMoviePlayedIn(Movie movie) {
        List<Movie> movies = getMoviesPlayedIn();
        movies.add(movie);
        setMoviesPlayedIn(movies);
    }


}
