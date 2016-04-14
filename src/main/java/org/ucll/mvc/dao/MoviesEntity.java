package org.ucll.mvc.dao;

import javax.persistence.*;

/**
 * Created by filip on 21/03/2016.
 */
@Entity
@Table(name = "MOVIES", schema = "ADMIN", catalog = "")
public class MoviesEntity {
    private int id;
    private String titel;
    private String rating;
    private String jaar;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TITEL")
    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    @Basic
    @Column(name = "RATING")
    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "JAAR")
    public String getJaar() {
        return jaar;
    }

    public void setJaar(String jaar) {
        this.jaar = jaar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MoviesEntity that = (MoviesEntity) o;

        if (id != that.id) return false;
        if (titel != null ? !titel.equals(that.titel) : that.titel != null) return false;
        if (rating != null ? !rating.equals(that.rating) : that.rating != null) return false;
        if (jaar != null ? !jaar.equals(that.jaar) : that.jaar != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (titel != null ? titel.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (jaar != null ? jaar.hashCode() : 0);
        return result;
    }
}
