package helperclasses;

/**
 * Created by filipve on 17/02/2016.
 */
public enum MovieRating {

    //http://www.ign.com/wikis/content-ratings/MPAA

    NOTRATED("NR"),
    GENERALAUDIENCE("G"),
    PARENTALGUIDANCE("PG"),
    PGTHIRTEEN("PG-13"),
    RESTRICTED("R"),
    NCSEVENTEEN("NC-17");

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    private String rating;

    MovieRating(String rating) {
        this.rating = rating;

    }

    @Override
    public String toString() {
        return getRating().toString();
    }
}

