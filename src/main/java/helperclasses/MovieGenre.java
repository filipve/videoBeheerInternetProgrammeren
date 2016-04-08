package helperclasses;

/**
 * Created by filipve on 17/02/2016.
 */
public enum MovieGenre {

    ACTION("Action"),
    ANIMATION("Animation"),
    ADVENTURE("Adventure"),
    COMEDY("Comedy"),
    CRIME("Crime"),
    DRAMA("Drama"),
    FANTASY("Fantasy"),
    HISTORICAL("Historical"),
    HISTORICALFICTION("Historical fiction"),
    HORROR("Horror"),
    MAGICALREALISM("Magical realism"),
    MYSTERY("Mystery"),
    PARANOID("Paranoid"),
    PHILOSOPHICAL("Philosophical"),
    POLITICAL("Political"),
    ROMANCE("Romance"),
    SAGA("Saga"),
    SATIRE("Satire"),
    SCIENCEFICTION("Science-fiction"),
    THRILLER("Thriller"),
    URBAN("Urban"),
    WESTERN("Western");

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    private String genre;

    MovieGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return getGenre().toString();
    }
}
