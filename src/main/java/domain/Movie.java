package domain;

import converter.MovieEvaluationConverter;
import domain.person.Actor;
import helperclasses.MovieEvaluation;
import helperclasses.MovieGenre;
import helperclasses.MovieRating;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by filipve on 17/02/2016.
 */

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Size(min=3,max = 80)
    private String title;

    //@NotNull
    //@Size(min = 3, max=40)
    @NotEmpty(message = "Please enter the name!")
    private String director;

    @NotNull
    private int jaar;

    @Enumerated(EnumType.STRING)
    private MovieGenre genre;

    @Enumerated(EnumType.STRING)
    private MovieRating rating;

    //@Convert(converter = MovieEvaluationConverter.class)
    @Enumerated(EnumType.STRING)
    private MovieEvaluation evaluation;

    private boolean seen;

    @OneToMany
    private List<Actor> actors;

public Movie(){

}

    public Movie(String title,String director,int jaar){
        setTitle(title);
        setDirector(director);
        setJaar(jaar);
    }

    public Movie(String title, String director,
                 int jaar, MovieGenre genre,
                 MovieRating rating, MovieEvaluation evaluation,
                 boolean seen) {
        setTitle(title);
        setDirector(director);
        setJaar(jaar);
        setGenre(genre);
        setRating(rating);
        setEvaluation(evaluation);
        setSeen(seen);
        this.actors = new ArrayList<Actor>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 0) {
            throw new DomainException("ID mag niet kleiner zijn dan 0");
        }

        this.id = id;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new DomainException("title cannot be null");
        }
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        /*
        if (director == null || director.isEmpty()) {
            throw new DomainException("director cannot be null or empty");
        }
        */

        this.director = director;
    }

    public int getJaar() {
        return jaar;
    }

    public void setJaar(int jaar) {
        if (jaar <= 0) throw new IllegalArgumentException("year cannot be 0 or smaller");
        this.jaar = jaar;
    }

    public MovieGenre getGenre() {
        return genre;
    }

    public void setGenre(MovieGenre genre) {

        if (genre == null) {
            throw new DomainException("Genre mag niet leeg zijn");
        }
        this.genre = genre;
    }

    public MovieRating getRating() {
        return rating;
    }

    public void setRating(MovieRating rating) {

        if (rating == null) {
            throw new DomainException("Rating cannot be null");
        }
        this.rating = rating;
    }

    public MovieEvaluation getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(MovieEvaluation evaluation) {
        if (evaluation == null) {
            throw new DomainException("MovieEvaluation cannot be empty");
        }
        this.evaluation = evaluation;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    public String gezienOfNiet() {
        return isSeen() ? "Ja" : "Nee";
        // return seen == true dan "Ja" anders "Nee"

    }

    public void addActor(Actor actor) {

        getActors().add(actor);
    }

    @Override
    public String toString() {
        return "Film: " + getTitle() + " met als regisseur: " + getDirector()
                + " - uitgebracht in het jaar: " + getJaar() + "\n" + " met als genre : " + getGenre().toString() +
                " heeft als rating: " + getRating().toString() + " en als evaluatie : "
                + getEvaluation().toString()
                + " en is gezien: " + gezienOfNiet();
    }

}
